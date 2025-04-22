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
using System.Diagnostics;

public partial class ConfirmarCompra : System.Web.UI.Page {

	protected void Page_Load(object sender, EventArgs e) {
		if (Session["Carrinho"] != null) {
			lblTotal.Text = ((CarroCompras)Session["Carrinho"]).Total.ToString() + " &euro";
			foreach (ProdutoCarrinho p in ((CarroCompras)Session["Carrinho"]).obterTodosProdutos()) {
				if (p.Disponibilidade == 0 || p.Disponibilidade < p.Quantidade) {
					painelForaStock.Visible = true;
					break;
				}
				painelForaStock.Visible = false;
			}
		} else {
			lblTotal.Text = "";//should never happen
		}

		if (!IsPostBack) {
			int idCliente = Convert.ToInt32(Session["IDClienteAut"]);
			SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ToString());
			SqlCommand cmd = conn.CreateCommand();
			try {
				cmd.CommandText = "SELECT Contribuinte FROM Cliente WHERE ID = @IDC";
				cmd.Parameters.AddWithValue("@IDC", idCliente);

				SqlDataReader reader = cmd.ExecuteReader();
				String contrib = "";
				while (reader.Read()) {
					contrib = reader[0].ToString();
					break;
				}

				if (contrib.Length > 0) {
					painelDadosFalta.Visible = false;
				} else {
					painelDadosFalta.Visible = true;
				}
			} catch {
				//ignore
				painelDadosFalta.Visible = false;
			} finally {
				conn.Close();
			}
		}
	}

	protected void btnCancelar_Click(object sender, EventArgs e) {
		Response.Redirect("~/Carrinho.aspx");
	}

	protected void btnConfirmar_Click(object sender, EventArgs e) {
		CarroCompras carro = (CarroCompras)Session["Carrinho"];
		int idCliente = Convert.ToInt32(Session["IDClienteAut"]);
		bool visa = (rbVisa.Checked && painelPagamento2.Visible);

		carro.Estado = CarroCompras.ESTADO_CRIADO;
		int idCarrinhoGuardado = GuardarCarrinho.comprar("ConnectionString", carro, idCliente);
		if (idCarrinhoGuardado != -1) {
			SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["ConnectionString"].ToString());
			SqlCommand cmd = conn.CreateCommand();
			cmd.CommandText = "INSERT INTO Venda(DataVenda, CustoTotal, EstadoEnvio, EstadoPagamento, IDCliente) VALUES(@DataVenda, @CustoTotal, @EstadoEnvio, @EstadoPagamento, @IDCliente)";

			SqlTransaction trans = null;
			try {
				conn.Open();
				trans = conn.BeginTransaction();
				cmd.Transaction = trans;
				cmd.Parameters.AddWithValue("@DataVenda", DateTime.Now);
				cmd.Parameters.AddWithValue("@CustoTotal", carro.Total);
				cmd.Parameters.AddWithValue("@EstadoEnvio", Utils.ESTADO_ENVIO_PENDENTE);
				if (visa) {
					cmd.Parameters.AddWithValue("@EstadoPagamento", Utils.ESTADO_PAGAMENTO_CONCLUIDO);
				} else {
					cmd.Parameters.AddWithValue("@EstadoPagamento", Utils.ESTADO_PAGAMENTO_PENDENTE);
				}
				cmd.Parameters.AddWithValue("@IDCliente", idCliente);
				cmd.ExecuteNonQuery();

				cmd.Parameters.Clear();
				cmd.CommandText = "SELECT @@IDENTITY";
				String idVenda = cmd.ExecuteScalar().ToString();

				cmd.Parameters.Clear();
				cmd.CommandText = "INSERT INTO Transformar(IDCarrinho, IDVenda) VALUES(@IDCarrinho, @IDVenda)";
				cmd.Parameters.AddWithValue("@IDCarrinho", idCarrinhoGuardado);
				cmd.Parameters.AddWithValue("@IDVenda", idVenda);
				cmd.ExecuteNonQuery();

				cmd.Parameters.Clear();
				cmd.CommandText = "INSERT INTO LinhaVenda(IDVenda, IDProduto, PrecoUnitario, SubTotal, Quantidade) VAlUES(@IDVenda, @IDProduto, @PrecoUnitario, @SubTotal, @Quantidade)";
				cmd.Parameters.Add("@IDVenda", SqlDbType.Int);
				cmd.Parameters.Add("@IDProduto", SqlDbType.Int);
				cmd.Parameters.Add("@PrecoUnitario", SqlDbType.Money);
				cmd.Parameters.Add("@SubTotal", SqlDbType.Money);
				cmd.Parameters.Add("@Quantidade", SqlDbType.SmallInt);

				SqlCommand cmdStock = conn.CreateCommand();
				cmdStock.Transaction = trans;
				cmdStock.CommandText = "UPDATE Produto SET Stock = (Stock - @Quantidade)";
				cmdStock.Parameters.Add("@Quantidade", SqlDbType.Int);

				foreach (ProdutoCarrinho p in carro.obterTodosProdutos()) {
					cmd.Parameters["@IDVenda"].Value = idVenda;
					cmd.Parameters["@IDProduto"].Value = p.IDProduto;
					cmd.Parameters["@PrecoUnitario"].Value = p.PrecoUnitario;
					cmd.Parameters["@SubTotal"].Value = p.SubTotal;
					cmd.Parameters["@Quantidade"].Value = p.Quantidade;
					cmd.ExecuteNonQuery();

					cmdStock.Parameters["@Quantidade"].Value = p.Quantidade;
					cmdStock.ExecuteNonQuery();
				}

				if (visa) {
					String numero = ((TextBox)painelPagamento2.FindControl("txtVisaNum")).Text;
					String titular = ((TextBox)painelPagamento2.FindControl("txtNome")).Text;
					cmd.CommandText = "INSERT INTO Cartao(IDCliente, Numero, Titular) VALUES(@IDCliente, @Numero, @Titular)";
					cmd.Parameters.Clear();

					cmd.Parameters.AddWithValue("@IDCliente", idCliente);
					cmd.Parameters.AddWithValue("@Numero", numero);
					cmd.Parameters.AddWithValue("@Titular", titular);
					cmd.ExecuteNonQuery();

					cmd.Parameters.Clear();
					cmd.CommandText = "SELECT @@IDENTITY";
					int idCartao = Convert.ToInt32(cmd.ExecuteScalar());

					cmd.CommandText = "INSERT INTO Associar(IDVenda, IDCartao, IDCliente) VALUES (@IDVenda, @IDCartao, @IDCliente)";
					cmd.Parameters.AddWithValue("@IDVenda", idVenda);
					cmd.Parameters.AddWithValue("@IDCartao", idCartao);
					cmd.Parameters.AddWithValue("@IDCliente", idCliente);
					cmd.ExecuteNonQuery();
				} else {
					cmd.CommandText = "UPDATE Venda SET Referencia = @Referencia";
					cmd.Parameters.Clear();
					cmd.Parameters.AddWithValue("@Referencia", ((Label)painelPagamento1.FindControl("lblReferencia")).Text);
					cmd.ExecuteNonQuery();
				}

				if (painelForaStock.Visible) {

					cmd.Parameters.Clear();
					cmd.CommandText = "INSERT INTO Notificacao(DataCriacao, Estado) VALUES(@DataCriacao, @Estado)";
					cmd.Parameters.AddWithValue("@DataCriacao", DateTime.Now);
					cmd.Parameters.AddWithValue("@Estado", "A");
					cmd.ExecuteNonQuery();
					cmd.Parameters.Clear();
					cmd.CommandText = "SELECT @@IDENTITY";
					int idNotificacao = Convert.ToInt32(cmd.ExecuteScalar());

					cmd.Parameters.Clear();
					cmd.CommandText = "INSERT INTO Notificar(IDProduto, IDNotificacao) VALUES(@IDProduto, @IDNotificacao)";
					cmd.Parameters.Add("@IDProduto", SqlDbType.Int);
					cmd.Parameters.Add("@IDNotificacao", SqlDbType.Int);
					foreach (ProdutoCarrinho p in carro.obterTodosProdutos()) {
						if (p.Disponibilidade == 0 || p.Disponibilidade < p.Quantidade) {
							cmd.Parameters["@IDProduto"].Value = p.IDProduto;
							cmd.Parameters["@IDNotificacao"].Value = idNotificacao;
							cmd.ExecuteNonQuery();
						}
					}
				}

				trans.Commit();
				Session["Carrinho"] = null;
				Session["PreviousURL"] = null;
				Session["ComCompra"] = null;
				Response.Redirect("CompraEfectuada.aspx");
			} catch (SqlException ex) {
				if (trans != null) {
					trans.Rollback();
					Response.Redirect("ImpossivelComprar.aspx");
				}
			} finally {
				conn.Close();
			}
		} else {
			Response.Redirect("ImpossivelComprar.aspx");
		}
	}

	protected void rbMultibanco_CheckedChanged(object sender, EventArgs e) {
		painelPagamento1.Visible = true;
		painelPagamento2.Visible = false;
		((Label)painelPagamento1.FindControl("lblEntidade")).Text = Utils.ENTIDADE;
		((Label)painelPagamento1.FindControl("lblReferencia")).Text = Utils.gerarReferenciaAleatoria();
	}

	protected void rbVisa_CheckedChanged(object sender, EventArgs e) {
		painelPagamento1.Visible = false;
		painelPagamento2.Visible = true;
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
}
