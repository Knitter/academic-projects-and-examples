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
using System.Diagnostics;

public partial class index : System.Web.UI.Page {
	protected void Page_Load(object sender, EventArgs e) {
		lblTituloPesquisa.Text = "Resultados da pesquisa \"" + Request.QueryString["nome"] + "\"";
        if (User.IsInRole("Administrador"))
        {
            gridProdutos.Columns[5].Visible = true;
            gridProdutos.Columns[6].Visible = true;
        }
        else
        {
            gridProdutos.Columns[5].Visible = false;
            gridProdutos.Columns[6].Visible = false;
        }
    }

	protected void gridProdutos_RowCommand(object sender, GridViewCommandEventArgs e) {
		String[] sep = { "</p> " };
		if (e.CommandName == "AddToCart") {
			int idx = Convert.ToInt32(e.CommandArgument);

			DataView dvStock = (DataView)dsResultadosPesquisa.Select(DataSourceSelectArguments.Empty);
			dvStock.RowFilter = "IDProduto = " + gridProdutos.DataKeys[idx].Value.ToString();

			int stock = 0;
			foreach (DataRowView row in dvStock) {
				stock = int.Parse(row["Stock"].ToString());
				break;
			}	

			String preco = gridProdutos.Rows[idx].Cells[3].Text.Split(sep, System.StringSplitOptions.None)[1].ToString();
			adicionarAoCarrinho(int.Parse(gridProdutos.DataKeys[idx].Value.ToString()), 
				((HyperLink)(gridProdutos.Rows[idx].Cells[1].Controls[0])).Text.ToString(), 
				gridProdutos.Rows[idx].Cells[2].Text.Split(sep, System.StringSplitOptions.None)[1].ToString(), 
				decimal.Parse(preco.Remove(preco.Length - 1)), stock);
			actualizarDadosCarrinho();
        }
        else if (e.CommandName == "EditProduto")
        {
            Response.Redirect("~/Admin/EditarProduto.aspx?id=" + int.Parse(gridProdutos.DataKeys[Convert.ToInt32(e.CommandArgument)].Value.ToString()));
        }
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
			subTotal.Text = "Total: " + carro.Total.ToString();
		}
	}

	private void adicionarAoCarrinho(int idProduto, String nome, String codigo, decimal precoUn, int stock) {
		if (Session["Carrinho"] == null) {
			Session["Carrinho"] = new CarroCompras();
			if (Membership.GetUser() != null) {
				((CarroCompras)Session["Carrinho"]).Dono = (Membership.GetUser().UserName);
			}
		}
		((CarroCompras)Session["Carrinho"]).adicionarProduto(idProduto, nome, precoUn, 1, codigo, stock);
	}
}
