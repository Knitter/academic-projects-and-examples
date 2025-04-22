namespace DataViewer
{
    partial class DataViewer
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
					this.menuStrip1 = new System.Windows.Forms.MenuStrip();
					this.dataViewerToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
					this.sairToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
					this.saveFileDialog1 = new System.Windows.Forms.SaveFileDialog();
					this.dtpMinValue = new System.Windows.Forms.DateTimePicker();
					this.label1 = new System.Windows.Forms.Label();
					this.dtpMaxValue = new System.Windows.Forms.DateTimePicker();
					this.label2 = new System.Windows.Forms.Label();
					this.cbxDataType = new System.Windows.Forms.ComboBox();
					this.groupBox1 = new System.Windows.Forms.GroupBox();
					this.chkFilter = new System.Windows.Forms.CheckBox();
					this.btnUpdate = new System.Windows.Forms.Button();
					this.label3 = new System.Windows.Forms.Label();
					this.groupBox2 = new System.Windows.Forms.GroupBox();
					this.btnExportData = new System.Windows.Forms.Button();
					this.dgvData = new System.Windows.Forms.DataGridView();
					this.groupBox3 = new System.Windows.Forms.GroupBox();
					this.btnShowGraph = new System.Windows.Forms.Button();
					this.groupBox4 = new System.Windows.Forms.GroupBox();
					this.label4 = new System.Windows.Forms.Label();
					this.groupBox6 = new System.Windows.Forms.GroupBox();
					this.label5 = new System.Windows.Forms.Label();
					this.btnExportChart = new System.Windows.Forms.Button();
					this.menuStrip1.SuspendLayout();
					this.groupBox1.SuspendLayout();
					this.groupBox2.SuspendLayout();
					((System.ComponentModel.ISupportInitialize)(this.dgvData)).BeginInit();
					this.groupBox3.SuspendLayout();
					this.groupBox4.SuspendLayout();
					this.groupBox6.SuspendLayout();
					this.SuspendLayout();
					// 
					// menuStrip1
					// 
					this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.dataViewerToolStripMenuItem});
					this.menuStrip1.Location = new System.Drawing.Point(0, 0);
					this.menuStrip1.Name = "menuStrip1";
					this.menuStrip1.Size = new System.Drawing.Size(581, 24);
					this.menuStrip1.TabIndex = 0;
					this.menuStrip1.Text = "menuStrip1";
					// 
					// dataViewerToolStripMenuItem
					// 
					this.dataViewerToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.sairToolStripMenuItem});
					this.dataViewerToolStripMenuItem.Name = "dataViewerToolStripMenuItem";
					this.dataViewerToolStripMenuItem.Size = new System.Drawing.Size(77, 20);
					this.dataViewerToolStripMenuItem.Text = "Data Viewer";
					// 
					// sairToolStripMenuItem
					// 
					this.sairToolStripMenuItem.Name = "sairToolStripMenuItem";
					this.sairToolStripMenuItem.Size = new System.Drawing.Size(103, 22);
					this.sairToolStripMenuItem.Text = "Sair";
					this.sairToolStripMenuItem.Click += new System.EventHandler(this.sairToolStripMenuItem_Click);
					// 
					// dtpMinValue
					// 
					this.dtpMinValue.Enabled = false;
					this.dtpMinValue.Location = new System.Drawing.Point(56, 42);
					this.dtpMinValue.Name = "dtpMinValue";
					this.dtpMinValue.Size = new System.Drawing.Size(225, 20);
					this.dtpMinValue.TabIndex = 1;
					// 
					// label1
					// 
					this.label1.AutoSize = true;
					this.label1.Enabled = false;
					this.label1.Location = new System.Drawing.Point(26, 46);
					this.label1.Name = "label1";
					this.label1.Size = new System.Drawing.Size(24, 13);
					this.label1.TabIndex = 2;
					this.label1.Text = "De:";
					// 
					// dtpMaxValue
					// 
					this.dtpMaxValue.Enabled = false;
					this.dtpMaxValue.Location = new System.Drawing.Point(327, 42);
					this.dtpMaxValue.Name = "dtpMaxValue";
					this.dtpMaxValue.Size = new System.Drawing.Size(224, 20);
					this.dtpMaxValue.TabIndex = 3;
					// 
					// label2
					// 
					this.label2.AutoSize = true;
					this.label2.Enabled = false;
					this.label2.Location = new System.Drawing.Point(304, 46);
					this.label2.Name = "label2";
					this.label2.Size = new System.Drawing.Size(17, 13);
					this.label2.TabIndex = 4;
					this.label2.Text = "A:";
					// 
					// cbxDataType
					// 
					this.cbxDataType.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
					this.cbxDataType.FormattingEnabled = true;
					this.cbxDataType.Items.AddRange(new object[] {
            "Humidade Relativa",
            "Pressão Atmosférica",
            "Radiação Solar",
            "Temperatura do Ar",
            "Velocidade do Vento"});
					this.cbxDataType.Location = new System.Drawing.Point(38, 19);
					this.cbxDataType.Name = "cbxDataType";
					this.cbxDataType.Size = new System.Drawing.Size(196, 21);
					this.cbxDataType.TabIndex = 5;
					this.cbxDataType.SelectedIndexChanged += new System.EventHandler(this.cbxDataType_SelectedIndexChanged);
					// 
					// groupBox1
					// 
					this.groupBox1.Controls.Add(this.chkFilter);
					this.groupBox1.Controls.Add(this.dtpMinValue);
					this.groupBox1.Controls.Add(this.dtpMaxValue);
					this.groupBox1.Controls.Add(this.label1);
					this.groupBox1.Controls.Add(this.label2);
					this.groupBox1.Location = new System.Drawing.Point(12, 27);
					this.groupBox1.Name = "groupBox1";
					this.groupBox1.Size = new System.Drawing.Size(558, 74);
					this.groupBox1.TabIndex = 6;
					this.groupBox1.TabStop = false;
					// 
					// chkFilter
					// 
					this.chkFilter.AutoSize = true;
					this.chkFilter.Location = new System.Drawing.Point(6, 19);
					this.chkFilter.Name = "chkFilter";
					this.chkFilter.Size = new System.Drawing.Size(51, 17);
					this.chkFilter.TabIndex = 11;
					this.chkFilter.Text = "Filtrar";
					this.chkFilter.UseVisualStyleBackColor = true;
					this.chkFilter.CheckedChanged += new System.EventHandler(this.chkFilter_CheckedChanged);
					// 
					// btnUpdate
					// 
					this.btnUpdate.Location = new System.Drawing.Point(246, 17);
					this.btnUpdate.Name = "btnUpdate";
					this.btnUpdate.Size = new System.Drawing.Size(75, 23);
					this.btnUpdate.TabIndex = 7;
					this.btnUpdate.Text = "Consultar";
					this.btnUpdate.UseVisualStyleBackColor = true;
					this.btnUpdate.Click += new System.EventHandler(this.btnUpdate_Click);
					// 
					// label3
					// 
					this.label3.AutoSize = true;
					this.label3.Location = new System.Drawing.Point(6, 22);
					this.label3.Name = "label3";
					this.label3.Size = new System.Drawing.Size(26, 13);
					this.label3.TabIndex = 8;
					this.label3.Text = "Ver:";
					// 
					// groupBox2
					// 
					this.groupBox2.Controls.Add(this.btnExportData);
					this.groupBox2.Controls.Add(this.dgvData);
					this.groupBox2.Location = new System.Drawing.Point(12, 165);
					this.groupBox2.Name = "groupBox2";
					this.groupBox2.Size = new System.Drawing.Size(558, 440);
					this.groupBox2.TabIndex = 9;
					this.groupBox2.TabStop = false;
					this.groupBox2.Text = "Dados";
					// 
					// btnExportData
					// 
					this.btnExportData.Location = new System.Drawing.Point(476, 411);
					this.btnExportData.Name = "btnExportData";
					this.btnExportData.Size = new System.Drawing.Size(75, 23);
					this.btnExportData.TabIndex = 1;
					this.btnExportData.Text = "Exportar...";
					this.btnExportData.UseVisualStyleBackColor = true;
					this.btnExportData.Click += new System.EventHandler(this.btnExportData_Click);
					// 
					// dgvData
					// 
					this.dgvData.AllowUserToAddRows = false;
					this.dgvData.AllowUserToDeleteRows = false;
					this.dgvData.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
					this.dgvData.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
					this.dgvData.Location = new System.Drawing.Point(6, 19);
					this.dgvData.Name = "dgvData";
					this.dgvData.ReadOnly = true;
					this.dgvData.Size = new System.Drawing.Size(546, 386);
					this.dgvData.TabIndex = 0;
					// 
					// groupBox3
					// 
					this.groupBox3.Controls.Add(this.btnShowGraph);
					this.groupBox3.Controls.Add(this.label3);
					this.groupBox3.Controls.Add(this.cbxDataType);
					this.groupBox3.Controls.Add(this.btnUpdate);
					this.groupBox3.Location = new System.Drawing.Point(12, 107);
					this.groupBox3.Name = "groupBox3";
					this.groupBox3.Size = new System.Drawing.Size(558, 52);
					this.groupBox3.TabIndex = 10;
					this.groupBox3.TabStop = false;
					this.groupBox3.Text = "Tipo de Dados";
					// 
					// btnShowGraph
					// 
					this.btnShowGraph.Location = new System.Drawing.Point(454, 17);
					this.btnShowGraph.Name = "btnShowGraph";
					this.btnShowGraph.Size = new System.Drawing.Size(97, 23);
					this.btnShowGraph.TabIndex = 9;
					this.btnShowGraph.Text = "Ver Graficos >>";
					this.btnShowGraph.UseVisualStyleBackColor = true;
					this.btnShowGraph.Click += new System.EventHandler(this.btnShowGraph_Click);
					// 
					// groupBox4
					// 
					this.groupBox4.Controls.Add(this.label4);
					this.groupBox4.Location = new System.Drawing.Point(584, 27);
					this.groupBox4.Name = "groupBox4";
					this.groupBox4.Size = new System.Drawing.Size(396, 132);
					this.groupBox4.TabIndex = 11;
					this.groupBox4.TabStop = false;
					this.groupBox4.Text = "Opções de Gráfico";
					// 
					// label4
					// 
					this.label4.AutoSize = true;
					this.label4.Location = new System.Drawing.Point(113, 46);
					this.label4.Name = "label4";
					this.label4.Size = new System.Drawing.Size(171, 13);
					this.label4.TabIndex = 0;
					this.label4.Text = "Funcionalidade não implementada.";
					// 
					// groupBox6
					// 
					this.groupBox6.Controls.Add(this.label5);
					this.groupBox6.Controls.Add(this.btnExportChart);
					this.groupBox6.Location = new System.Drawing.Point(584, 165);
					this.groupBox6.Name = "groupBox6";
					this.groupBox6.Size = new System.Drawing.Size(393, 440);
					this.groupBox6.TabIndex = 3;
					this.groupBox6.TabStop = false;
					// 
					// label5
					// 
					this.label5.AutoSize = true;
					this.label5.Location = new System.Drawing.Point(113, 182);
					this.label5.Name = "label5";
					this.label5.Size = new System.Drawing.Size(171, 13);
					this.label5.TabIndex = 3;
					this.label5.Text = "Funcionalidade não implementada.";
					// 
					// btnExportChart
					// 
					this.btnExportChart.Location = new System.Drawing.Point(303, 411);
					this.btnExportChart.Name = "btnExportChart";
					this.btnExportChart.Size = new System.Drawing.Size(75, 23);
					this.btnExportChart.TabIndex = 2;
					this.btnExportChart.Text = "Exportar...";
					this.btnExportChart.UseVisualStyleBackColor = true;
					this.btnExportChart.Click += new System.EventHandler(this.btnExportChart_Click);
					// 
					// DataViewer
					// 
					this.AcceptButton = this.btnUpdate;
					this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
					this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
					this.ClientSize = new System.Drawing.Size(581, 614);
					this.Controls.Add(this.groupBox6);
					this.Controls.Add(this.groupBox4);
					this.Controls.Add(this.groupBox3);
					this.Controls.Add(this.groupBox2);
					this.Controls.Add(this.groupBox1);
					this.Controls.Add(this.menuStrip1);
					this.MainMenuStrip = this.menuStrip1;
					this.MaximizeBox = false;
					this.Name = "DataViewer";
					this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
					this.Text = "DataViewer";
					this.Load += new System.EventHandler(this.DataViewer_Load);
					this.menuStrip1.ResumeLayout(false);
					this.menuStrip1.PerformLayout();
					this.groupBox1.ResumeLayout(false);
					this.groupBox1.PerformLayout();
					this.groupBox2.ResumeLayout(false);
					((System.ComponentModel.ISupportInitialize)(this.dgvData)).EndInit();
					this.groupBox3.ResumeLayout(false);
					this.groupBox3.PerformLayout();
					this.groupBox4.ResumeLayout(false);
					this.groupBox4.PerformLayout();
					this.groupBox6.ResumeLayout(false);
					this.groupBox6.PerformLayout();
					this.ResumeLayout(false);
					this.PerformLayout();

        }

        #endregion

			private System.Windows.Forms.MenuStrip menuStrip1;
			private System.Windows.Forms.ToolStripMenuItem dataViewerToolStripMenuItem;
			private System.Windows.Forms.ToolStripMenuItem sairToolStripMenuItem;
			private System.Windows.Forms.SaveFileDialog saveFileDialog1;
			private System.Windows.Forms.DateTimePicker dtpMinValue;
			private System.Windows.Forms.Label label1;
			private System.Windows.Forms.DateTimePicker dtpMaxValue;
			private System.Windows.Forms.Label label2;
			private System.Windows.Forms.ComboBox cbxDataType;
			private System.Windows.Forms.GroupBox groupBox1;
			private System.Windows.Forms.Button btnUpdate;
			private System.Windows.Forms.Label label3;
			private System.Windows.Forms.GroupBox groupBox2;
			private System.Windows.Forms.GroupBox groupBox3;
			private System.Windows.Forms.Button btnShowGraph;
			private System.Windows.Forms.DataGridView dgvData;
			private System.Windows.Forms.CheckBox chkFilter;
			private System.Windows.Forms.GroupBox groupBox4;
			private System.Windows.Forms.GroupBox groupBox6;
			private System.Windows.Forms.Button btnExportChart;
			private System.Windows.Forms.Button btnExportData;
			private System.Windows.Forms.Label label4;
			private System.Windows.Forms.Label label5;
			//private AxMSChart20Lib.AxMSChart axMSChart1;
			/*private System.Windows.Forms.BindingSource webserviceDataSet1BindingSource;
			private webserviceDataSet1 webserviceDataSet1;*/


			}
}