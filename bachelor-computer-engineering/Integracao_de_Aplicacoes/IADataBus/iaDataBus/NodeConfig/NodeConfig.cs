using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Xml;
using System.IO;
using System.Web.Services.Protocols;

namespace NodeConfig {
	public partial class NodeConfig : Form {

		private bool readingServices = false;
		private string url;
		private String[] allDataServices = { "Temperatura", "Humidade", "Vento", "Radiacao", "Pressao" };
		private LinkedList<string> lastDataServices = new LinkedList<string>();
		private LinkedList<string> lastParentDataServices = new LinkedList<string>();
		private const string SERVICE_NAME = @"/NodeService.asmx";
		NodeService.Service node = new NodeService.Service();
		NodeService.Service parentNode = new NodeService.Service();

		public NodeConfig() {
			InitializeComponent();
		}

		public string Url {
			get { return url; }
			set {
				url = value;

				this.Text = "Node Config - " + url;

				node.Url = url + ServiceName;

				readWebServiceState();
			}
		}

		public string ServiceName {
			get { return SERVICE_NAME; }
		}

		private void readWebServiceState() {
			readNodeServices();
			readParentNodes();
			readChildNodes();	
		}

		private void readNodeServices() {
			string dataServices = node.QueryDataService();

			readingServices = true;

			chkAirTemperature.Checked = false;
			chkHumidity.Checked = false;
			chkPressure.Checked = false;
			chkRadiation.Checked = false;
			chkWindSpeed.Checked = false;

			lastDataServices.Clear();

			XmlTextReader reader = new XmlTextReader(new StringReader(dataServices));
			while (reader.Read()) {
				if (reader.NodeType == XmlNodeType.Text) {
					switch (reader.Value) {
						case "Temperatura":
							chkAirTemperature.Checked = true;
							lastDataServices.AddLast("Temperatura");
							break;

						case "Humidade":
							chkHumidity.Checked = true;
							lastDataServices.AddLast("Humidade");
							break;

						case "Vento":
							chkWindSpeed.Checked = true;
							lastDataServices.AddLast("Vento");
							break;

						case "Radiacao":
							chkRadiation.Checked = true;
							lastDataServices.AddLast("Radiacao");
							break;

						case "Pressao":
							chkPressure.Checked = true;
							lastDataServices.AddLast("Pressao");
							break;
					}
				}
			}
			btnSubmitServices.Enabled = false;

			readingServices = false;
		}

		private void readParentNodeServices(string parentUrl) {
			string dataServices;
			LinkedList<string> subscribedServices = new LinkedList<string>();

			parentNode.Url = parentUrl + SERVICE_NAME;
			dataServices = parentNode.QueryServerSubscribedDataServices(this.url);

			if (dataServices != "") {
				XmlTextReader reader = new XmlTextReader(new StringReader(dataServices));
				while (reader.Read()) {
					if (reader.NodeType == XmlNodeType.Text) {
						subscribedServices.AddLast(reader.Value);
					}
				}

				dataServices = "";
				dataServices = parentNode.QueryDataService();

				chkParentAirTemperature.Checked = chkParentHumidity.Checked =
				chkParentPressure.Checked = chkParentRadiation.Checked =
				chkParentWindSpeed.Checked = false;

				chkParentAirTemperature.Font = chkParentHumidity.Font =
				chkParentPressure.Font = chkParentRadiation.Font =
				chkParentWindSpeed.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));

				reader = new XmlTextReader(new StringReader(dataServices));
				while (reader.Read()) {
					if (reader.NodeType == XmlNodeType.Text) {
						switch (reader.Value) {
							case "Temperatura":
								chkParentAirTemperature.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));

								if (subscribedServices.Contains(reader.Value))
									chkParentAirTemperature.Checked = true;
								break;

							case "Humidade":
								chkParentHumidity.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));

								if (subscribedServices.Contains(reader.Value))
									chkParentHumidity.Checked = true;
								break;

							case "Vento":
								chkParentWindSpeed.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));

								if (subscribedServices.Contains(reader.Value))
									chkParentWindSpeed.Checked = true;
								break;

							case "Radiacao":
								chkParentRadiation.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));

								if (subscribedServices.Contains(reader.Value))
									chkParentRadiation.Checked = true;
								break;

							case "Pressao":
								chkParentPressure.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));

								if (subscribedServices.Contains(reader.Value))
									chkParentPressure.Checked = true;
								break;
						}
					}
				}
			}
		}

		private void readParentNodes() {
			//Load parent nodes
			string parents = node.QueryParentServers();

			lbSubscribed.Items.Clear();
			cbParentUrls.Items.Clear();

			XmlTextReader reader = new XmlTextReader(new StringReader(parents));
			while (reader.Read()) {
				if (reader.NodeType == XmlNodeType.Text) {
					lbSubscribed.Items.Add(reader.Value.ToString());
					cbParentUrls.Items.Add(reader.Value);
				}
			}
		}

		private void readChildNodes() {
			//Load child nodes
			string children = node.QueryServers();

			lbRegistered.Items.Clear();

			XmlTextReader reader = new XmlTextReader(new StringReader(children));
			while (reader.Read()) {
				if (reader.NodeType == XmlNodeType.Text) {
					lbRegistered.Items.Add(reader.Value);
				}
			}
		}

		private void MenuChooseNode_Click(object sender, EventArgs e) {
			loadChooser();
		}

		private void fecharToolStripMenuItem_Click(object sender, EventArgs e) {
			Application.Exit();
		}

		private void NodeConfig_Load(object sender, EventArgs e) {
			loadChooser();
			this.Size = new Size(this.Size.Width, 190);
			btnSubscribeParent.Tag = "";
		}

		private void loadChooser() {
			ChooseNode nodeChooser = new ChooseNode(this);
			nodeChooser.ShowDialog();
		}

		private void tabControl1_SelectedIndexChanged(object sender, EventArgs e) {
			switch(((TabControl)sender).SelectedIndex) {
				case 0:
					this.Size = new Size(this.Size.Width, 190);
					break;
				case 1:
					if (cbParentUrls.SelectedIndex == -1)
						this.Size = new Size(this.Size.Width, 111);
					else
						this.Size = new Size(this.Size.Width, 232);
					break;
				case 2:
					this.Size = new Size(this.Size.Width, 435);
					break;
			}
		}

		private void checkedChanged() {
			if (!readingServices) {
				bool servicesChanged = false, itemSet = false;

				foreach (string str in allDataServices) {
					switch (str) {
						case "Temperatura":
							if (lastDataServices.Contains(str) == !chkAirTemperature.Checked) {
								servicesChanged = true;
							}
							itemSet = chkAirTemperature.Checked;
							break;

						case "Humidade":
							if (lastDataServices.Contains(str) == !chkHumidity.Checked) {
								servicesChanged = true;
							}
							itemSet = chkHumidity.Checked;
							break;

						case "Vento":
							if (lastDataServices.Contains(str) == !chkWindSpeed.Checked) {
								servicesChanged = true;
							}
							itemSet = chkWindSpeed.Checked;
							break;

						case "Radiacao":
							if (lastDataServices.Contains(str) == !chkRadiation.Checked) {
								servicesChanged = true;
							}
							itemSet = chkRadiation.Checked;
							break;

						case "Pressao":
							if (lastDataServices.Contains(str) == !chkPressure.Checked) {
								servicesChanged = true;
							}
							itemSet = chkPressure.Checked;
							break;
					}
				}

				btnSubmitServices.Enabled = servicesChanged;
			}
		}

		private void chkWindSpeed_CheckedChanged(object sender, EventArgs e) {
			checkedChanged();
		}

		private void chkHumidity_CheckedChanged(object sender, EventArgs e) {
			checkedChanged();
		}

		private void chkRadiation_CheckedChanged(object sender, EventArgs e) {
			checkedChanged();
		}

		private void chkPressure_CheckedChanged(object sender, EventArgs e) {
			checkedChanged();
		}

		private void chkAirTemperature_CheckedChanged(object sender, EventArgs e) {
			checkedChanged();
		}

		private void btnSubmitServices_Click(object sender, EventArgs e) {
			bool state = false;

			lblSubmitServices.Visible = true;

			Application.DoEvents();

			btnSubmitServices.Enabled = false;
			Cursor.Current = Cursors.WaitCursor;

			foreach (string str in allDataServices) {
				switch (str) {
					case "Temperatura":
						state = chkAirTemperature.Checked;
						break;

					case "Humidade":
						state = chkHumidity.Checked;
						break;

					case "Vento":
						state = chkWindSpeed.Checked;
						break;

					case "Radiacao":
						state = chkRadiation.Checked;
						break;

					case "Pressao":
						state = chkPressure.Checked;
						break;
				}

				if (state) {
					node.addDataType(str);
					lastDataServices.AddLast(str);
				}
				else {
					node.removeDataType(str);
					lastDataServices.Remove(str);
				}
			}
			lblSubmitServices.Visible = false;
		}

		private void cbParentUrls_SelectedIndexChanged(object sender, EventArgs e) {
			ComboBox cb = cbParentUrls;

			if (cb.SelectedIndex != -1) {
				cb.DropDownStyle = ComboBoxStyle.DropDownList;
				btnSubscribeParent.Text = "Novo nodo";
				btnSubscribeParent.Tag = "novo";
				this.Size = new Size(this.Size.Width, 232);

				//Read parent available services
				readParentNodeServices(cb.Items[cb.SelectedIndex].ToString());
			}
			else {
				btnSubscribeParent.Text = "Subscrever";
				btnSubscribeParent.Tag = "";
				this.Size = new Size(this.Size.Width, 111);
			}
		}

		private void btnSubscribeParent_Click(object sender, EventArgs e) {
			string result = "", parentUrl = "";

			Cursor.Current = Cursors.WaitCursor;

			if (btnSubscribeParent.Tag.ToString() == "novo") {
				cbParentUrls.DropDownStyle = ComboBoxStyle.DropDown;
				cbParentUrls.SelectedIndex = -1;
				cbParentUrls.Focus();
			}
			else {
				cbParentUrls.SelectAll();
				parentUrl = cbParentUrls.SelectedText;

				if (parentUrl != url)
					result = node.setParent(parentUrl);
				else
					result = "Não pode subscrever o próprio nó.";

				/*
				 * - On success: "0000"
				 * - If parent already registered: "1000"
				 * - If parent Url Malformed: "1001"
				 * - If parent not an Node webservice: "1002"
				 * - If parent returned a Soap exception: "1003"
				 */
				switch (result) {
					case "0000":
						result = "O nodo foi bem subscrito";
						readParentNodes();
						cbParentUrls.SelectedIndex = cbParentUrls.Items.Count - 1;

						subscribeServices(parentUrl);

						break;
					case "1000":
						result = "O nodo fornecido já se encontra subcrito";
						break;
					case "1001":
						result = "O url do nodo não é válido!";
						break;
					case "1002":
						result = "O nodo não é um webservice do tipo Node.";
						break;
					case "1003":
						result = "Ocorreu um erro ao tentar contactar o webservice.";
						break;
				}
				
				MessageBox.Show(result);
			}
		}

		private void subscribeServices(string parentUrl) {
			string result = "";

			//Must subscribe all services on parent
			foreach (string str in allDataServices) {
				parentNode.Url = parentUrl + SERVICE_NAME;

				if (lastDataServices.Contains(str)) {
					result = parentNode.Subscribe(this.url, str);
					MessageBox.Show(str + " - subscribe");
				}
				else {
					result = parentNode.unSubscribe(this.url, str);
					MessageBox.Show(str + " - un subscribe");
				}

				/*
				 * - On success: "0000"
				 * - Node (child) not registered: "1004"
				 * - Service not available: "1005"
				 */
				MessageBox.Show(result);
				switch (result) {
					case "1004":
						MessageBox.Show("Ocorreu um erro ao tentar registar o serviço " + str + "!");
						break;
					case "1005":
						//Parent does not support the current service
						break;
				}
			}

			readParentNodeServices(parentUrl);
		}

		private void btnParentSubscribeServices_Click(object sender, EventArgs e) {
			subscribeServices(cbParentUrls.Items[cbParentUrls.SelectedIndex].ToString());
		}
	}
}