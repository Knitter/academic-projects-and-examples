using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;

namespace DataViewer {
	public partial class ConnectionInfo : Form {

		DataViewer owner;

		public ConnectionInfo(DataViewer owner) {
			InitializeComponent();
			this.owner = owner;
		}

		private void btnExit_Click(object sender, EventArgs e) {
			while(!owner.recieveConnectionInfo(null, null));
			Close();
		}

		private void btnConnect_Click(object sender, EventArgs e) {
			if (txtServer.Text.Length > 0 && txtNode.Text.Length > 0) {
				owner.recieveConnectionInfo(txtServer.Text, txtNode.Text);
				Close();
			}
		}
	}
}