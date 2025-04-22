namespace NodeConfig
{
    partial class NodeConfig
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
					this.tabControl1 = new System.Windows.Forms.TabControl();
					this.tabPage3 = new System.Windows.Forms.TabPage();
					this.lblSubmitServices = new System.Windows.Forms.Label();
					this.btnSubmitServices = new System.Windows.Forms.Button();
					this.gbNodeServices = new System.Windows.Forms.GroupBox();
					this.chkAirTemperature = new System.Windows.Forms.CheckBox();
					this.chkPressure = new System.Windows.Forms.CheckBox();
					this.chkWindSpeed = new System.Windows.Forms.CheckBox();
					this.chkHumidity = new System.Windows.Forms.CheckBox();
					this.chkRadiation = new System.Windows.Forms.CheckBox();
					this.tabPage1 = new System.Windows.Forms.TabPage();
					this.gbParentServices = new System.Windows.Forms.GroupBox();
					this.chkParentAirTemperature = new System.Windows.Forms.CheckBox();
					this.chkParentPressure = new System.Windows.Forms.CheckBox();
					this.chkParentWindSpeed = new System.Windows.Forms.CheckBox();
					this.chkParentHumidity = new System.Windows.Forms.CheckBox();
					this.chkParentRadiation = new System.Windows.Forms.CheckBox();
					this.btnParentSubscribeServices = new System.Windows.Forms.Button();
					this.cbParentUrls = new System.Windows.Forms.ComboBox();
					this.lblStatus = new System.Windows.Forms.Label();
					this.btnSubscribeParent = new System.Windows.Forms.Button();
					this.label1 = new System.Windows.Forms.Label();
					this.tabPage2 = new System.Windows.Forms.TabPage();
					this.groupBox5 = new System.Windows.Forms.GroupBox();
					this.lbRegistered = new System.Windows.Forms.ListBox();
					this.groupBox4 = new System.Windows.Forms.GroupBox();
					this.lbSubscribed = new System.Windows.Forms.ListBox();
					this.btnRemoveSubscription = new System.Windows.Forms.Button();
					this.menuStrip1 = new System.Windows.Forms.MenuStrip();
					this.MenuChooseNode = new System.Windows.Forms.ToolStripMenuItem();
					this.fecharToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
					this.tESTEToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
					this.tabControl1.SuspendLayout();
					this.tabPage3.SuspendLayout();
					this.gbNodeServices.SuspendLayout();
					this.tabPage1.SuspendLayout();
					this.gbParentServices.SuspendLayout();
					this.tabPage2.SuspendLayout();
					this.groupBox5.SuspendLayout();
					this.groupBox4.SuspendLayout();
					this.menuStrip1.SuspendLayout();
					this.SuspendLayout();
					// 
					// tabControl1
					// 
					this.tabControl1.Controls.Add(this.tabPage3);
					this.tabControl1.Controls.Add(this.tabPage1);
					this.tabControl1.Controls.Add(this.tabPage2);
					this.tabControl1.Dock = System.Windows.Forms.DockStyle.Fill;
					this.tabControl1.Location = new System.Drawing.Point(0, 24);
					this.tabControl1.Name = "tabControl1";
					this.tabControl1.SelectedIndex = 0;
					this.tabControl1.Size = new System.Drawing.Size(451, 181);
					this.tabControl1.TabIndex = 0;
					this.tabControl1.SelectedIndexChanged += new System.EventHandler(this.tabControl1_SelectedIndexChanged);
					// 
					// tabPage3
					// 
					this.tabPage3.Controls.Add(this.lblSubmitServices);
					this.tabPage3.Controls.Add(this.btnSubmitServices);
					this.tabPage3.Controls.Add(this.gbNodeServices);
					this.tabPage3.Location = new System.Drawing.Point(4, 22);
					this.tabPage3.Name = "tabPage3";
					this.tabPage3.Padding = new System.Windows.Forms.Padding(3);
					this.tabPage3.Size = new System.Drawing.Size(443, 155);
					this.tabPage3.TabIndex = 2;
					this.tabPage3.Text = "Serviços";
					this.tabPage3.UseVisualStyleBackColor = true;
					// 
					// lblSubmitServices
					// 
					this.lblSubmitServices.AutoSize = true;
					this.lblSubmitServices.Location = new System.Drawing.Point(198, 85);
					this.lblSubmitServices.Name = "lblSubmitServices";
					this.lblSubmitServices.Size = new System.Drawing.Size(125, 13);
					this.lblSubmitServices.TabIndex = 3;
					this.lblSubmitServices.Text = "A submeter os serviços...";
					this.lblSubmitServices.Visible = false;
					// 
					// btnSubmitServices
					// 
					this.btnSubmitServices.Enabled = false;
					this.btnSubmitServices.Location = new System.Drawing.Point(329, 80);
					this.btnSubmitServices.Name = "btnSubmitServices";
					this.btnSubmitServices.Size = new System.Drawing.Size(106, 23);
					this.btnSubmitServices.TabIndex = 2;
					this.btnSubmitServices.Text = "Submeter Serviços";
					this.btnSubmitServices.UseVisualStyleBackColor = true;
					this.btnSubmitServices.Click += new System.EventHandler(this.btnSubmitServices_Click);
					// 
					// gbNodeServices
					// 
					this.gbNodeServices.Controls.Add(this.chkAirTemperature);
					this.gbNodeServices.Controls.Add(this.chkPressure);
					this.gbNodeServices.Controls.Add(this.chkWindSpeed);
					this.gbNodeServices.Controls.Add(this.chkHumidity);
					this.gbNodeServices.Controls.Add(this.chkRadiation);
					this.gbNodeServices.Location = new System.Drawing.Point(7, 2);
					this.gbNodeServices.Name = "gbNodeServices";
					this.gbNodeServices.Size = new System.Drawing.Size(429, 72);
					this.gbNodeServices.TabIndex = 1;
					this.gbNodeServices.TabStop = false;
					this.gbNodeServices.Text = "Serviços do nodo actual";
					// 
					// chkAirTemperature
					// 
					this.chkAirTemperature.AutoSize = true;
					this.chkAirTemperature.Location = new System.Drawing.Point(137, 42);
					this.chkAirTemperature.Name = "chkAirTemperature";
					this.chkAirTemperature.Size = new System.Drawing.Size(114, 17);
					this.chkAirTemperature.TabIndex = 3;
					this.chkAirTemperature.Text = "Temperatura do Ar";
					this.chkAirTemperature.UseVisualStyleBackColor = true;
					this.chkAirTemperature.CheckedChanged += new System.EventHandler(this.chkAirTemperature_CheckedChanged);
					// 
					// chkPressure
					// 
					this.chkPressure.AutoSize = true;
					this.chkPressure.Location = new System.Drawing.Point(137, 19);
					this.chkPressure.Name = "chkPressure";
					this.chkPressure.Size = new System.Drawing.Size(64, 17);
					this.chkPressure.TabIndex = 1;
					this.chkPressure.Text = "Pressão";
					this.chkPressure.UseVisualStyleBackColor = true;
					this.chkPressure.CheckedChanged += new System.EventHandler(this.chkPressure_CheckedChanged);
					// 
					// chkWindSpeed
					// 
					this.chkWindSpeed.AutoSize = true;
					this.chkWindSpeed.Location = new System.Drawing.Point(254, 19);
					this.chkWindSpeed.Name = "chkWindSpeed";
					this.chkWindSpeed.Size = new System.Drawing.Size(125, 17);
					this.chkWindSpeed.TabIndex = 4;
					this.chkWindSpeed.Text = "Velocidade do Vento";
					this.chkWindSpeed.UseVisualStyleBackColor = true;
					this.chkWindSpeed.CheckedChanged += new System.EventHandler(this.chkWindSpeed_CheckedChanged);
					// 
					// chkHumidity
					// 
					this.chkHumidity.AutoSize = true;
					this.chkHumidity.Location = new System.Drawing.Point(6, 19);
					this.chkHumidity.Name = "chkHumidity";
					this.chkHumidity.Size = new System.Drawing.Size(74, 17);
					this.chkHumidity.TabIndex = 0;
					this.chkHumidity.Text = "Humidade";
					this.chkHumidity.UseVisualStyleBackColor = true;
					this.chkHumidity.CheckedChanged += new System.EventHandler(this.chkHumidity_CheckedChanged);
					// 
					// chkRadiation
					// 
					this.chkRadiation.AutoSize = true;
					this.chkRadiation.Location = new System.Drawing.Point(6, 42);
					this.chkRadiation.Name = "chkRadiation";
					this.chkRadiation.Size = new System.Drawing.Size(99, 17);
					this.chkRadiation.TabIndex = 2;
					this.chkRadiation.Text = "Radiação Solar";
					this.chkRadiation.UseVisualStyleBackColor = true;
					this.chkRadiation.CheckedChanged += new System.EventHandler(this.chkRadiation_CheckedChanged);
					// 
					// tabPage1
					// 
					this.tabPage1.Controls.Add(this.gbParentServices);
					this.tabPage1.Controls.Add(this.btnParentSubscribeServices);
					this.tabPage1.Controls.Add(this.cbParentUrls);
					this.tabPage1.Controls.Add(this.lblStatus);
					this.tabPage1.Controls.Add(this.btnSubscribeParent);
					this.tabPage1.Controls.Add(this.label1);
					this.tabPage1.Location = new System.Drawing.Point(4, 22);
					this.tabPage1.Name = "tabPage1";
					this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
					this.tabPage1.Size = new System.Drawing.Size(443, 155);
					this.tabPage1.TabIndex = 0;
					this.tabPage1.Text = "Subscrever pai";
					this.tabPage1.UseVisualStyleBackColor = true;
					// 
					// gbParentServices
					// 
					this.gbParentServices.Controls.Add(this.chkParentAirTemperature);
					this.gbParentServices.Controls.Add(this.chkParentPressure);
					this.gbParentServices.Controls.Add(this.chkParentWindSpeed);
					this.gbParentServices.Controls.Add(this.chkParentHumidity);
					this.gbParentServices.Controls.Add(this.chkParentRadiation);
					this.gbParentServices.Location = new System.Drawing.Point(6, 43);
					this.gbParentServices.Name = "gbParentServices";
					this.gbParentServices.Size = new System.Drawing.Size(429, 72);
					this.gbParentServices.TabIndex = 11;
					this.gbParentServices.TabStop = false;
					this.gbParentServices.Text = "Serviços do nodo selecionado";
					// 
					// chkParentAirTemperature
					// 
					this.chkParentAirTemperature.AutoSize = true;
					this.chkParentAirTemperature.Enabled = false;
					this.chkParentAirTemperature.Location = new System.Drawing.Point(137, 42);
					this.chkParentAirTemperature.Name = "chkParentAirTemperature";
					this.chkParentAirTemperature.Size = new System.Drawing.Size(114, 17);
					this.chkParentAirTemperature.TabIndex = 3;
					this.chkParentAirTemperature.Text = "Temperatura do Ar";
					this.chkParentAirTemperature.UseVisualStyleBackColor = true;
					// 
					// chkParentPressure
					// 
					this.chkParentPressure.AutoSize = true;
					this.chkParentPressure.Enabled = false;
					this.chkParentPressure.Location = new System.Drawing.Point(137, 19);
					this.chkParentPressure.Name = "chkParentPressure";
					this.chkParentPressure.Size = new System.Drawing.Size(64, 17);
					this.chkParentPressure.TabIndex = 1;
					this.chkParentPressure.Text = "Pressão";
					this.chkParentPressure.UseVisualStyleBackColor = true;
					// 
					// chkParentWindSpeed
					// 
					this.chkParentWindSpeed.AutoSize = true;
					this.chkParentWindSpeed.Enabled = false;
					this.chkParentWindSpeed.Location = new System.Drawing.Point(254, 19);
					this.chkParentWindSpeed.Name = "chkParentWindSpeed";
					this.chkParentWindSpeed.Size = new System.Drawing.Size(125, 17);
					this.chkParentWindSpeed.TabIndex = 4;
					this.chkParentWindSpeed.Text = "Velocidade do Vento";
					this.chkParentWindSpeed.UseVisualStyleBackColor = true;
					// 
					// chkParentHumidity
					// 
					this.chkParentHumidity.AutoSize = true;
					this.chkParentHumidity.Enabled = false;
					this.chkParentHumidity.Location = new System.Drawing.Point(6, 19);
					this.chkParentHumidity.Name = "chkParentHumidity";
					this.chkParentHumidity.Size = new System.Drawing.Size(74, 17);
					this.chkParentHumidity.TabIndex = 0;
					this.chkParentHumidity.Text = "Humidade";
					this.chkParentHumidity.UseVisualStyleBackColor = true;
					// 
					// chkParentRadiation
					// 
					this.chkParentRadiation.AutoSize = true;
					this.chkParentRadiation.Enabled = false;
					this.chkParentRadiation.Location = new System.Drawing.Point(6, 42);
					this.chkParentRadiation.Name = "chkParentRadiation";
					this.chkParentRadiation.Size = new System.Drawing.Size(99, 17);
					this.chkParentRadiation.TabIndex = 2;
					this.chkParentRadiation.Text = "Radiação Solar";
					this.chkParentRadiation.UseVisualStyleBackColor = true;
					// 
					// btnParentSubscribeServices
					// 
					this.btnParentSubscribeServices.Location = new System.Drawing.Point(305, 122);
					this.btnParentSubscribeServices.Name = "btnParentSubscribeServices";
					this.btnParentSubscribeServices.Size = new System.Drawing.Size(130, 23);
					this.btnParentSubscribeServices.TabIndex = 12;
					this.btnParentSubscribeServices.Text = "Subscrever novamente";
					this.btnParentSubscribeServices.UseVisualStyleBackColor = true;
					this.btnParentSubscribeServices.Click += new System.EventHandler(this.btnParentSubscribeServices_Click);
					// 
					// cbParentUrls
					// 
					this.cbParentUrls.FormattingEnabled = true;
					this.cbParentUrls.Location = new System.Drawing.Point(79, 6);
					this.cbParentUrls.Name = "cbParentUrls";
					this.cbParentUrls.Size = new System.Drawing.Size(275, 21);
					this.cbParentUrls.TabIndex = 10;
					this.cbParentUrls.Text = "http://";
					this.cbParentUrls.SelectedIndexChanged += new System.EventHandler(this.cbParentUrls_SelectedIndexChanged);
					// 
					// lblStatus
					// 
					this.lblStatus.AutoSize = true;
					this.lblStatus.Location = new System.Drawing.Point(12, 127);
					this.lblStatus.Name = "lblStatus";
					this.lblStatus.Size = new System.Drawing.Size(0, 13);
					this.lblStatus.TabIndex = 9;
					// 
					// btnSubscribeParent
					// 
					this.btnSubscribeParent.Location = new System.Drawing.Point(360, 4);
					this.btnSubscribeParent.Name = "btnSubscribeParent";
					this.btnSubscribeParent.Size = new System.Drawing.Size(75, 23);
					this.btnSubscribeParent.TabIndex = 8;
					this.btnSubscribeParent.Text = "Subscrever";
					this.btnSubscribeParent.UseVisualStyleBackColor = true;
					this.btnSubscribeParent.Click += new System.EventHandler(this.btnSubscribeParent_Click);
					// 
					// label1
					// 
					this.label1.AutoSize = true;
					this.label1.Location = new System.Drawing.Point(8, 9);
					this.label1.Name = "label1";
					this.label1.Size = new System.Drawing.Size(65, 13);
					this.label1.TabIndex = 6;
					this.label1.Text = "Url do nodo:";
					// 
					// tabPage2
					// 
					this.tabPage2.Controls.Add(this.groupBox5);
					this.tabPage2.Controls.Add(this.groupBox4);
					this.tabPage2.Location = new System.Drawing.Point(4, 22);
					this.tabPage2.Name = "tabPage2";
					this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
					this.tabPage2.Size = new System.Drawing.Size(443, 155);
					this.tabPage2.TabIndex = 1;
					this.tabPage2.Text = "Nodos Registados e Subscritos";
					this.tabPage2.UseVisualStyleBackColor = true;
					// 
					// groupBox5
					// 
					this.groupBox5.Controls.Add(this.lbRegistered);
					this.groupBox5.Location = new System.Drawing.Point(9, 163);
					this.groupBox5.Name = "groupBox5";
					this.groupBox5.Size = new System.Drawing.Size(427, 172);
					this.groupBox5.TabIndex = 1;
					this.groupBox5.TabStop = false;
					this.groupBox5.Text = "Nodos Registados";
					// 
					// lbRegistered
					// 
					this.lbRegistered.FormattingEnabled = true;
					this.lbRegistered.Location = new System.Drawing.Point(6, 19);
					this.lbRegistered.Name = "lbRegistered";
					this.lbRegistered.Size = new System.Drawing.Size(415, 147);
					this.lbRegistered.TabIndex = 0;
					// 
					// groupBox4
					// 
					this.groupBox4.Controls.Add(this.lbSubscribed);
					this.groupBox4.Controls.Add(this.btnRemoveSubscription);
					this.groupBox4.Location = new System.Drawing.Point(9, 6);
					this.groupBox4.Name = "groupBox4";
					this.groupBox4.Size = new System.Drawing.Size(427, 151);
					this.groupBox4.TabIndex = 0;
					this.groupBox4.TabStop = false;
					this.groupBox4.Text = "Nodos Subscritos";
					// 
					// lbSubscribed
					// 
					this.lbSubscribed.FormattingEnabled = true;
					this.lbSubscribed.Location = new System.Drawing.Point(6, 19);
					this.lbSubscribed.Name = "lbSubscribed";
					this.lbSubscribed.Size = new System.Drawing.Size(415, 95);
					this.lbSubscribed.TabIndex = 2;
					// 
					// btnRemoveSubscription
					// 
					this.btnRemoveSubscription.Location = new System.Drawing.Point(346, 122);
					this.btnRemoveSubscription.Name = "btnRemoveSubscription";
					this.btnRemoveSubscription.Size = new System.Drawing.Size(75, 23);
					this.btnRemoveSubscription.TabIndex = 1;
					this.btnRemoveSubscription.Text = "Remover";
					this.btnRemoveSubscription.UseVisualStyleBackColor = true;
					// 
					// menuStrip1
					// 
					this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.MenuChooseNode,
            this.fecharToolStripMenuItem});
					this.menuStrip1.Location = new System.Drawing.Point(0, 0);
					this.menuStrip1.Name = "menuStrip1";
					this.menuStrip1.Size = new System.Drawing.Size(451, 24);
					this.menuStrip1.TabIndex = 2;
					this.menuStrip1.Text = "menuStrip1";
					// 
					// MenuChooseNode
					// 
					this.MenuChooseNode.Name = "MenuChooseNode";
					this.MenuChooseNode.Size = new System.Drawing.Size(86, 20);
					this.MenuChooseNode.Text = "Escolher nodo";
					this.MenuChooseNode.Click += new System.EventHandler(this.MenuChooseNode_Click);
					// 
					// fecharToolStripMenuItem
					// 
					this.fecharToolStripMenuItem.Name = "fecharToolStripMenuItem";
					this.fecharToolStripMenuItem.Size = new System.Drawing.Size(52, 20);
					this.fecharToolStripMenuItem.Text = "Fechar";
					this.fecharToolStripMenuItem.Click += new System.EventHandler(this.fecharToolStripMenuItem_Click);
					// 
					// tESTEToolStripMenuItem
					// 
					this.tESTEToolStripMenuItem.Name = "tESTEToolStripMenuItem";
					this.tESTEToolStripMenuItem.Size = new System.Drawing.Size(32, 19);
					// 
					// NodeConfig
					// 
					this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
					this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
					this.ClientSize = new System.Drawing.Size(451, 205);
					this.Controls.Add(this.tabControl1);
					this.Controls.Add(this.menuStrip1);
					this.Name = "NodeConfig";
					this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
					this.Text = "Node Config";
					this.Load += new System.EventHandler(this.NodeConfig_Load);
					this.tabControl1.ResumeLayout(false);
					this.tabPage3.ResumeLayout(false);
					this.tabPage3.PerformLayout();
					this.gbNodeServices.ResumeLayout(false);
					this.gbNodeServices.PerformLayout();
					this.tabPage1.ResumeLayout(false);
					this.tabPage1.PerformLayout();
					this.gbParentServices.ResumeLayout(false);
					this.gbParentServices.PerformLayout();
					this.tabPage2.ResumeLayout(false);
					this.groupBox5.ResumeLayout(false);
					this.groupBox4.ResumeLayout(false);
					this.menuStrip1.ResumeLayout(false);
					this.menuStrip1.PerformLayout();
					this.ResumeLayout(false);
					this.PerformLayout();

        }

        #endregion

			private System.Windows.Forms.TabControl tabControl1;
			private System.Windows.Forms.TabPage tabPage1;
			private System.Windows.Forms.TabPage tabPage2;
			private System.Windows.Forms.Button btnSubscribeParent;
			private System.Windows.Forms.Label label1;
			private System.Windows.Forms.GroupBox groupBox5;
			private System.Windows.Forms.GroupBox groupBox4;
			private System.Windows.Forms.Button btnRemoveSubscription;
			private System.Windows.Forms.Label lblStatus;
			private System.Windows.Forms.MenuStrip menuStrip1;
			private System.Windows.Forms.ToolStripMenuItem MenuChooseNode;
			private System.Windows.Forms.ToolStripMenuItem fecharToolStripMenuItem;
			private System.Windows.Forms.TabPage tabPage3;
			private System.Windows.Forms.GroupBox gbNodeServices;
			private System.Windows.Forms.CheckBox chkAirTemperature;
			private System.Windows.Forms.CheckBox chkPressure;
			private System.Windows.Forms.CheckBox chkWindSpeed;
			private System.Windows.Forms.CheckBox chkHumidity;
			private System.Windows.Forms.CheckBox chkRadiation;
			private System.Windows.Forms.Button btnSubmitServices;
			private System.Windows.Forms.Label lblSubmitServices;
			private System.Windows.Forms.ComboBox cbParentUrls;
			private System.Windows.Forms.GroupBox gbParentServices;
			private System.Windows.Forms.CheckBox chkParentAirTemperature;
			private System.Windows.Forms.CheckBox chkParentPressure;
			private System.Windows.Forms.CheckBox chkParentWindSpeed;
			private System.Windows.Forms.CheckBox chkParentHumidity;
			private System.Windows.Forms.CheckBox chkParentRadiation;
			private System.Windows.Forms.ListBox lbRegistered;
			private System.Windows.Forms.ListBox lbSubscribed;
			private System.Windows.Forms.ToolStripMenuItem tESTEToolStripMenuItem;
			private System.Windows.Forms.Button btnParentSubscribeServices;
    }
}