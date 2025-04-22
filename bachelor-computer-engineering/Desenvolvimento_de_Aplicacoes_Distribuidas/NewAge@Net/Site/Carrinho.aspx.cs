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

public partial class Cliente_Carrinho : System.Web.UI.Page {

	protected void Page_Load(object sender, EventArgs e) {
		if (!IsPostBack) {
			if (Request.UrlReferrer != null) {
				Session["PreviousURL"] = Request.UrlReferrer.ToString();
			}
			actualizarDadosCarrinho();
		}
		if (Membership.GetUser() == null) {
			painelUserNaoAutenticado.Visible = true;
		} else {
			painelUserNaoAutenticado.Visible = false;
		}
	}

	protected void objdsCarrinho_ObjectCreating(object sender, ObjectDataSourceEventArgs e) {
		if (Session["Carrinho"] == null) {
			Session["Carrinho"] = new CarroCompras();
			if (Membership.GetUser() != null) {
				((CarroCompras)Session["Carrinho"]).Dono = (Membership.GetUser().UserName);
			}
		}
		e.ObjectInstance = (CarroCompras)Session["Carrinho"];
	}

	protected void objdsCarrinho_ObjectDisposing(object sender, ObjectDataSourceDisposingEventArgs e) {
		Session["Carrinho"] = (CarroCompras)e.ObjectInstance;
	}

	private void actualizarDadosCarrinho() {
		Label artigos = (Label)Master.FindControl("lblArtigos");
		Label subTotal = (Label)Master.FindControl("lblSubTotal");

		if (Session["Carrinho"] == null || ((CarroCompras)Session["Carrinho"]).Quantidade == 0) {
			artigos.Text = "Carrinho de compras está vazio.";
			subTotal.Text = "";
			lblTotalCarrinho.Text = "";
			
			Button btn1 = (Button)LoginView1.FindControl("btnComprarAnonym");
			if (btn1 != null) {
				btn1.Visible = false;
			}

			Button btn2 = (Button)LoginView1.FindControl("btnAnularCarro");
			if (btn2 != null) {
				btn2.Visible = false;
			}

			Button btn3 = (Button)LoginView1.FindControl("btnGuardarCarro");
			if (btn3 != null) {
				btn3.Visible = false;
			}

			Button btn4 = (Button)LoginView1.FindControl("btnComprar");
			if (btn4 != null) {
				btn4.Visible = false;
			}

			painelCarroVazio.Visible = true;
			painelUserNaoAutenticado.Visible = false;


		} else {
			CarroCompras carro = (CarroCompras)Session["Carrinho"];
			artigos.Text = "Tem " + carro.Quantidade + " " + (carro.Quantidade == 1 ? "item no carrinho." : "itens no carrinho");
			subTotal.Text = String.Format("{0:F2} &euro;", "Total: " + carro.Total.ToString());
			lblTotalCarrinho.Text = String.Format("{0:F2} &euro;", "Total: " + carro.Total.ToString());
			
			Button btn1 = (Button)LoginView1.FindControl("btnComprarAnonym");
			if (btn1 != null) {
				btn1.Visible = true;
			}

			Button btn2 = (Button)LoginView1.FindControl("btnAnularCarro");
			if (btn2 != null) {
				btn2.Visible = true;
			}

			Button btn3 = (Button)LoginView1.FindControl("btnGuardarCarro");
			if (btn3 != null) {
				btn3.Visible = true;
			}

			Button btn4 = (Button)LoginView1.FindControl("btnComprar");
			if (btn4 != null) {
				btn4.Visible = true;
			}

			painelCarroVazio.Visible = false;
		}
		gridCarrinho.DataBind();
	}

	protected void gridCarrinho_RowCommand(object sender, GridViewCommandEventArgs e) {
		if (e.CommandName == "incrementar") {
			((CarroCompras)Session["Carrinho"]).incrementarQuantidade(Convert.ToInt32(e.CommandArgument), 1);
			actualizarDadosCarrinho();

		} else if (e.CommandName == "decrementar") {
			((CarroCompras)Session["Carrinho"]).decrementarQuantidade(Convert.ToInt32(e.CommandArgument), 1);
			actualizarDadosCarrinho();
		}
	}

	protected void gridCarrinho_RowDeleted(object sender, GridViewDeletedEventArgs e) {
		actualizarDadosCarrinho();
	}

	protected void btnAnularCarro_Click(object sender, EventArgs e) {
		if (Session["Carrinho"] != null && Session["IDClienteAut"] != null) {
			((CarroCompras)Session["Carrinho"]).Estado = CarroCompras.ESTADO_ANULADO;
			GuardarCarrinho.comprar("ConnectionString", (CarroCompras)Session["Carrinho"], Convert.ToInt32(Session["IDClienteAut"]));
			((CarroCompras)Session["Carrinho"]).removerTodos();
			Session["Carrinho"] = new CarroCompras();
			if (Membership.GetUser() != null) {
				((CarroCompras)Session["Carrinho"]).Dono = (Membership.GetUser().UserName);
			}
		}
	}

	protected void btnGuardarCarro_Click(object sender, EventArgs e) {
		if (Session["Carrinho"] != null && Session["IDClienteAut"] != null) {
			((CarroCompras)Session["Carrinho"]).Estado = CarroCompras.ESTADO_PENDENTE;
			GuardarCarrinho.comprar("ConnectionString", (CarroCompras)Session["Carrinho"], Convert.ToInt32(Session["IDClienteAut"]));
		}
	}

	protected void btnComprar_Click(object sender, EventArgs e) {
		Response.Redirect("Cliente/ConfirmarCompra.aspx");
	}

	protected void btnContinuar_Click(object sender, EventArgs e) {
		if (Session["PreviousURL"] != null && !((String)Session["PreviousURL"]).Contains("Carrinho.aspx")) {
			String redirect = (String)Session["PreviousURL"];
			Session["PreviousURL"] = null;
			Response.Redirect(redirect);
		} else {
			Response.Redirect("Default.aspx");
		}
	}

	protected void btnComprarAnonym_Click(object sender, EventArgs e) {
		Session["ComCompra"] = true;
		Response.Redirect("CriarUtilizador.aspx");
	}
}
