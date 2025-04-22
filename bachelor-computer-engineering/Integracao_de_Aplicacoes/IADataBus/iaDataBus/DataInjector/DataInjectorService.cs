using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.ServiceProcess;
using System.Text;
using DataInjector.meteo;
using System.IO;
using System.Xml.Schema;
using System.Xml;
using System.Threading;

namespace DataInjector {

	partial class DataInjectorService : ServiceBase {

		/* Default timer value in milisecs */
		private const double DEFAULT_QUERY_TIME = 3000;

		/* Path to config file */
		private const String XML_CONFIG_PATH = @"\iaDataBus\DataInjectorConfig.xml";

		/* Path to validation schema file */
		private const String SCHEMA_CONFIG_PATH = @"\iaDataBus\DataInjectorConfig.xsd";

		/* Timer that controls time between webservice queries*/
		private System.Timers.Timer queryTimer = new System.Timers.Timer(DEFAULT_QUERY_TIME);
		
		/* Config file watcher */
		private FileSystemWatcher xmlConfigWatcher = new FileSystemWatcher(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) + @"\iaDataBus\", "DataInjectorConfig.xsd");

		/* Webservice stub */
		private Service1 webservice = new Service1();

		/* Webservice URL*/
		private String serviceURL;

		/* Node list where data is going to be injected */
		private LinkedList<String> nodeURL = new LinkedList<String>();

		public DataInjectorService() {
			InitializeComponent();

			queryTimer.AutoReset = true;
			queryTimer.Elapsed += new System.Timers.ElapsedEventHandler(queryTick);

			xmlConfigWatcher.Changed += new FileSystemEventHandler(onConfigChanged);
			xmlConfigWatcher.NotifyFilter = NotifyFilters.LastWrite;
		}

		protected override void OnStart(string[] args) {
			readConfigurationXml();
			xmlConfigWatcher.EnableRaisingEvents = true;
			queryTimer.Start();
		}

		protected override void OnStop() {
			xmlConfigWatcher.EnableRaisingEvents = false;
			queryTimer.Stop();
		}

		private void xmlValidationHandler(object sender, ValidationEventArgs args) {
			StreamWriter log = new StreamWriter(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) + 
																					@"\iaDataBus\DataInjectorService.log", true);

			log.WriteLine("Reason: " + args.Message);
			log.Write(log.NewLine);
      log.Write("-------------------------------------");
      log.Close();
		}

		private void onConfigChanged(Object sender, FileSystemEventArgs args) {
			queryTimer.Stop();
			readConfigurationXml();
			queryTimer.Start();
		}

		private void readConfigurationXml() {
			XmlReader reader = null;

			try {
				XmlSchema schema = new XmlSchema();
				schema.SourceUri = Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) + SCHEMA_CONFIG_PATH;

				XmlReaderSettings settings = new XmlReaderSettings();
				settings.ValidationType = ValidationType.Schema;
				settings.Schemas.Add(schema);
				settings.ValidationEventHandler += new ValidationEventHandler(xmlValidationHandler);

				reader = XmlReader.Create(new XmlTextReader(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) + XML_CONFIG_PATH), settings);

				while (reader.Read()) {
					switch (reader.NodeType) {
						case XmlNodeType.Element:
							switch (reader.Name) {
								case "webservice":
									reader.Read();
									serviceURL = reader.Value;
									break;
								case "nodeurl":
									reader.Read();
									while (reader.NodeType != XmlNodeType.EndElement || reader.Name != "nodeurl") {
										reader.Read();
										switch (reader.NodeType) {
											case XmlNodeType.Text:
												nodeURL.AddLast(reader.Value);
												break;
										}
									}
									break;
								case "queryinterval":
									reader.Read();
									queryTimer.Interval = Double.Parse(reader.Value) * 1000;
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

		private void queryTick(Object sender, System.Timers.ElapsedEventArgs args) {
			lock (this) {
				String date = DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");

				foreach(String url in nodeURL) {
					new Thread(new ThreadStart(new InjectionWorker(webservice.ValoresActuais_GetTemperatura(), 
																												webservice.ValoresActuais_GetHumidade(), 
																												webservice.ValoresActuais_GetVelocidadeVento(),
																												webservice.ValoresActuais_GetRadiacaoSolar(), 
																												webservice.ValoresActuais_GetPressaoAtmosferica(), 
																												url, date).run)).Start();
				}
			}
		}
	}
}
