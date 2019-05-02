package entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private int statusCliente;
	private String rg;
	private String cpf;
	private String dtNasc;
	@ManyToOne
	private Pessoa pessoa;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getStatusCliente() {
		return statusCliente;
	}
	public void setStatusCliente(int statusCliente) {
		this.statusCliente = statusCliente;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
