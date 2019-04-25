package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Estado;
import fabrica.Fabrica;

public class DAOEstado {
	private EntityManager gerenciador;
	private EntityTransaction transacao;
	
	public Estado inserir(Estado estado) {
		try {
			
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.persist(estado);
			transacao.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}return estado;
	}
	public Estado excluir(Estado estado) {
		try {
			// representa a conex�o e tem metodos CRUD
			
			EntityManagerFactory fabrica = Fabrica.get(); //declaramos fabrica, ela representa a classe f�brica
			gerenciador = fabrica.createEntityManager(); //criamos o gerenciador, respons�vel por permitir a intera��o com o banco
			transacao = gerenciador.getTransaction(); //respons�vel por fazer opera��es no banco de altera��o e outras modifica��es
			
			
			transacao.begin();
			estado = gerenciador.find(Estado.class, estado.getId());
			gerenciador.remove(estado);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}return estado;
		
	}
	public Estado alterar(Estado estado) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(estado);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}return estado;
	}
	
	
	
	public List<Estado> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			
			return gerenciador.createQuery("from Estado").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}
		return null;

	}
	
//	public Estado deletar(Estado estado) {
//		try {
//			EntityManagerFactory fabrica = Fabrica.get();
//			gerenciador = fabrica.createEntityManager();
//			transacao = gerenciador.getTransaction();
//			
//			transacao.begin();
//			gerenciador.remove();
//			transacao.commit();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			transacao.rollback();
//		}
//		return estado;
//	}
}
