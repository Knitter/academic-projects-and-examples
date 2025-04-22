using System;
using System.Xml;
using System.Collections.Generic;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.IO;

public class Node {
	private String url;
	private String[] dataTypes;
	private LinkedList<string> registeredTypes;

	public Node(String url, String[] validTypes) {
		this.url = url;
		this.dataTypes = validTypes;
		this.registeredTypes = new LinkedList<String>();
	}

	public String Url {
		get { return url; }
		set {
			this.url = value;
		}
	}

	public void addType(String newType) {
		bool validType = false;

		foreach (String str in dataTypes) {
			if (str == newType) {
				validType = true;
				break; 
			}
		}
		
		if (validType) {
			registeredTypes.AddLast(newType);
		}

	}

	public void removeType(String type) {
		registeredTypes.Remove(type);
	}

	public string getSubscribedTypesXML() {
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

		foreach (string str in registeredTypes) {
			auxElem = xmlDoc.CreateElement("", "type", "");
			auxText = xmlDoc.CreateTextNode(str);
			auxElem.AppendChild(auxText);
			xmlElem.AppendChild(auxElem);
		}

		xmlDoc.Save(sw);
		return sw.ToString();
	}

	public XmlDocument addXMLNode(XmlDocument xmlDoc) {
		XmlElement xmlelem;
		XmlText xmltext;

		//let's add the node as another element (child of the root)
		xmlelem=xmlDoc.CreateElement("node");
		xmltext=xmlDoc.CreateTextNode(this.url.ToString());
		xmlelem.AppendChild(xmltext);
		xmlDoc.ChildNodes.Item(1).AppendChild(xmlelem);
		
		return xmlDoc;
	}
}
