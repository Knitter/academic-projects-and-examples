using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.ServiceProcess;
using System.IO;
using System.Xml.Schema;
using System.Xml;

namespace DataInjectorConfig {

	public partial class DataInjectorConfig : Form {

		private bool serviceInstalled = false;

		private const String XML_CONFIG_PATH = @"\iaDataBus\DataInjectorConfig.xml";
		private const String SCHEMA_CONFIG_PATH = @"\iaDataBus\DataInjectorConfig.xsd";

		public DataInjectorConfig() {
			InitializeComponent();
			ServiceController[] all = ServiceController.GetServices();
			for (int i = 0; i < all.Length; i++) {
				if (all[i].ServiceName.Equals("DataInjectorService")) {
					serviceInstalled = true;
					break;
				}
			}
		}

		private void btnAddHost_Click(object sender, EventArgs e) {
			if (txtHostName.Text.Length > 0) {
				lstHosts.Items.Add(txtHostName.Text);
				if (!btnRemoveHost.Enabled) {
					btnRemoveHost.Enabled = true;
				}
				btnSave.Enabled = true;
			}
		}

		private void btnCancel_Click(object sender, EventArgs e) {
			this.Close();
		}

		private void btnSave_Click(object sender, EventArgs e) {
			StreamWriter swout = null;
			try {
				swout = new StreamWriter(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) +
																XML_CONFIG_PATH, false, Encoding.UTF8);

				swout.WriteLine("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
				swout.WriteLine("<injectorconfig>");
				swout.WriteLine("<webservice>" + txtWebServiceaddr.Text + "</webservice>");
				if (lstHosts.Items.Count > 0) {
					swout.WriteLine("<nodeurl>");
					for (int i = 0; i < lstHosts.Items.Count; i++) {
						swout.WriteLine("<url>" + lstHosts.Items[i].ToString() + "</url>");
					}
					swout.WriteLine("</nodeurl>");
				}
				swout.WriteLine("<queryinterval>" + Decimal.ToInt32(spinnerQueryTime.Value) + "</queryinterval>");
				swout.WriteLine("</injectorconfig>");
				swout.Flush();
				btnSave.Enabled = false;
			} catch (Exception ex) {
				MessageBox.Show(this, "Erro ao gravar o ficheiro!");
			} finally {
				if (swout != null) {
					swout.Close();
				}
			}
		}

		private void btnStopService_Click(object sender, EventArgs e) {
			if (serviceInstalled) {
				serviceController.Stop();
				serviceOff();
			}
		}

		private void btnStartService_Click(object sender, EventArgs e) {
			if (serviceInstalled) {
				serviceController.Start();
				serviceOn();
			}
		}

		private void serviceOn() {
			lblServiceStateResult.Text = "A Executar";
			lblServiceStateResult.ForeColor = Color.Green;
			btnStartService.Enabled = false;
			btnStopService.Enabled = true;
		}

		private void serviceOff() {
			lblServiceStateResult.Text = "Parado";
			lblServiceStateResult.ForeColor = Color.Red;
			btnStopService.Enabled = false;
			btnStartService.Enabled = true;
		}

		private void DataInjectorConfig_Load(object sender, EventArgs e) {
			if (File.Exists(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) + XML_CONFIG_PATH)) {
				readConfigurationXml();
			}

			if (serviceInstalled) {
				switch (serviceController.Status) {
					case ServiceControllerStatus.Running:
						serviceOn();
						break;
					case ServiceControllerStatus.Stopped:
						serviceOff();
						break;
					default:
						lblServiceStateResult.ForeColor = Color.Violet;
						lblServiceStateResult.Text = serviceController.Status.ToString();
						btnStartService.Enabled = false;
						btnStopService.Enabled = false;
						break;
				}
			} else {
				lblServiceStateResult.ForeColor = Color.Turquoise;
				lblServiceStateResult.Text = "O serviço não se encontra instalado";
				btnStartService.Enabled = false;
				btnStopService.Enabled = false;
			}
			if (lstHosts.Items.Count == 0) {
				btnRemoveHost.Enabled = false;
			}
			btnSave.Enabled = false;
		}

		private void btnRemoveHost_Click(object sender, EventArgs e) {
			lstHosts.Items.Remove(lstHosts.SelectedItem);
			if (lstHosts.Items.Count == 0) {
				btnRemoveHost.Enabled = false;
			}
			btnSave.Enabled = true;
		}

		private void spinnerQueryTime_ValueChanged(object sender, EventArgs e) {
			btnSave.Enabled = true;
		}

		private void txtWebServiceaddr_TextChanged(object sender, EventArgs e) {
			if (txtWebServiceaddr.Text.Length > 0) {
				btnSave.Enabled = true;
			}
		}

		private void xmlValidationHandler(object sender, ValidationEventArgs args) {
			StreamWriter log = new StreamWriter(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) +
																		@"\iaDataBus\DataInjectorConfig.log", true);

			log.WriteLine("Reason: " + args.Message);
			log.Write(log.NewLine);
			log.Write("-------------------------------------");
			log.Close();
		}

		private void readConfigurationXml() {

			XmlSchema schema = new XmlSchema();
			schema.SourceUri = Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) + SCHEMA_CONFIG_PATH;

			XmlReaderSettings settings = new XmlReaderSettings();
			settings.ValidationType = ValidationType.Schema;
			settings.Schemas.Add(schema);
			settings.ValidationEventHandler += new ValidationEventHandler(xmlValidationHandler);

			XmlReader reader = XmlReader.Create(new XmlTextReader(Environment.GetFolderPath(Environment.SpecialFolder.ProgramFiles) + XML_CONFIG_PATH), settings);

			while (reader.Read()) {
				switch (reader.NodeType) {
					case XmlNodeType.Element:
						switch (reader.Name) {
							case "webservice":
								reader.Read();
								txtWebServiceaddr.Text = reader.Value;
								break;
							case "nodeurl"://TODO: check for the notation used, host name VS. ip dot number notation.
								reader.Read();
								while (reader.NodeType != XmlNodeType.EndElement || reader.Name != "nodeurl") {
									reader.Read();
									switch (reader.NodeType) {
										case XmlNodeType.Text:
											lstHosts.Items.Add(reader.Value);
											break;
									}
								}
								break;
							case "queryinterval":
								reader.Read();
								spinnerQueryTime.Value = Decimal.Parse(reader.Value);
								break;
						}
						break;
				}
			}
			reader.Close();
		}
	}
}