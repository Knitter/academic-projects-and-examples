namespace NodeConfig {
	partial class ChooseNode {
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
			this.label1 = new System.Windows.Forms.Label();
			this.txtNodeUrl = new System.Windows.Forms.TextBox();
			this.btnChoose = new System.Windows.Forms.Button();
			this.label2 = new System.Windows.Forms.Label();
			this.btnClose = new System.Windows.Forms.Button();
			this.SuspendLayout();
			// 
			// label1
			// 
			this.label1.AutoSize = true;
			this.label1.Location = new System.Drawing.Point(12, 9);
			this.label1.Name = "label1";
			this.label1.Size = new System.Drawing.Size(50, 13);
			this.label1.TabIndex = 0;
			this.label1.Text = "Url do nó";
			// 
			// txtNodeUrl
			// 
			this.txtNodeUrl.Location = new System.Drawing.Point(68, 6);
			this.txtNodeUrl.Name = "txtNodeUrl";
			this.txtNodeUrl.Size = new System.Drawing.Size(198, 20);
			this.txtNodeUrl.TabIndex = 1;
			this.txtNodeUrl.Text = "http://localhost/node";
			// 
			// btnChoose
			// 
			this.btnChoose.Location = new System.Drawing.Point(272, 4);
			this.btnChoose.Name = "btnChoose";
			this.btnChoose.Size = new System.Drawing.Size(75, 23);
			this.btnChoose.TabIndex = 2;
			this.btnChoose.Text = "Escolher";
			this.btnChoose.UseVisualStyleBackColor = true;
			this.btnChoose.Click += new System.EventHandler(this.btnChoose_Click);
			// 
			// label2
			// 
			this.label2.AutoSize = true;
			this.label2.Location = new System.Drawing.Point(65, 37);
			this.label2.Name = "label2";
			this.label2.Size = new System.Drawing.Size(159, 13);
			this.label2.TabIndex = 3;
			this.label2.Text = "Ex.: http://localhost:1300/Node";
			// 
			// btnClose
			// 
			this.btnClose.Location = new System.Drawing.Point(272, 37);
			this.btnClose.Name = "btnClose";
			this.btnClose.Size = new System.Drawing.Size(75, 23);
			this.btnClose.TabIndex = 4;
			this.btnClose.Text = "Fechar";
			this.btnClose.UseVisualStyleBackColor = true;
			this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
			// 
			// ChooseNode
			// 
			this.AcceptButton = this.btnChoose;
			this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
			this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
			this.ClientSize = new System.Drawing.Size(360, 73);
			this.ControlBox = false;
			this.Controls.Add(this.btnClose);
			this.Controls.Add(this.label2);
			this.Controls.Add(this.btnChoose);
			this.Controls.Add(this.txtNodeUrl);
			this.Controls.Add(this.label1);
			this.MaximizeBox = false;
			this.MaximumSize = new System.Drawing.Size(400, 100);
			this.MinimizeBox = false;
			this.MinimumSize = new System.Drawing.Size(327, 90);
			this.Name = "ChooseNode";
			this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
			this.Text = "Escolher nó";
			this.ResumeLayout(false);
			this.PerformLayout();

		}

		#endregion

		private System.Windows.Forms.Label label1;
		private System.Windows.Forms.TextBox txtNodeUrl;
		private System.Windows.Forms.Button btnChoose;
		private System.Windows.Forms.Label label2;
		private System.Windows.Forms.Button btnClose;
	}
}