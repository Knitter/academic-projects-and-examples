using System;
using System.Data;
using System.Configuration;
using System.Collections;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;

public partial class Admin_ListaManuais : System.Web.UI.Page {

	protected void Page_Load(object sender, EventArgs e) {

	}

	protected void GridView1_RowCommand(object sender, GridViewCommandEventArgs e) {
		if (e.CommandName.Equals("Remover")) {
			int idx = Convert.ToInt32(e.CommandArgument);
			SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings[0].ToString());
			SqlTransaction trans = null;
			try {
				SqlCommand cmd = conn.CreateCommand();
				conn.Open();
				trans = conn.BeginTransaction();
				cmd.Transaction = trans;

				cmd.CommandText = "DELETE FROM Pertencer WHERE IDManual = @IDManual";
				cmd.Parameters.AddWithValue("@IDManual", GridView1.DataKeys[idx].Value);
				cmd.ExecuteNonQuery();

				cmd.Parameters.Clear();
				cmd.CommandText = "DELETE FROM Manual WHERE ID = @IDManual";
				cmd.Parameters.AddWithValue("@IDManual", GridView1.DataKeys[idx].Value);
				cmd.ExecuteNonQuery();
				trans.Commit();
			} catch (SqlException ex) {
				if (trans != null) {
					trans.Rollback();
				}
			} finally {
				conn.Close();
			}
			GridView1.DataBind();
		} else if (e.CommandName.Equals("Download")) {
			SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings[0].ConnectionString);
			conn.Open();
			SqlCommand cmd = conn.CreateCommand();
			cmd.CommandText = "SELECT conteudo FROM Manual WHERE ID = @IDManual";

			byte[] bin;
			cmd.Parameters.Clear();
			cmd.Parameters.AddWithValue("@IDManual", GridView1.DataKeys[Convert.ToInt32(e.CommandArgument)].Value.ToString());
			bin = (byte[])cmd.ExecuteScalar();

			Response.ContentType = "application/pdf";
			Response.BinaryWrite(bin);
			conn.Close();
		}
	}
}
