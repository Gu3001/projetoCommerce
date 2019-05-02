package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
	@Entity
public class Venda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String dtVenda;
	@ManyToOne
	private Cliente cliente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDtVenda() {
		return dtVenda;
	}
	public void setDtVenda(String dtVenda) {
		this.dtVenda = dtVenda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
