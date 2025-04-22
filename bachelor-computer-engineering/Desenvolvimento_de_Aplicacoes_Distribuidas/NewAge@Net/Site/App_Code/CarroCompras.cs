using System;
using System.Data;
using System.Configuration;
using System.Web;
using System.Web.Security;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.WebControls.WebParts;
using System.Web.UI.HtmlControls;
using System.Collections.Generic;

public class CarroCompras {

	public static String ESTADO_ANULADO = "A";
	public static String ESTADO_CRIADO = "C";
	public static String ESTADO_PENDENTE = "P";
	public static String DONO_ANONIMO = "Anomino";

	private int idCarro;
	private DateTime dataCriacao;
	private String estado;
	private LinkedList<ProdutoCarrinho> produtos;
	private String owner;


	public CarroCompras(int idCarro, DateTime dataCriacao, LinkedList<ProdutoCarrinho> produtos, String owner) {
		this.idCarro = idCarro;
		this.dataCriacao = dataCriacao;
		this.owner = owner;
		this.produtos = (produtos == null ? new LinkedList<ProdutoCarrinho>() : produtos);
	}

	public CarroCompras(String dono) : this(-1, DateTime.Now, null, dono) { }

	public CarroCompras() : this(-1, DateTime.Now, null, DONO_ANONIMO) { }

	public DateTime DataCriacao {
		get {
			return dataCriacao;
		}
	}

	public String Estado {
		get {
			return estado;
		}
		set {
			estado = value;
		}
	}

	/// <summary>
	/// Adiciona um novo produto ao carrinho de compras. Se o produto já existir no carrinho a sua quantidade e'
	/// incrementada no valor da nova quantidade.
	/// </summary>
	/// <param name="idProduto">ID do produto a introduzir</param>
	/// <param name="nome">Nome do produto a introduzir</param>
	/// <param name="precoUn">Preco unitario do produto</param>
	/// <param name="quantidade">Quantidade de produto a introduzir. Se o produto ja existir esta quantidade vai ser 
	/// somada a' quantidade existente.</param>
	/// <param name="codigo">Codigo do produto</param>
	/// <returns>true caso o produto seja introduzido ou actualizado com sucesso ou false em caso contrario.</returns>
	public bool adicionarProduto(int idProduto, String nome, decimal precoUn, int quantidade, String codigo, int stock) {
		if (quantidade <= 0) {
			return false;
		}
		if (produtos == null) {
			produtos = new LinkedList<ProdutoCarrinho>();
		}

		ProdutoCarrinho temp = obterProdutoPorID(idProduto);
		if (temp == null) {
			produtos.AddLast(new ProdutoCarrinho(idProduto, nome, precoUn, quantidade, codigo, stock));
		} else {
			temp.Quantidade += quantidade;
		}

		return true;
	}

	public bool incrementarQuantidade(int idProduto, int incremento) {
		ProdutoCarrinho p = null;
		if ((p = obterProdutoPorID(idProduto)) != null) {
			p.Quantidade += incremento;
			return true;
		}
		return false;
	}

	public bool decrementarQuantidade(int idProduto, int decremento) {
		ProdutoCarrinho p = null;
		if ((p = obterProdutoPorID(idProduto)) != null && p.Quantidade > 0) {
			p.Quantidade -= decremento;
			if (p.Quantidade == 0) {
				produtos.Remove(p);
			}
			return true;
		}
		return false;
	}

	public bool alterarQuantidade(int idProduto, int novaQuantidade) {
		ProdutoCarrinho p = null;
		if ((p = obterProdutoPorID(idProduto)) != null) {
			p.Quantidade = novaQuantidade;
			return true;
		}
		return false;
	}

	public ProdutoCarrinho obterProdutoPorID(int idProduto) {
		if (produtos != null) {
			foreach (ProdutoCarrinho p in produtos) {
				if (p.IDProduto == idProduto) {
					return p;
				}
			}
		}
		return null;
	}

	public bool removerProduto(int idProduto) {
		ProdutoCarrinho p = obterProdutoPorID(idProduto);
		if (p != null) {
			produtos.Remove(p);
			return true;
		}
		return false;
	}

	public LinkedList<ProdutoCarrinho> obterTodosProdutos() {
		LinkedList<ProdutoCarrinho> copia = new LinkedList<ProdutoCarrinho>();

		foreach (ProdutoCarrinho p in produtos) {
			copia.AddLast(p);
		}
		return copia;
	}

	public void removerTodos() {
		if (produtos != null) {
			produtos.Clear();
		}
	}

	public decimal Total {
		get {
			decimal total = 0;
			if (produtos != null) {
				foreach (ProdutoCarrinho p in produtos) {
					total += p.SubTotal;
				}
			}
			return total;
		}
	}

	public int Quantidade {
		get {
			int total = 0;
			if (produtos != null) {
				foreach (ProdutoCarrinho p in produtos) {
					total += p.Quantidade;
				}
			}
			return total;
		}
	}

	public String Dono {
		get {
			return owner;
		}
		set {
			owner = value;
		}
	}
}
