package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import entidade.Compra;
@Entity
public class ItensCompra {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String qtde;
	private String preco;
	@ManyToOne
	private Compra compra;
	@ManyToOne
	private Produto produto;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getQtde() {
		return qtde;
	}
	public void setQtde(String qtde) {
		this.qtde = qtde;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
