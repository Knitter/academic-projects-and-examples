using System;
using System.IO;
using System.Xml;
using System.Xml.Schema;
using System.Collections.Generic;
using System.Text;
using System.Web;
using System.Web.Services;
using System.Web.Services.Protocols;
using System.Net;
using System.Data.SqlClient;
using System.Threading;

[WebService(Namespace = "http://iadatabus.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
public class Service : System.Web.Services.WebService {
	private String[] allDataTypes = { "Temperatura", "Humidade", "Vento", "Radiacao", "Pressao" };
	private LinkedList<String> dataTypes = new LinkedList<string>();

	private Dictionary<string, Node> parents = new Dictionary<string, Node>();
	private Dictionary<string, Node> children = new Dictionary<string, Node>();

	private string url;

	private const string SERVICE_NAME = @"/NodeService.asmx";

	private const String MESSAGE_SCHEMA_PATH = @"\iaDataBus\MessageSchema.xsd";

	private LinkedList<String> temperature = new LinkedList<String>();
	private LinkedList<String> humidity = new LinkedList<String>();
	private LinkedList<String> windSpeed = new LinkedList<String>();
	private LinkedList<String> radiation = new LinkedList<String>();
	private LinkedList<String> pressure = new LinkedList<String>();

	private String messageID;
	private String dataType;
	private String dataValue;
	private LinkedList<String> urlToSendData = new LinkedList<String>();

	SqlConnection conn = new SqlConnection(@"Integrated Security=SSPI;Persist Security Info=False;User ID=TESTECFBC\ASPNET;Initial Catalog=webservice;Data Source=.\SQLEXPRESS");
	SqlCommand command = new SqlCommand();

	public Service() {
		//Uncomment the following line if using designed components 
		//InitializeComponent(); 
		StringBuilder text = new StringBuilder(System.Configuration.ConfigurationManager.AppSettings["NodeService.NodeService"]);
		text.Replace(SERVICE_NAME, "");//Clean url by removing the service name
		url = text.ToString();

		if (Application["parents"] != null)
			parents = (Dictionary<string, Node>)Application["parents"];

		if (Application["children"] != null)
			children = (Dictionary<string, Node>)Application["children"];

		if (Application["dataTypes"] != null)
			dataTypes = (LinkedList<string>)Application["dataTypes"];

		command.Connection = conn;
	}

	/*
	 * Allow Node Config to set another parent in the node
	 * @returns State code
	 * - On success: "0000"
	 * - If parent already registered: "1000"
	 * - If parent Url Malformed: "1001"
	 * - If parent not an Node webservice: "1002"
	 * - If parent returned a Soap exception: "1003"
	 */
	[WebMethod]
	public string setParent(string url) {
		string statusCode = "";

		try {
			//Test if the url is really from a Node webservice 
			NodeService.Service node = new NodeService.Service();
			node.Url = url + SERVICE_NAME;

			//Try and register with the parent
			statusCode = node.Register(this.url);
			if (statusCode == "0000") {
				parents.Add(url, new Node(url, allDataTypes));

				saveData();
			}
		} catch (UriFormatException ex) {
			command.Connection = conn;
			//url is not formated correctly
			statusCode = "1001";//Url not formated correctly
		} catch (WebException ex) {
			statusCode = "1002";//Webservice did not implement the method
		} catch (SoapException ex) {
			statusCode = "1003" + this.url;//Webservice failed to respond
		}

		return statusCode;
	}

	[WebMethod]
	public void addDataType(string type) {
		foreach (string checkType in allDataTypes) {
			if (checkType == type && !dataTypes.Contains(type)) {
				dataTypes.AddLast(type);

				saveData();
				break;
			}
		}
	}

	[WebMethod]
	public void removeDataType(string type) {
		if (dataTypes.Contains(type)) {
			dataTypes.Remove(type);

			saveData();
		}
	}

	/*
	 * Allow other nodes to register as children
	 * @returns State code
	 * - On success: "0000"
	 * - If child already register: "1000"
	 * - If child Url Malformed: "1001"
	 * - If child not an Node webservice: "1002"
	 * - If child webservice failed to respond: "1003"
	 */
	[WebMethod]
	public String Register(String url) {
		String statusCode = "0000"; //Assume success

		try {
			//Test if the url is really from a Node webservice 
			NodeService.Service node = new NodeService.Service();
			node.Url = url + SERVICE_NAME;
			node.QueryServers(); //Assume that if the QueryServers method responds the webservice is functioning

			if (!children.ContainsKey(url)) {
				children.Add(url, new Node(url, allDataTypes));
			} else {
				statusCode = "1000";//Child already existes
			}

			Application.Lock();
			//System.UriFormatException
			//System.Net.WebException
			Application["children"] = children;
		} catch (UriFormatException e) {
			//url is not formated correctly
			statusCode = "1001";//Url not formated correctly
		} catch (WebException e) {
			statusCode = "1002";//Webservice did not implement the method
		} catch (SoapException ex) {
			statusCode = "1003 register" + url;//Webservice failed to respond
		}

		return statusCode;
	}

	/*
	 * Allow child nodes to subscribe data types
	 * Allowed data types:
	 *  - Temperatura (Temperatura)
	 *  - Humidade (Humidade)
	 *  - Vento (Velocidade do vento)
	 *  - Radiacao (Radiação Solar)
	 *  - Pressao (Pressão atmosférica)
	 * 
	 * Returns:
	 * - On success: "0000"
	 * - Node (child) not registered: "1004"
	 * - Service not available: "1005"
	 */
	[WebMethod]
	public string Subscribe(string url, string service) {
		string statusCode = "0000";
		Node child;

		/*
		 * - Node (child) not registered: "1004"
		 * - Service not available: "1005"
		 */
		try {
			if (children.ContainsKey(url)) {
				if (dataTypes.Contains(service)) {
					children.TryGetValue(url, out child);
					child.addType(service);

					switch (service.ToLower()) {
						case "temperatura":
							temperature.AddLast(url);
							break;
						case "humidade":
							humidity.AddLast(url);
							break;
						case "vento":
							windSpeed.AddLast(url);
							break;
						case "radiacao":
							radiation.AddLast(url);
							break;
						case "pressao":
							pressure.AddLast(url);
							break;
					}
				} else
					statusCode = "1005";
			} else
				statusCode = "1004" + url;
		} catch (Exception ex) {
			statusCode = ex.ToString();
		}

		return statusCode;
	}


	/*
	 * Allow child nodes to unsubscribe data types
	 * Allowed data types:
	 *  - Temperatura (Temperatura)
	 *  - Humidade (Humidade)
	 *  - Vento (Velocidade do vento)
	 *  - Radiacao (Radiação Solar)
	 *  - Pressao (Pressão atmosférica)
	 * 
	 * Returns:
	 * - On success: "0000"
	 * - Node (child) not registered: "1004"
	 */
	[WebMethod]
	public string unSubscribe(string url, string service) {
		string statusCode = "0000";
		Node child;

		/*
		 * - Node (child) not registered: "1004"
		 */
		try {
			if (children.ContainsKey(url)) {
				children.TryGetValue(url, out child);
				child.removeType(service);

				switch (service.ToLower()) {
					case "temperatura":
						temperature.Remove(url);
						break;
					case "humidade":
						humidity.Remove(url);
						break;
					case "vento":
						windSpeed.Remove(url);
						break;
					case "radiacao":
						radiation.Remove(url);
						break;
					case "pressao":
						pressure.Remove(url);
						break;
				}
			}
			else
				statusCode = "1004";
		}
		catch (Exception ex) {
			statusCode = ex.ToString();
		}

		return statusCode;
	}










	/*
	 * Recieves data from parent
	 */
	[WebMethod]
	public string RecData(string xml) {
		String result = "0000";
		StringWriter sw = new StringWriter();

		StreamWriter log = new StreamWriter(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) +
																					@"\iaDataBus\node.log", true);

		log.WriteLine("Reason: " + xml);
		log.Write(log.NewLine);
		log.Write("-------------------------------------");

		readXmlData(xml);

		String cmmTextMeteo = "INSERT INTO meteo_data(xml_date, data_value, data_type) VALUES('" + messageID + "', '" + dataValue + "', '" + dataType + "')";

		XmlDocument doc = new XmlDocument();
		doc.Load(new StringReader(xml));

		XmlElement element = doc.CreateElement("node");
		XmlText value = doc.CreateTextNode(this.url + SERVICE_NAME);
		XmlNodeList list = doc.SelectNodes("/message/trace");

		element.AppendChild(value);
		list.Item(0).AppendChild(element);

		String newXml = doc.OuterXml;

		command.CommandText = cmmTextMeteo;
		SqlTransaction trans = null;
		try {
			log.Write(log.NewLine);
			log.Write("START");
			log.Write(log.NewLine);
			log.Flush();

			conn.Open();

			log.Write(log.NewLine);
			log.Write("OPEN");
			log.Write(log.NewLine);
			log.Flush();

			trans = conn.BeginTransaction();
			command.Transaction = trans;

			log.Write(log.NewLine);
			log.Write("TRANS");
			log.Write(log.NewLine);
			log.Flush();

			//Insert into meteo_data
			command.ExecuteNonQuery();

			log.Write(log.NewLine);
			log.Write("QUERY");
			log.Write(log.NewLine);
			log.Flush();

			//Prepare base sql for trace insertion
			String baseTraceInsert = "INSERT INTO trace(message_id, node) VALUES('" + messageID + "', '" + dataType + "', ";

			log.Write(log.NewLine);
			log.Write("TRACE");
			log.Write(log.NewLine);
			log.Flush();

			//Insert trace values into trace table. Note that this node's address is not stored into the DB.
			foreach (String traceNode in urlToSendData) {
				command.CommandText = baseTraceInsert + traceNode + "')";
				command.ExecuteNonQuery();
			}

			log.Write(log.NewLine);
			log.Write("DONE TRACE");
			log.Write(log.NewLine);
			log.Flush();

			trans.Commit();

			log.Write(log.NewLine);
			log.Write("COMMIT");
			log.Write(log.NewLine);
			log.Flush();

		} catch (Exception ex) {
			//Though it's not to be expected.
			log.Write(log.NewLine);
			log.Write("ROLLBACK" + ex.Message);
			log.Write(log.NewLine);
			log.Flush();
			
			if (trans != null)
				trans.Rollback();

			result = "rollback" + ex.Message;
		} finally {
			conn.Close();

			log.Write(log.NewLine);
			log.Write("CLOSE");
			log.Write(log.NewLine);
			log.Flush();

			log.Close();
		}

		switch (dataType) {
			case "temperatura":
				foreach (String nodeToCall in temperature) {
					new Thread(new ThreadStart(new InjectionWorker(newXml, nodeToCall).run)).Start();
					log.Write(log.NewLine);
					log.Write("temp:  " + nodeToCall);
					log.Write(log.NewLine);
					log.Flush();
				}
				break;
			case "humidade":
				foreach (String nodeToCall in humidity) {
					new Thread(new ThreadStart(new InjectionWorker(newXml, nodeToCall).run)).Start();
					log.Write(log.NewLine);
					log.Write("humi:  " + nodeToCall);
					log.Write(log.NewLine);
					log.Flush();
				}
				break;
			case "pressao":
				foreach (String nodeToCall in pressure) {
					new Thread(new ThreadStart(new InjectionWorker(newXml, nodeToCall).run)).Start();
					log.Write(log.NewLine);
					log.Write("press:  " + nodeToCall);
					log.Write(log.NewLine);
					log.Flush();
				}
				break;
			case "vento":
				foreach (String nodeToCall in windSpeed) {
					new Thread(new ThreadStart(new InjectionWorker(newXml, nodeToCall).run)).Start();
					log.Write(log.NewLine);
					log.Write("wind:  " + nodeToCall);
					log.Write(log.NewLine);
					log.Flush();
				}
				break;
			case "radiacao":
				foreach (String nodeToCall in radiation) {
					new Thread(new ThreadStart(new InjectionWorker(newXml, nodeToCall).run)).Start();
					log.Write(log.NewLine);
					log.Write("radi:  " + nodeToCall);
					log.Write(log.NewLine);
					log.Flush();
				}
				break;
		}
		return result;
	}

	/*
	 * Allow children to query for available data types
	 * @see Subscribe
	 */
	[WebMethod]
	public string QueryServerSubscribedDataServices(string url) {
		if (children.ContainsKey(url)) {
			Node child;
			if (children.TryGetValue(url, out child))
				return child.getSubscribedTypesXML();
		}
		return "";
	}

	/*
	 * Allow children to query for available data types
	 * @see Subscribe
	 */
	[WebMethod]
	public string QueryDataService() {
		XmlDocument xmlDoc;
		XmlNode xmlNode;
		XmlElement xmlElem, auxElem;
		XmlText auxText;
		StringWriter sw = new StringWriter();

		xmlDoc = new XmlDocument();

		//let's add the XML declaration section
		xmlNode = xmlDoc.CreateNode(XmlNodeType.XmlDeclaration, "", "");

		xmlDoc.AppendChild(xmlNode);
		//let's add the root element
		xmlElem = xmlDoc.CreateElement("", "types", "");
		xmlDoc.AppendChild(xmlElem);

		foreach (string str in dataTypes) {
			auxElem = xmlDoc.CreateElement("", "type", "");
			auxText = xmlDoc.CreateTextNode(str);
			auxElem.AppendChild(auxText);
			xmlElem.AppendChild(auxElem);
		}

		xmlDoc.Save(sw);
		return sw.ToString();
	}

	/*
	 * Returns children nodes information
	 * @see Register
	 */
	[WebMethod]
	public String QueryServers() {
		XmlDocument xmlDoc;
		XmlNode xmlNode;
		XmlElement xmlElem;
		StringWriter sw = new StringWriter();

		xmlDoc = new XmlDocument();

		//let's add the XML declaration section
		xmlNode = xmlDoc.CreateNode(XmlNodeType.XmlDeclaration, "", "");

		xmlDoc.AppendChild(xmlNode);
		//let's add the root element
		xmlElem = xmlDoc.CreateElement("", "nodes", "");
		xmlDoc.AppendChild(xmlElem);

		//Run all child nodes and call addXMLNode
		foreach (string key in children.Keys) {
			Node node = children[key];
			xmlDoc = node.addXMLNode(xmlDoc);
		}

		xmlDoc.Save(sw);

		return sw.ToString();
	}

	/*
	 * Returns my parents children node addresses (TODO: My brothers then?!)
	 * @see Register
	 */
	[WebMethod]
	public string QueryParentServers() {
		XmlDocument xmlDoc;
		XmlNode xmlNode;
		XmlElement xmlElem;
		StringWriter sw = new StringWriter();

		xmlDoc = new XmlDocument();

		//let's add the XML declaration section
		xmlNode = xmlDoc.CreateNode(XmlNodeType.XmlDeclaration, "", "");

		xmlDoc.AppendChild(xmlNode);
		//let's add the root element
		xmlElem = xmlDoc.CreateElement("", "nodes", "");
		xmlDoc.AppendChild(xmlElem);

		//Run all parent nodes and call addXMLNode
		foreach (string key in parents.Keys) {
			Node node = parents[key];
			xmlDoc = node.addXMLNode(xmlDoc);
		}

		xmlDoc.Save(sw);

		return sw.ToString();
	}

	private void saveData() {
		Application.Lock();

		Application["parents"] = parents;

		Application["children"] = children;

		Application["dataTypes"] = dataTypes;
	}

	private void xmlValidationHandler(Object sender, System.Xml.Schema.ValidationEventArgs args) {
		//TODO:  write log file
	}

	private void readXmlData(String xml) {
		XmlReader reader = null;
		urlToSendData.Clear();

		try {
			XmlSchema schema = new XmlSchema();
			schema.SourceUri = Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) + MESSAGE_SCHEMA_PATH;

			XmlReaderSettings settings = new XmlReaderSettings();
			settings.ValidationType = ValidationType.Schema;
			settings.Schemas.Add(schema);
			settings.ValidationEventHandler += new ValidationEventHandler(xmlValidationHandler);

			reader = XmlReader.Create(new StringReader(xml));

			while (reader.Read()) {
				switch (reader.NodeType) {
					case XmlNodeType.Element:
						switch (reader.Name) {
							case "type":
								reader.Read();
								if (reader.Value != "data") {
									return;
								}
								break;
							case "id":
								reader.Read();
								messageID = reader.Value;
								break;
							case "datatype":
								reader.Read();
								dataType = reader.Value;
								break;
							case "datavalue":
								reader.Read();
								dataValue = reader.Value;
								break;
							case "trace":
								reader.Read();
								while (reader.NodeType != XmlNodeType.EndElement || reader.Name != "trace") {
									reader.Read();
									if (reader.NodeType == XmlNodeType.Text) {
										urlToSendData.AddLast(reader.Value);
									}
								}
								break;
						}
						break;
				}
			}
		} catch (Exception ex) {
			//ignore
		} finally {
			if (reader != null) {
				reader.Close();
			}
		}
	}
}
