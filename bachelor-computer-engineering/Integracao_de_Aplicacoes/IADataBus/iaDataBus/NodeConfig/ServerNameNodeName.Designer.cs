namespace NodeConfig {
	partial class ServerNameNodeName {
		/// <summary>
		/// Required designer variable.
		/// </summary>
		private System.ComponentModel.IContainer components = null;

		/// <summary>
		/// Clean up any resources being used.
		/// </summary>
		/// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
		protected override void Dispose(bool disposing) {
			if (disposing && (components != null)) {
				components.Dispose();
			}
			base.Dispose(disposing);
		}

		#region Windows Form Designer generated code

		/// <summary>
		/// Required method for Designer support - do not modify
		/// the contents of this method with the code editor.
		/// </summary>
		private void InitializeComponent() {
			this.btnCancel = new System.Windows.Forms.Button();
			this.btnConnect = new System.Windows.Forms.Button();
			this.txtHostname = new System.Windows.Forms.TextBox();
			this.txtNodeName = new System.Windows.Forms.TextBox();
			this.lblHostname = new System.Windows.Forms.Label();
			this.lblNodeName = new System.Windows.Forms.Label();
			this.SuspendLayout();
			// 
			// btnCancel
			// 
			this.btnCancel.DialogResult = System.Windows.Forms.DialogResult.Cancel;
			this.btnCancel.Location = new System.Drawing.Point(231, 64);
			this.btnCancel.Name = "btnCancel";
			this.btnCancel.Size = new System.Drawing.Size(75, 23);
			this.btnCancel.TabIndex = 0;
			this.btnCancel.Text = "Cancelar";
			this.btnCancel.UseVisualStyleBackColor = true;
			this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
			// 
			// btnConnect
			// 
			this.btnConnect.Location = new System.Drawing.Point(150, 64);
			this.btnConnect.Name = "btnConnect";
			this.btnConnect.Size = new System.Drawing.Size(75, 23);
			this.btnConnect.TabIndex = 1;
			this.btnConnect.Text = "Ligar";
			this.btnConnect.UseVisualStyleBackColor = true;
			this.btnConnect.Click += new System.EventHandler(this.btnConnect_Click);
			// 
			// txtHostname
			// 
			this.txtHostname.Location = new System.Drawing.Point(67, 12);
			this.txtHostname.Name = "txtHostname";
			this.txtHostname.Size = new System.Drawing.Size(239, 20);
			this.txtHostname.TabIndex = 2;
			// 
			// txtNodeName
			// 
			this.txtNodeName.Location = new System.Drawing.Point(67, 38);
			this.txtNodeName.Name = "txtNodeName";
			this.txtNodeName.Size = new System.Drawing.Size(239, 20);
			this.txtNodeName.TabIndex = 3;
			// 
			// lblHostname
			// 
			this.lblHostname.AutoSize = true;
			this.lblHostname.Location = new System.Drawing.Point(12, 15);
			this.lblHostname.Name = "lblHostname";
			this.lblHostname.Size = new System.Drawing.Size(49, 13);
			this.lblHostname.TabIndex = 4;
			this.lblHostname.Text = "Servidor:";
			// 
			// lblNodeName
			// 
			this.lblNodeName.AutoSize = true;
			this.lblNodeName.Location = new System.Drawing.Point(12, 41);
			this.lblNodeName.Name = "lblNodeName";
			this.lblNodeName.Size = new System.Drawing.Size(36, 13);
			this.lblNodeName.TabIndex = 5;
			this.lblNodeName.Text = "Nodo:";
			// 
			// ServerNameNodeName
			// 
			this.AcceptButton = this.btnConnect;
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.CancelButton = this.btnCancel;
			this.ClientSize = new System.Drawing.Size(315, 93);
			this.ControlBox = false;
			this.Controls.Add(this.lblNodeName);
			this.Controls.Add(this.lblHostname);
			this.Controls.Add(this.txtNodeName);
			this.Controls.Add(this.txtHostname);
			this.Controls.Add(this.btnConnect);
			this.Controls.Add(this.btnCancel);
			this.Name = "ServerNameNodeName";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Introduza o Servidor e o nome do Nodo";
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Button btnCancel;
		private System.Windows.Forms.Button btnConnect;
		private System.Windows.Forms.TextBox txtHostname;
		private System.Windows.Forms.TextBox txtNodeName;
		private System.Windows.Forms.Label lblHostname;
		private System.Windows.Forms.Label lblNodeName;
	}
}