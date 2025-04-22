using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;

/// <summary>
/// Classe de conveniencia para introduzir os dados do carrinho de compras na base de dados.
/// </summary>
public class GuardarCarrinho {

	private GuardarCarrinho() {
		//nothing
	}

	/// <summary>
	/// Permite inserir os dados de um carro de compras na base de dados.
	/// </summary>
	/// <param name="connString">Connection string a usar para estabelecer a ligacao</param>
	/// <param name="carro">Carro a persistir</param>
	/// <param name="idCliente">ID do cliente a quem pertence o carro</param>
	/// <returns></returns>
	public static int comprar(String connString, CarroCompras carro, int idCliente) {
		SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings[connString].ToString());

		conn.Open();
		SqlTransaction trans = conn.BeginTransaction();
		try {
			SqlCommand cmd = conn.CreateCommand();
			cmd.CommandText = "INSERT INTO Carrinho(DataCriacao, Estado, IDCliente) VALUES(@DataCriacao, @Estado, @IDCliente)";


			cmd.Transaction = trans;//porque motivo temos de associar a transaccao ao comando

			cmd.Parameters.AddWithValue("@DataCriacao", carro.DataCriacao);
			cmd.Parameters.AddWithValue("@Estado", carro.Estado);
			cmd.Parameters.AddWithValue("@IDCliente", idCliente);
			int total = cmd.ExecuteNonQuery();
			cmd.Parameters.Clear();
			cmd.CommandText = "SELECT @@IDENTITY";
			int idCarroInserido = Convert.ToInt32(cmd.ExecuteScalar());
			cmd.Parameters.Clear();
			cmd.CommandText = "INSERT INTO LinhaCarrinho(IDCarrinho, IDProduto, Quantidade) VALUES(@IDCarrinho, @IDProduto, @Quantidade)";
			cmd.Parameters.Add("@IDCarrinho", SqlDbType.Int);
			cmd.Parameters.Add("@IDProduto", SqlDbType.Int);
			cmd.Parameters.Add("@Quantidade", SqlDbType.SmallInt);

			foreach (ProdutoCarrinho p in carro.obterTodosProdutos()) {
				cmd.Parameters["@IDCarrinho"].Value = idCarroInserido.ToString();
				cmd.Parameters["@IDProduto"].Value = p.IDProduto;
				cmd.Parameters["@Quantidade"].Value = p.Quantidade;
				cmd.ExecuteNonQuery();
			}
			trans.Commit();
			return idCarroInserido;
		} catch (Exception ex){
			trans.Rollback();
		} finally {
			conn.Close();
		}
		return -1;
	}

}
