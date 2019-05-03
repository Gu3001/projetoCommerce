package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import entidade.ItensVenda;
import entidade.Venda;
import fabrica.Fabrica;

public class DAOItensVenda {
	private EntityManager gerenciador; //respons�vel em gerenciar entidade, possui CRUD, representa a conexao com o BD
	private EntityTransaction transacao;
	
	public ItensVenda inserir(ItensVenda itensVenda) {
		try {
			
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();//cria gerenciador de entidade
			transacao = gerenciador.getTransaction();//criar controlador de transa��es
			
			transacao.begin();//inicia a transa��o
			gerenciador.persist(itensVenda);//salvar/inserir a entidade
			transacao.commit();//confirma transa��o
			
		}catch(Exception e) {
			e.printStackTrace();//imprime o erro
			transacao.rollback();//cancela a transa��o
		}finally {
			gerenciador.close();
		}return itensVenda;
	}
	public ItensVenda excluir(ItensVenda itensVenda) {
		try {
			// representa a conex�o e tem metodos CRUD
			
			EntityManagerFactory fabrica = Fabrica.get(); //declaramos fabrica, ela representa a classe f�brica
			gerenciador = fabrica.createEntityManager(); //criamos o gerenciador, respons�vel por permitir a intera��o com o banco
			transacao = gerenciador.getTransaction(); //respons�vel por fazer opera��es no banco de altera��o e outras modifica��es
			
			
			transacao.begin();
			itensVenda = gerenciador.find(ItensVenda.class, itensVenda.getId());
			gerenciador.remove(itensVenda);
			transacao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return itensVenda;//retorna o Venda salvo  
		
	}
	public ItensVenda alterar(ItensVenda itensVenda) {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
			transacao = gerenciador.getTransaction();
			
			transacao.begin();
			gerenciador.merge(itensVenda);
			transacao.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}return itensVenda;
	}
	
	
	
	public List<ItensVenda> buscar() {
		try {
			EntityManagerFactory fabrica = Fabrica.get();
			gerenciador = fabrica.createEntityManager();
		
			return gerenciador.createQuery("from ItensVenda").getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
			transacao.rollback();
		}finally {
			gerenciador.close();
		}
		return null;

	}
//	public ItensVenda buscarEspecifico(ItensVenda itensVEnda) {
//		try {
//			
//			EntityManagerFactory fabrica = Fabrica.get();
//			gerenciador = fabrica.createEntityManager();
//			itensVenda = gerenciador.find(Venda.class, venda.getId());
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
