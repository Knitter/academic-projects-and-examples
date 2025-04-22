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
using System.Data.SqlTypes;

public partial class Cliente_AreaPessoal : System.Web.UI.Page {
	
	protected void Page_Load(object sender, EventArgs e) {
		if (!IsPostBack) {
			MembershipUser u;
			if ((u = Membership.GetUser()) != null)
				Profile.guid = u.ProviderUserKey.ToString();
		}
	}

	protected void dsUtilizador_Selecting(object sender, SqlDataSourceSelectingEventArgs e) {
	}
}
