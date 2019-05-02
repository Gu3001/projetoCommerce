package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.Venda;
import fabrica.Fabrica;

public class DAOVenda {
	private EntityManager gerenciador; //responsável em gerenciar entidade, possui CRUD, representa a conexao com o BD
	private EntityTransaction transacao;
	
	public Venda inserir(Venda venda) {
		try {
			
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();//cria gerenciador de entidade
			transacao = gerenciador.getTransaction();//criar controlador de transações
			
			transacao.begin();//inicia a transação
			gerenciador.persist(venda);//salvar/inserir a entidade
			transacao.commit();//confirma transação
			
		}catch(Exception e) {
			e.printStackTrace();//imprime o erro
			transacao.rollback();//cancela a transação
		}finally {
			gerenciador.close();
		}return venda;
	}
	public Venda excluir(Venda venda) {
		try {
			// representa a conexão e tem metodos CRUD
			
			EntityManagerFactory fabrica = Fabrica.get(); //declaramos fabrica, ela representa a classe fábrica
			gerenciador = fabrica.createEntityManager(); //criamos o gerenciador, responsável por permitir a interação com o banco
			transacao = gerenciador.getTransaction(); //responsável por fazer operações no banco de alteração e outras modificações
			
			
			transacao.begin();
			venda = gerenciador.find(Venda.class, venda.getId());
			gerenciador.remove(venda);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return venda;//retorna o Venda salvo  
		
	}
	public Venda alterar(Venda venda) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(venda);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return venda;
	}
	
	
	
	public List<Venda> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from Venda").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;

	}
//	public Venda buscarEspecifico(Venda venda) {
//		try {
//			
//			EntityManagerFactory fabrica = Fabrica.get();
//			gerenciador = fabrica.createEntityManager();
//			venda = gerenciador.find(Venda.class, venda.getNome());
//			transacao.commit();
//			
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//			transacao.rollback();
//		}finally {
//			gerenciador.close();
//		}
//		return venda;
//	}

}
