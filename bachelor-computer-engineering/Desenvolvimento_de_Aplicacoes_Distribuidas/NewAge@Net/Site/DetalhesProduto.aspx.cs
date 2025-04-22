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

		dvDetalhes = (DataView)dsDetalhes.Select(DataSourceSelectArguments.Empty);
		if (dvDetalhes.Count > 0) {
			enumDetalhes = dvDetalhes.GetEnumerator();
			enumDetalhes.MoveNext();
			drvDetalhes = (DataRowView)enumDetalhes.Current;
			tblDetalhes.Rows[1].BackColor = System.Drawing.Color.White;
			tblDetalhes.Rows[1].Cells[0].Text = "<img class=\"detalhes\" src=\"images/produtos/" + drvDetalhes["ImagemURL"].ToString() + "\">";
		} else {
		}
	}

	protected void tblDetalhes_ItemCommand(object sender, DetailsViewCommandEventArgs e) {
		if (Session["Carrinho"] == null) {
			Session["Carrinho"] = new CarroCompras();
			if (Membership.GetUser() != null) {
				((CarroCompras)Session["Carrinho"]).Dono = (Membership.GetUser().UserName);
			}
		}
		((CarroCompras)Session["Carrinho"]).adicionarProduto(int.Parse(Request.QueryString["id"].ToString()), tblDetalhes.Rows[0].Cells[1].Text, decimal.Parse(tblDetalhes.Rows[3].Cells[1].Text), 1, tblDetalhes.Rows[2].Cells[1].Text, int.Parse(tblDetalhes.Rows[4].Cells[1].Text));
		actualizarDadosCarrinho();
	}

	private void actualizarDadosCarrinho() {
		Label artigos = (Label)Master.FindControl("lblArtigos");
		Label subTotal = (Label)Master.FindControl("lblSubTotal");

		if (Session["Carrinho"] == null) {
			artigos.Text = "Carrinho de compras está vazio.";
			subTotal.Text = "";
		} else {
			CarroCompras carro = (CarroCompras)Session["Carrinho"];
			artigos.Text = "Tem " + carro.Quantidade + " " + (carro.Quantidade == 1 ? "item no carrinho." : "itens no carrinho");
			subTotal.Text = "Total: " + carro.Total.ToString() + "&euro;";
		}
	}
}
