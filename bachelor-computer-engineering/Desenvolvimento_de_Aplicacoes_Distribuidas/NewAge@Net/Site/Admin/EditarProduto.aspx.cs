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

public partial class detalhesProduto : System.Web.UI.Page {

	private DataView dvDetalhes;
	private IEnumerator enumDetalhes;
	private DataRowView drvDetalhes;

	protected void Page_Load(object sender, EventArgs e) {

	}
    protected void tblDetalhes_ItemUpdating(object sender, DetailsViewUpdateEventArgs e)
    {
        FileUpload fUp = (FileUpload)tblDetalhes.FindControl("FileUpload1");

        if (fUp.HasFile)
        {
            fUp.SaveAs(Server.MapPath("~/images/produtos/") + fUp.FileName);
        }
    }
}
