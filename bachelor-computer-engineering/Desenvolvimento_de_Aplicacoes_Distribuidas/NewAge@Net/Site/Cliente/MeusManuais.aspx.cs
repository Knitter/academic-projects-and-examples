using System.Diagnostics;
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

public partial class Cliente_MeuManuais : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void dsManuais_Selecting(object sender, SqlDataSourceSelectingEventArgs e)
    {
    }
    protected void GridView1_RowCommand(object sender, GridViewCommandEventArgs e)
    {
        if (e.CommandName == "GetManual")
        {
            SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings[0].ConnectionString);
            conn.Open();
            SqlCommand cmd = conn.CreateCommand();
            cmd.CommandText = "SELECT conteudo FROM Manual WHERE ID = @IDManual";

            byte[] bin;
            cmd.Parameters.Clear();
            cmd.Parameters.AddWithValue("@IDManual", GridView1.DataKeys[Convert.ToInt32(e.CommandArgument)].Value.ToString());
            bin = (byte[]) cmd.ExecuteScalar();

            Response.ContentType = "application/pdf";
            Response.BinaryWrite(bin);
        }
    }
}
