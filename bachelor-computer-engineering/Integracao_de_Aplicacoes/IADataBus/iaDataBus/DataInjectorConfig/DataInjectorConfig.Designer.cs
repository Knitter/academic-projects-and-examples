namespace DataInjectorConfig
{
    partial class DataInjectorConfig
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
					this.serviceController = new System.ServiceProcess.ServiceController();
					this.tabControl = new System.Windows.Forms.TabControl();
					this.tabStatus = new System.Windows.Forms.TabPage();
					this.groupBox5 = new System.Windows.Forms.GroupBox();
					this.lblWebServiceAddr = new System.Windows.Forms.Label();
					this.txtWebServiceaddr = new System.Windows.Forms.TextBox();
					this.groupBox2 = new System.Windows.Forms.GroupBox();
					this.label2 = new System.Windows.Forms.Label();
					this.label1 = new System.Windows.Forms.Label();
					this.spinnerQueryTime = new System.Windows.Forms.NumericUpDown();
					this.groupBox1 = new System.Windows.Forms.GroupBox();
					this.btnStopService = new System.Windows.Forms.Button();
					this.btnStartService = new System.Windows.Forms.Button();
					this.lblServiceStateResult = new System.Windows.Forms.Label();
					this.lblServiceState = new System.Windows.Forms.Label();
					this.tabPage1 = new System.Windows.Forms.TabPage();
					this.groupBox4 = new System.Windows.Forms.GroupBox();
					this.btnRemoveHost = new System.Windows.Forms.Button();
					this.lstHosts = new System.Windows.Forms.ListBox();
					this.groupBox3 = new System.Windows.Forms.GroupBox();
					this.btnAddHost = new System.Windows.Forms.Button();
					this.txtHostName = new System.Windows.Forms.TextBox();
					this.lblComputer = new System.Windows.Forms.Label();
					this.btnCancel = new System.Windows.Forms.Button();
					this.btnSave = new System.Windows.Forms.Button();
					this.tabControl.SuspendLayout();
					this.tabStatus.SuspendLayout();
					this.groupBox5.SuspendLayout();
					this.groupBox2.SuspendLayout();
					((System.ComponentModel.ISupportInitialize)(this.spinnerQueryTime)).BeginInit();
					this.groupBox1.SuspendLayout();
					this.tabPage1.SuspendLayout();
					this.groupBox4.SuspendLayout();
					this.groupBox3.SuspendLayout();
					this.SuspendLayout();
					// 
					// serviceController
					// 
					this.serviceController.ServiceName = "DataInjectorService";
					// 
					// tabControl
					// 
					this.tabControl.Controls.Add(this.tabStatus);
					this.tabControl.Controls.Add(this.tabPage1);
					this.tabControl.Dock = System.Windows.Forms.DockStyle.Top;
					this.tabControl.Location = new System.Drawing.Point(0, 0);
					this.tabControl.Name = "tabControl";
					this.tabControl.SelectedIndex = 0;
					this.tabControl.Size = new System.Drawing.Size(351, 269);
					this.tabControl.TabIndex = 0;
					// 
					// tabStatus
					// 
					this.tabStatus.Controls.Add(this.groupBox5);
					this.tabStatus.Controls.Add(this.groupBox2);
					this.tabStatus.Controls.Add(this.groupBox1);
					this.tabStatus.Location = new System.Drawing.Point(4, 22);
					this.tabStatus.Name = "tabStatus";
					this.tabStatus.Padding = new System.Windows.Forms.Padding(3);
					this.tabStatus.Size = new System.Drawing.Size(343, 243);
					this.tabStatus.TabIndex = 0;
					this.tabStatus.Text = "Geral";
					this.tabStatus.UseVisualStyleBackColor = true;
					// 
					// groupBox5
					// 
					this.groupBox5.Controls.Add(this.lblWebServiceAddr);
					this.groupBox5.Controls.Add(this.txtWebServiceaddr);
					this.groupBox5.Location = new System.Drawing.Point(8, 170);
					this.groupBox5.Name = "groupBox5";
					this.groupBox5.Size = new System.Drawing.Size(326, 51);
					this.groupBox5.TabIndex = 2;
					this.groupBox5.TabStop = false;
					this.groupBox5.Text = "Endereço Webservice";
					// 
					// lblWebServiceAddr
					// 
					this.lblWebServiceAddr.AutoSize = true;
					this.lblWebServiceAddr.Location = new System.Drawing.Point(6, 22);
					this.lblWebServiceAddr.Name = "lblWebServiceAddr";
					this.lblWebServiceAddr.Size = new System.Drawing.Size(67, 13);
					this.lblWebServiceAddr.TabIndex = 1;
					this.lblWebServiceAddr.Text = "Webservice:";
					// 
					// txtWebServiceaddr
					// 
					this.txtWebServiceaddr.Location = new System.Drawing.Point(79, 19);
					this.txtWebServiceaddr.Name = "txtWebServiceaddr";
					this.txtWebServiceaddr.Size = new System.Drawing.Size(241, 20);
					this.txtWebServiceaddr.TabIndex = 0;
					this.txtWebServiceaddr.TextChanged += new System.EventHandler(this.txtWebServiceaddr_TextChanged);
					// 
					// groupBox2
					// 
					this.groupBox2.Controls.Add(this.label2);
					this.groupBox2.Controls.Add(this.label1);
					this.groupBox2.Controls.Add(this.spinnerQueryTime);
					this.groupBox2.Location = new System.Drawing.Point(6, 114);
					this.groupBox2.Name = "groupBox2";
					this.groupBox2.Size = new System.Drawing.Size(328, 50);
					this.groupBox2.TabIndex = 1;
					this.groupBox2.TabStop = false;
					this.groupBox2.Text = "Periodo";
					// 
					// label2
					// 
					this.label2.AutoSize = true;
					this.label2.Location = new System.Drawing.Point(205, 21);
					this.label2.Name = "label2";
					this.label2.Size = new System.Drawing.Size(59, 13);
					this.label2.TabIndex = 2;
					this.label2.Text = "(segundos)";
					// 
					// label1
					// 
					this.label1.AutoSize = true;
					this.label1.Location = new System.Drawing.Point(6, 21);
					this.label1.Name = "label1";
					this.label1.Size = new System.Drawing.Size(110, 13);
					this.label1.TabIndex = 1;
					this.label1.Text = "Tempo entre pedidos:";
					// 
					// spinnerQueryTime
					// 
					this.spinnerQueryTime.Location = new System.Drawing.Point(122, 19);
					this.spinnerQueryTime.Maximum = new decimal(new int[] {
            86400,
            0,
            0,
            0});
					this.spinnerQueryTime.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
					this.spinnerQueryTime.Name = "spinnerQueryTime";
					this.spinnerQueryTime.Size = new System.Drawing.Size(74, 20);
					this.spinnerQueryTime.TabIndex = 0;
					this.spinnerQueryTime.Value = new decimal(new int[] {
            3,
            0,
            0,
            0});
					this.spinnerQueryTime.ValueChanged += new System.EventHandler(this.spinnerQueryTime_ValueChanged);
					// 
					// groupBox1
					// 
					this.groupBox1.Controls.Add(this.btnStopService);
					this.groupBox1.Controls.Add(this.btnStartService);
					this.groupBox1.Controls.Add(this.lblServiceStateResult);
					this.groupBox1.Controls.Add(this.lblServiceState);
					this.groupBox1.Location = new System.Drawing.Point(8, 6);
					this.groupBox1.Name = "groupBox1";
					this.groupBox1.Size = new System.Drawing.Size(328, 102);
					this.groupBox1.TabIndex = 0;
					this.groupBox1.TabStop = false;
					this.groupBox1.Text = "Estado do Serviço";
					// 
					// btnStopService
					// 
					this.btnStopService.Location = new System.Drawing.Point(245, 59);
					this.btnStopService.Name = "btnStopService";
					this.btnStopService.Size = new System.Drawing.Size(75, 23);
					this.btnStopService.TabIndex = 3;
					this.btnStopService.Text = "Parar";
					this.btnStopService.UseVisualStyleBackColor = true;
					this.btnStopService.Click += new System.EventHandler(this.btnStopService_Click);
					// 
					// btnStartService
					// 
					this.btnStartService.Location = new System.Drawing.Point(164, 59);
					this.btnStartService.Name = "btnStartService";
					this.btnStartService.Size = new System.Drawing.Size(75, 23);
					this.btnStartService.TabIndex = 2;
					this.btnStartService.Text = "Iniciar";
					this.btnStartService.UseVisualStyleBackColor = true;
					this.btnStartService.Click += new System.EventHandler(this.btnStartService_Click);
					// 
					// lblServiceStateResult
					// 
					this.lblServiceStateResult.AutoSize = true;
					this.lblServiceStateResult.Location = new System.Drawing.Point(65, 25);
					this.lblServiceStateResult.Name = "lblServiceStateResult";
					this.lblServiceStateResult.Size = new System.Drawing.Size(64, 13);
					this.lblServiceStateResult.TabIndex = 1;
					this.lblServiceStateResult.Text = "<indefinido>";
					// 
					// lblServiceState
					// 
					this.lblServiceState.AutoSize = true;
					this.lblServiceState.Location = new System.Drawing.Point(6, 25);
					this.lblServiceState.Name = "lblServiceState";
					this.lblServiceState.Size = new System.Drawing.Size(43, 13);
					this.lblServiceState.TabIndex = 0;
					this.lblServiceState.Text = "Estado:";
					// 
					// tabPage1
					// 
					this.tabPage1.Controls.Add(this.groupBox4);
					this.tabPage1.Controls.Add(this.groupBox3);
					this.tabPage1.Location = new System.Drawing.Point(4, 22);
					this.tabPage1.Name = "tabPage1";
					this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
					this.tabPage1.Size = new System.Drawing.Size(343, 243);
					this.tabPage1.TabIndex = 2;
					this.tabPage1.Text = "Malha Aplicacional";
					this.tabPage1.UseVisualStyleBackColor = true;
					// 
					// groupBox4
					// 
					this.groupBox4.Controls.Add(this.btnRemoveHost);
					this.groupBox4.Controls.Add(this.lstHosts);
					this.groupBox4.Location = new System.Drawing.Point(8, 64);
					this.groupBox4.Name = "groupBox4";
					this.groupBox4.Size = new System.Drawing.Size(328, 173);
					this.groupBox4.TabIndex = 5;
					this.groupBox4.TabStop = false;
					this.groupBox4.Text = "Nós actuais";
					// 
					// btnRemoveHost
					// 
					this.btnRemoveHost.Location = new System.Drawing.Point(247, 144);
					this.btnRemoveHost.Name = "btnRemoveHost";
					this.btnRemoveHost.Size = new System.Drawing.Size(75, 23);
					this.btnRemoveHost.TabIndex = 1;
					this.btnRemoveHost.Text = "Remover";
					this.btnRemoveHost.UseVisualStyleBackColor = true;
					this.btnRemoveHost.Click += new System.EventHandler(this.btnRemoveHost_Click);
					// 
					// lstHosts
					// 
					this.lstHosts.FormattingEnabled = true;
					this.lstHosts.Location = new System.Drawing.Point(7, 19);
					this.lstHosts.Name = "lstHosts";
					this.lstHosts.Size = new System.Drawing.Size(315, 121);
					this.lstHosts.TabIndex = 0;
					// 
					// groupBox3
					// 
					this.groupBox3.Controls.Add(this.btnAddHost);
					this.groupBox3.Controls.Add(this.txtHostName);
					this.groupBox3.Controls.Add(this.lblComputer);
					this.groupBox3.Location = new System.Drawing.Point(6, 6);
					this.groupBox3.Name = "groupBox3";
					this.groupBox3.Size = new System.Drawing.Size(330, 52);
					this.groupBox3.TabIndex = 4;
					this.groupBox3.TabStop = false;
					this.groupBox3.Text = "Adicionar nó";
					// 
					// btnAddHost
					// 
					this.btnAddHost.Location = new System.Drawing.Point(249, 19);
					this.btnAddHost.Name = "btnAddHost";
					this.btnAddHost.Size = new System.Drawing.Size(75, 23);
					this.btnAddHost.TabIndex = 2;
					this.btnAddHost.Text = "Adicionar";
					this.btnAddHost.UseVisualStyleBackColor = true;
					this.btnAddHost.Click += new System.EventHandler(this.btnAddHost_Click);
					// 
					// txtHostName
					// 
					this.txtHostName.Location = new System.Drawing.Point(82, 19);
					this.txtHostName.Name = "txtHostName";
					this.txtHostName.Size = new System.Drawing.Size(161, 20);
					this.txtHostName.TabIndex = 1;
					// 
					// lblComputer
					// 
					this.lblComputer.AutoSize = true;
					this.lblComputer.Location = new System.Drawing.Point(6, 22);
					this.lblComputer.Name = "lblComputer";
					this.lblComputer.Size = new System.Drawing.Size(70, 13);
					this.lblComputer.TabIndex = 0;
					this.lblComputer.Text = "Computador: ";
					// 
					// btnCancel
					// 
					this.btnCancel.Location = new System.Drawing.Point(265, 275);
					this.btnCancel.Name = "btnCancel";
					this.btnCancel.Size = new System.Drawing.Size(75, 23);
					this.btnCancel.TabIndex = 1;
					this.btnCancel.Text = "Fechar";
					this.btnCancel.UseVisualStyleBackColor = true;
					this.btnCancel.Click += new System.EventHandler(this.btnCancel_Click);
					// 
					// btnSave
					// 
					this.btnSave.Location = new System.Drawing.Point(184, 275);
					this.btnSave.Name = "btnSave";
					this.btnSave.Size = new System.Drawing.Size(75, 23);
					this.btnSave.TabIndex = 2;
					this.btnSave.Text = "Guardar";
					this.btnSave.UseVisualStyleBackColor = true;
					this.btnSave.Click += new System.EventHandler(this.btnSave_Click);
					// 
					// DataInjectorConfig
					// 
					this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
					this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
					this.ClientSize = new System.Drawing.Size(351, 310);
					this.Controls.Add(this.btnSave);
					this.Controls.Add(this.btnCancel);
					this.Controls.Add(this.tabControl);
					this.Name = "DataInjectorConfig";
					this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
					this.Text = "DataInjector Manager";
					this.Load += new System.EventHandler(this.DataInjectorConfig_Load);
					this.tabControl.ResumeLayout(false);
					this.tabStatus.ResumeLayout(false);
					this.groupBox5.ResumeLayout(false);
					this.groupBox5.PerformLayout();
					this.groupBox2.ResumeLayout(false);
					this.groupBox2.PerformLayout();
					((System.ComponentModel.ISupportInitialize)(this.spinnerQueryTime)).EndInit();
					this.groupBox1.ResumeLayout(false);
					this.groupBox1.PerformLayout();
					this.tabPage1.ResumeLayout(false);
					this.groupBox4.ResumeLayout(false);
					this.groupBox3.ResumeLayout(false);
					this.groupBox3.PerformLayout();
					this.ResumeLayout(false);

        }

        #endregion

			private System.ServiceProcess.ServiceController serviceController;
			private System.Windows.Forms.TabControl tabControl;
			private System.Windows.Forms.TabPage tabStatus;
			private System.Windows.Forms.Button btnCancel;
			private System.Windows.Forms.Button btnSave;
			private System.Windows.Forms.GroupBox groupBox2;
			private System.Windows.Forms.GroupBox groupBox1;
			private System.Windows.Forms.TabPage tabPage1;
			private System.Windows.Forms.Label label1;
			private System.Windows.Forms.NumericUpDown spinnerQueryTime;
			private System.Windows.Forms.Label label2;
			private System.Windows.Forms.GroupBox groupBox4;
			private System.Windows.Forms.ListBox lstHosts;
			private System.Windows.Forms.GroupBox groupBox3;
			private System.Windows.Forms.Button btnAddHost;
			private System.Windows.Forms.TextBox txtHostName;
			private System.Windows.Forms.Label lblComputer;
			private System.Windows.Forms.Button btnStopService;
			private System.Windows.Forms.Button btnStartService;
			private System.Windows.Forms.Label lblServiceStateResult;
			private System.Windows.Forms.Label lblServiceState;
			private System.Windows.Forms.GroupBox groupBox5;
			private System.Windows.Forms.Label lblWebServiceAddr;
			private System.Windows.Forms.TextBox txtWebServiceaddr;
			private System.Windows.Forms.Button btnRemoveHost;
    }
}