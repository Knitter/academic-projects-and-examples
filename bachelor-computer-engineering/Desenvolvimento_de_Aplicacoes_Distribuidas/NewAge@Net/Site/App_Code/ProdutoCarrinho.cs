using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;

public class ProdutoCarrinho {

	private int idProduto;
	private String nome;
	private decimal precoUn;
	private int quantidade;
	private String codigo;
	private int disponibilidade;

	public ProdutoCarrinho(int idProduto, String nome, decimal precoUn, int quantidade, String codigo, int disponibilidade) {
		this.idProduto = idProduto;
		this.nome = nome;
		this.precoUn = precoUn;
		this.quantidade = quantidade;
		this.codigo = codigo;
		this.disponibilidade = disponibilidade;
	}

	public int IDProduto {
		get {
			return idProduto;
		}
	}

	public String Codigo {
		get {
			return codigo;
		}
	}

	public String Nome {
		get {
			return nome;
		}
	}

	public decimal PrecoUnitario {
		get {
			return precoUn;
		}
	}

	public int Quantidade {
		get {
			return quantidade;
		}

		set {
			quantidade = value;
		}
	}

	public decimal SubTotal {
		get {
			return precoUn * quantidade;
		}
	}

	public int Disponibilidade {
		get {
			return disponibilidade;
		}
	}
}
