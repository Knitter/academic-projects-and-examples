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

public partial class Admin_GerirProdutos : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void DetailsView1_ItemInserted(object sender, DetailsViewInsertedEventArgs e)
    {
    }

    protected void FileUpload1_DataBinding(object sender, EventArgs e)
    {
    
    }
    protected void DetailsView1_ItemInserting(object sender, DetailsViewInsertEventArgs e)
    {
        FileUpload fUp = (FileUpload)DetailsView1.FindControl("FileUpload1");
        
        if (fUp.HasFile)
        {
            fUp.SaveAs(Server.MapPath("~/images/produtos/") + fUp.FileName);
            Debug.WriteLine("file uploaded");
        }
        else
        {
            Debug.WriteLine("no file to upload");
        }
    }
}
