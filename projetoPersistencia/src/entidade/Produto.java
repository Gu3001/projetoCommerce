package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nome;
	private String qtdeEst;
	private String qtdeMin;
	private String precoVenda;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getQtdeEst() {
		return qtdeEst;
	}
	public void setQtdeEst(String qtdeEst) {
		this.qtdeEst = qtdeEst;
	}
	public String getQtdeMin() {
		return qtdeMin;
	}
	public void setQtdeMin(String qtdeMin) {
		this.qtdeMin = qtdeMin;
	}
	public String getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(String precoVenda) {
		this.precoVenda = precoVenda;
	}
	
}
