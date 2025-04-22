using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace NodeConfig {
	public partial class ServerNameNodeName : Form {

		NodeConfig cfg;
		
		public ServerNameNodeName(NodeConfig cfg) {
			InitializeComponent();
			//TODO: Throw some illegal arguments exception on null cfg.
			this.cfg = cfg;
		}

		private void btnCancel_Click(object sender, EventArgs e) {
			Close();
			cfg.Close();
		}

		private void btnConnect_Click(object sender, EventArgs e) {
			if(txtHostname.Text.Length > 0 && txtNodeName.Text.Length > 0) {
				cfg.configure(txtHostname.Text, txtNodeName.Text);
				Close();
				cfg.Visible = true;
			}
			else {
				MessageBox.Show(this, "Os dois campos são obrigatórios", "Erro!");
			}
		}
	}
}