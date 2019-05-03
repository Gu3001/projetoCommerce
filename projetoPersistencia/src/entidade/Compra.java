package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Compra {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String dtCompra;
	@ManyToOne
	private Fornecedor fornecedor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDtCompra() {
		return dtCompra;
	}
	public void setDtCompra(String dtCompra) {
		this.dtCompra = dtCompra;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
