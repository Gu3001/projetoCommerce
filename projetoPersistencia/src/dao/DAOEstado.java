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
			// representa a conexão e tem metodos CRUD
			
			EntityManagerFactory fabrica = Fabrica.get(); //declaramos fabrica, ela representa a classe fábrica
			gerenciador = fabrica.createEntityManager(); //criamos o gerenciador, responsável por permitir a interação com o banco
			transacao = gerenciador.getTransaction(); //responsável por fazer operações no banco de alteração e outras modificações
			
			
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
