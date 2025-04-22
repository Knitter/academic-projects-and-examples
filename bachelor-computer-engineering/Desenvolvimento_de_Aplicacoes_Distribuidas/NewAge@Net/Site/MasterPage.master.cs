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
using System.Xml;
using System.Data.SqlClient;


public partial class images_MasterPage : System.Web.UI.MasterPage {

	private DataView dvCategorias, dvDestaques, dvPromocoes;

	protected void Page_Load(object sender, EventArgs e) {
		DataRowView drvDestaques;
		IEnumerator enumDestaques;

		if (!IsPostBack) {
			dvCategorias = (DataView)dsCategorias.Select(DataSourceSelectArguments.Empty);
			dvCategorias.RowFilter = "IDCategoriaPai IS NULL";
			foreach (DataRowView d in dvCategorias) {
				TreeNode node = new TreeNode(d["Nome"].ToString(), d["ID"].ToString());
				node.PopulateOnDemand = true;
				node.SelectAction = TreeNodeSelectAction.Expand;
				treeCategorias.Nodes.Add(node);
			}

			dvDestaques = (DataView)dsDestaques.Select(DataSourceSelectArguments.Empty);
			dvDestaques.RowFilter = "ProdutoDia = 1";

			if (dvDestaques.Count > 0) {
				enumDestaques = dvDestaques.GetEnumerator();
				enumDestaques.MoveNext();
				drvDestaques = (DataRowView)enumDestaques.Current;
				lnDiaNome.Text = drvDestaques["Nome"].ToString();
				lnDiaNome.NavigateUrl = "~/DetalhesProduto.aspx?id=" + drvDestaques["IDProd"].ToString();
				imgDia.ImageUrl = "images/produtos/" + drvDestaques["ImagemURL"].ToString();
				lblDiaPreco.Text = String.Format("{0:F2} &euro;", drvDestaques["Preco"]);
			} else {
				tblTituloDia.Visible = false;
				pnProdutoDia.Visible = false;
			}

			dvDestaques.RowFilter = "ProdutoDia = 0";
			if (dvDestaques.Count > 0)
				iniciarAdRotator(rotatorDestaques, dvDestaques);
			else {
				tblTituloDestaques.Visible = false;
				pnDestaques.Visible = false;
			}

			dvPromocoes = (DataView)dsPromocoes.Select(DataSourceSelectArguments.Empty);
			if (dvPromocoes.Count > 0)
				iniciarAdRotator(rotatorPromocoes, dvPromocoes);
			else {
				tblTituloPromocoes.Visible = false;
				pnPromocoes.Visible = false;
			}
		}
		actualizarDadosCarrinho();
	}

	private void actualizarDadosCarrinho() {
		if (Session["Carrinho"] == null || ((CarroCompras)Session["Carrinho"]).Quantidade == 0) {
			lblArtigos.Text = "Não tem artigos no seu carrinho.";
			lblSubTotal.Text = "";
		} else {
			CarroCompras carro = (CarroCompras)Session["Carrinho"];
			lblArtigos.Text = "Tem " + carro.Quantidade + " " + (carro.Quantidade == 1 ? "item no carrinho." : "itens no carrinho");
			lblSubTotal.Text = "Total: " + carro.Total.ToString() + "&euro;";
		}
	}

	private void iniciarAdRotator(AdRotator rotator, DataView dView) {
		IEnumerator enumerator;
		DataRowView drView;
		XmlDocument xmlRotator = new XmlDocument();
		XmlNode docNode = xmlRotator.CreateXmlDeclaration("1.0", "utf-8", null);
		xmlRotator.AppendChild(docNode);

		XmlNode adsNode = xmlRotator.CreateElement("Advertisements");
		xmlRotator.AppendChild(adsNode);

		enumerator = dView.GetEnumerator();
		while (enumerator.MoveNext()) {
			XmlNode adNode = xmlRotator.CreateElement("Ad");
			adsNode.AppendChild(adNode);

			drView = (DataRowView)enumerator.Current;

			XmlNode childNode = xmlRotator.CreateElement("Nome");
			childNode.AppendChild(xmlRotator.CreateTextNode(drView["Nome"].ToString()));
			adNode.AppendChild(childNode);

			childNode = xmlRotator.CreateElement("NavigateUrl");
			childNode.AppendChild(xmlRotator.CreateTextNode("~/DetalhesProduto.aspx?id=" + drView["IDProd"].ToString()));
			adNode.AppendChild(childNode);

			childNode = xmlRotator.CreateElement("ImageUrl");
			childNode.AppendChild(xmlRotator.CreateTextNode(drView["ImagemURL"].ToString()));
			adNode.AppendChild(childNode);

			childNode = xmlRotator.CreateElement("Preco");
			childNode.AppendChild(xmlRotator.CreateTextNode(String.Format("{0:F2}{1}", drView["Preco"], " €")));
			adNode.AppendChild(childNode);
		}
		//xmlRotator.Save("./Site/" + rotator.ID + ".xml");
		xmlRotator.Save(Server.MapPath(rotator.ID + ".xml"));
	}

	protected void treeCategorias_TreeNodePopulate(object sender, TreeNodeEventArgs e) {
		dvCategorias.RowFilter = "IDCategoriaPai = " + e.Node.Value;
		foreach (DataRowView d in dvCategorias) {
			TreeNode node = new TreeNode(d["Nome"].ToString(), d["ID"].ToString());
			node.NavigateUrl = "~/Default.aspx?id=" + d["ID"].ToString() + "&nome=" + d["Nome"];
			e.Node.ChildNodes.Add(node);
		}
	}

	protected void ctrlLogin_LoginError(object sender, EventArgs e) {
		Response.Redirect("RecuperarPassword.aspx");
	}

	protected void rotatorDestaques_AdCreated(object sender, AdCreatedEventArgs e) {
        e.ImageUrl = "images/produtos/" + e.ImageUrl;
        lnDestaquesNome.Text = e.AdProperties["Nome"].ToString();
		lnDestaquesNome.NavigateUrl = e.AdProperties["NavigateUrl"].ToString();
		lblDestaquesPreco.Text = e.AdProperties["Preco"].ToString();
	}

	protected void rotatorPromocoes_AdCreated(object sender, AdCreatedEventArgs e) {
        e.ImageUrl = "images/produtos/" + e.ImageUrl;
        lnPromocoesNome.Text = e.AdProperties["Nome"].ToString();
		lnPromocoesNome.NavigateUrl = e.AdProperties["NavigateUrl"].ToString();
		lblPromocoesPreco.Text = e.AdProperties["Preco"].ToString();
	}

	protected void ctrlLogin_LoggedIn(object sender, EventArgs e) {
		SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ToString());
		SqlCommand cmd = conn.CreateCommand();

		cmd.CommandText = "SELECT ID FROM Cliente WHERE ExternalID = @External";
		MembershipUser u = Membership.GetUser(((Login)LoginView1.FindControl("ctrlLogin")).UserName);
		cmd.Parameters.AddWithValue("@External", Membership.GetUser(((Login)LoginView1.FindControl("ctrlLogin")).UserName).ProviderUserKey);

		conn.Open();
		SqlDataReader reader = cmd.ExecuteReader();

		while (reader.Read()) {
			Session["IDClienteAut"] = reader[0].ToString();
		}

		conn.Close();

		if (Session["Carrinho"] != null) {
			if (((CarroCompras)Session["Carrinho"]).Dono.Equals(CarroCompras.DONO_ANONIMO)) {
				((CarroCompras)Session["Carrinho"]).Dono = u.UserName;
			} else if (!((CarroCompras)Session["Carrinho"]).Dono.Equals(u.UserName)) {
				Session["Carrinho"] = null;
			}
		}
	}

	protected void btnPesquisar_Click1(object sender, EventArgs e) {
		Response.Redirect("~/ResultadosPesquisa.aspx?nome=" + txtPesquisa.Text);
	}

	protected void dsPromocoes_Selecting(object sender, SqlDataSourceSelectingEventArgs e) {

	}

}
