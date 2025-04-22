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

public partial class RecuperarPassword : System.Web.UI.Page {
	protected void Page_Load(object sender, EventArgs e) {

	}
	protected void PasswordRecovery_SendMailError(object sender, SendMailErrorEventArgs e) {
        Response.Redirect("ErroSMTP.aspx");
	}
}
