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

public partial class Admin_GerirVendas : System.Web.UI.Page {

	protected void Page_Load(object sender, EventArgs e) {

	}

	protected void GridView1_RowCommand(object sender, GridViewCommandEventArgs e) {

		if (e.CommandName == "FinalizarVenda") {
			int idx = Convert.ToInt32(e.CommandArgument);
			dsVendas.UpdateParameters["ID"].DefaultValue = GridView1.DataKeys[idx].Value.ToString();
			dsVendas.Update();
			GridView1.DataBind();
		}
	}
}
