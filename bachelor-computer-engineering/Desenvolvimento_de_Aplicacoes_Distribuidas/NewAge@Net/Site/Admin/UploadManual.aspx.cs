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

public partial class Admin_Criar_Manual : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void btnUpload_Click(object sender, EventArgs e)
    {
        HttpPostedFile file = Request.Files[0];
        if (file.ContentLength == 0)
            return;
        Byte[] bin = new byte[file.ContentLength];
        file.InputStream.Read(bin, 0, file.ContentLength);

        SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings[0].ConnectionString);
        conn.Open();
        SqlCommand cmd = conn.CreateCommand();
        cmd.CommandText = "INSERT INTO Manual (Nome, Tipo, tamanho, conteudo) values (@Nome, @Tipo, @tamanho, @Dados)";
        cmd.Parameters.Clear();
        cmd.Parameters.AddWithValue("@Nome", file.FileName);
        cmd.Parameters.AddWithValue("@Tipo", file.ContentType);
        cmd.Parameters.AddWithValue("@Tamanho", file.ContentLength);
        cmd.Parameters.AddWithValue("@Dados", bin);
        cmd.ExecuteNonQuery();
        
        cmd.CommandText = "SELECT @@identity";
        int NovoID = int.Parse(cmd.ExecuteScalar().ToString());
        
        cmd.CommandText = "INSERT INTO Pertencer (IDProduto, IDManual) values (@IDProduto, @IDManual)";
        cmd.Parameters.Clear();
        cmd.Parameters.AddWithValue("IDProduto", DropDownList1.SelectedValue);
        cmd.Parameters.AddWithValue("@IDManual", NovoID);
        cmd.ExecuteNonQuery();
    }
}
