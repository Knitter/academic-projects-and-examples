using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Reflection;
using Excel;

namespace DataViewer {
	public partial class DataViewer : Form {

		private enum DataTypes { Humidade, Pressao, Radiacao, Temperatura, Vento };

		private SqlConnection sqlConn = new SqlConnection();
		private SqlCommand sqlCommand;

		private DataSet dataset = new DataSet();
		private SqlDataAdapter adapter;

		private bool limitRange = false;
		private bool expanded = false;
		private bool alive = false;

		private bool validConnection = true;

		//private String baseConnectionString = @"Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=webservice;Data Source=SURFBOARD\SQLEXPRESS";
		private String baseConnectionString = @"Integrated Security=SSPI;Persist Security Info=False;Initial Catalog=";

		public DataViewer() {
			InitializeComponent();
			cbxDataType.SelectedIndex = 0;
			dgvData.DataSource = dataset;

			sqlCommand = new SqlCommand();
			sqlCommand.Connection = sqlConn;
			sqlCommand.CommandType = CommandType.Text;

			adapter = new SqlDataAdapter(sqlCommand);
			adapter.SelectCommand = sqlCommand;
			alive = true;
		}

		private void sairToolStripMenuItem_Click(object sender, EventArgs e) {
			System.Windows.Forms.Application.Exit();
		}

		private void btnUpdate_Click(object sender, EventArgs e) {
			Cursor.Current = Cursors.WaitCursor;
			doQuery();
		}

		private void doQuery() {
			bool validIndex = true;
			String sqlBase = "SELECT * FROM meteo_data WHERE data_type LIKE '";

			switch (cbxDataType.SelectedIndex) {
				case (int)DataTypes.Humidade:
					sqlCommand.CommandText = sqlBase + "Humidade'";
					break;
				case (int)DataTypes.Pressao:
					sqlCommand.CommandText = sqlBase + "Pressao'";
					break;
				case (int)DataTypes.Radiacao:
					sqlCommand.CommandText = sqlBase + "Radiacao'";
					break;
				case (int)DataTypes.Temperatura:
					sqlCommand.CommandText = sqlBase + "Temperatura'";
					break;
				case (int)DataTypes.Vento:
					sqlCommand.CommandText = sqlBase + "Vento'";
					break;
				default:
					validIndex = false;
					break;
			}
			if (validIndex) {
				if (limitRange) {
					sqlCommand.CommandText += " AND xml_date BETWEEN '" + dtpMinValue.Value.ToString("yyyy-MM-dd HH:mm:ss") + "' AND '" + dtpMaxValue.Value.ToString("yyyy-MM-dd HH:mm:ss") + "'";
				}
				dataset.Clear();
				sqlConn.Open();
				adapter.Fill(dataset, "meteo_data");
				sqlConn.Close();
				dgvData.DataMember = "meteo_data";
			}
		}

		private void chkFilter_CheckedChanged(object sender, EventArgs e) {
			limitRange = label1.Enabled = label2.Enabled = dtpMaxValue.Enabled = dtpMinValue.Enabled = chkFilter.Checked;
		}

		private void btnShowGraph_Click(object sender, EventArgs e) {
			if (expanded) {
				this.Size = new Size(589, this.Size.Height);
				btnShowGraph.Text = "Ver Gráficos >>";
				expanded = false;
			} else {
				this.Size = new Size(1000, this.Size.Height);
				btnShowGraph.Text = "Esconder <<";
				expanded = true;
			}
		}

		private void cbxDataType_SelectedIndexChanged(object sender, EventArgs e) {
			if (alive) {//Why do I see an event before the class constructer has started/finished?!
				doQuery();
			}
		}

		private void DataViewer_Load(object sender, EventArgs e) {
			new ConnectionInfo(this).ShowDialog();
			if (validConnection) {
				doQuery();
				//showChart();
			} else {
				System.Windows.Forms.Application.Exit();
			}
		}

		private void showChart() {//This method is not working!
			//Workaround MS BUGS! It´s becoming quite annoying. 
			System.Globalization.CultureInfo oldCl = System.Threading.Thread.CurrentThread.CurrentCulture;
			System.Threading.Thread.CurrentThread.CurrentCulture = new System.Globalization.CultureInfo("en-US");

			Excel.Application app = new Excel.Application();
			app.SheetsInNewWorkbook = 1;
			Excel._Workbook book = (Excel._Workbook)(app.Workbooks.Add(Missing.Value));
			Excel._Worksheet sheet = (Excel._Worksheet)book.ActiveSheet;

			//TODO: create chart!
			Excel._Chart chart = (Excel._Chart)book.Charts.Add(Missing.Value, Missing.Value, Missing.Value, Missing.Value);


			Excel.Range source = sheet.get_Range("A1", "B" + dataset.Tables[0].Columns.Count);
			//source.Select();
			chart.ChartType = XlChartType.xlLine; 

			chart.SetSourceData(source, XlRowCol.xlColumns);
			chart.Location(XlChartLocation.xlLocationAsObject, sheet.Name);
			
			chart.HasTitle = true;
			chart.ChartTitle.Text = "Titulo";
			((Excel.Axis)chart.Axes(Excel.XlAxisType.xlCategory, XlAxisGroup.xlPrimary)).HasTitle = true;
			((Excel.Axis)chart.Axes(Excel.XlAxisType.xlCategory, XlAxisGroup.xlPrimary)).AxisTitle.Text = "Data";
			((Excel.Axis)chart.Axes(Excel.XlAxisType.xlValue, XlAxisGroup.xlPrimary)).HasTitle = true;
			((Excel.Axis)chart.Axes(Excel.XlAxisType.xlValue, XlAxisGroup.xlPrimary)).AxisTitle.Text = "Valor";

			chart.Activate();

			book.ActiveChart.CopyPicture(XlPictureAppearance.xlScreen, XlCopyPictureFormat.xlBitmap, XlPictureAppearance.xlScreen);

			//panelChart.BackgroundImage = (Image)Clipboard.GetDataObject().GetData(DataFormats.Bitmap);
			//panelChart.Visible = true;
		}

		public bool recieveConnectionInfo(String server, String nodeName) {
			if (server == null && nodeName == null) {
				validConnection = false;
				return true;
			} else {
				sqlConn.ConnectionString = baseConnectionString + nodeName + ";Data Source=" + server;
				try {
					sqlConn.Open();
					sqlConn.Close();
					return true;
				} catch (Exception ex) {
					MessageBox.Show("Endereço para o Servidor ou Nome da Base de Dados inválidos");
					return false;
				}
			}
		}

		private void btnExportData_Click(object sender, EventArgs e) {
			Cursor.Current = Cursors.WaitCursor;

			//Workaround MS BUGS! It´s becoming quite annoying. 
			System.Globalization.CultureInfo oldCl = System.Threading.Thread.CurrentThread.CurrentCulture;
			System.Threading.Thread.CurrentThread.CurrentCulture = new System.Globalization.CultureInfo("en-US");

			Excel.Application app = new Excel.Application();
			Excel._Workbook book = (Excel._Workbook)(app.Workbooks.Add(Missing.Value));
			Excel._Worksheet sheet = (Excel._Worksheet)book.ActiveSheet;

			sheet.get_Range("A1", "C1").Font.Bold = true;
			sheet.get_Range("A1", "C1").HorizontalAlignment = XlHAlign.xlHAlignCenter;

			sheet.Cells[1, 1] = "Data";
			sheet.Cells[1, 2] = "Valor";
			sheet.Cells[1, 3] = "Tipo de Dados";

			for (int z = 0; z < dataset.Tables[0].Rows.Count - 1; z++) {
				sheet.get_Range(sheet.Cells[z + 2, 1], sheet.Cells[z + 2, dataset.Tables[0].Columns.Count]).Value2 = dataset.Tables[0].Rows[z].ItemArray;
			}

			if (saveFileDialog1.ShowDialog() == DialogResult.OK) {
				book.Close(true, saveFileDialog1.FileName, null);
			}

			System.Runtime.InteropServices.Marshal.ReleaseComObject(book);
			System.Runtime.InteropServices.Marshal.ReleaseComObject(app);
			book = null;
			app = null;

			System.Threading.Thread.CurrentThread.CurrentCulture = oldCl;
		}

		private void btnExportChart_Click(object sender, EventArgs e) {
		}
	}
}