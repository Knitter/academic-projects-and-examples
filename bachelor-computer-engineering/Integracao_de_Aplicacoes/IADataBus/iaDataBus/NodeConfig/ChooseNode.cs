using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Net;
using System.Threading;

namespace NodeConfig {
	public partial class ChooseNode : Form {
		private NodeConfig NodeConfigObj;

		public ChooseNode(NodeConfig node) {
			InitializeComponent();
			NodeConfigObj = node;
		}

		private void btnChoose_Click(object sender, EventArgs e) {
			doSubmit();
		}

		private void btnClose_Click(object sender, EventArgs e) {
			Application.Exit();
		}

		private void doSubmit() {
			string url = txtNodeUrl.Text;

			Cursor.Current = Cursors.WaitCursor;

			try {
				//Test if the url is really from a Node webservice 
				NodeService.Service testNode = new NodeService.Service();
				testNode.Url = url + NodeConfigObj.ServiceName;

				testNode.QueryServers();

				NodeConfigObj.Url = url;

				this.Close();
			}
			catch (UriFormatException ex) {
				//url is not formated correctly
				MessageBox.Show("O url não é válido!");
			}
			catch (WebException ex) {
				//Webservice did not implement the method
				MessageBox.Show("O url não é um webservice do tipo Node.");
			}
		}
	}
}