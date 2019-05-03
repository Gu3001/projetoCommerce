	// persist salva
	// merge altera
	// remove apaga
	// find busca
package tela;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DAOCliente;
import dao.DAOItensVenda;
import dao.DAOProduto;
import dao.DAOVenda;
import entidade.ItensVenda;
import entidade.Produto;
import entidade.Venda;
import principal.Principal;

public class TelaItensVenda {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Principal principal = new Principal();
	
	public TelaItensVenda() {
		ItensVenda itensVenda = new ItensVenda();
		DAOItensVenda daoitensvenda = new DAOItensVenda();
		DAOCliente daocliente = new DAOCliente();
		Venda venda = new Venda();
		DAOVenda daovenda = new DAOVenda();
		Produto produto = new Produto();
		
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				listarCadastrosVenda();
				System.out.println("Insira a quantidade do produto de acordo com o id: ");
				String qtde = scan.next();
				itensVenda.setQtde(qtde);
				System.out.println("Insira o Preço ");
				String preco = scan.next();
				itensVenda.setPreco(preco);
				
				listarCadastrosVenda();
				System.out.println("Insira o ID da Venda: ");
				long id = scan.nextLong();
				venda.setId(id);
				itensVenda.setVenda(venda);
				listarProdutos();
				System.out.println("Insira o ID do Produto: ");
				long idProd = scan.nextLong();
				produto.setId(idProd);
				itensVenda.setProduto(produto);
				daoitensvenda.inserir(itensVenda);
				principal.main(null);
				//colocar para retornar para principal no final de cada um
			}
			if (op ==2) {
				listarCadastrosItensVenda();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id do itenVenda a ser excluida: ");
				itensVenda.setId( scan.nextLong() );
				daoitensvenda.excluir(itensVenda);
				principal.main(null);
			}
			if (op ==3) { //arrumar
				listarCadastrosItensVenda();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do itens venda a ser alterada: ");
				itensVenda.setId(scan.nextLong());
				listarCadastrosItensVenda();
				System.out.println("Insira a quantidade do produto de acordo com o id: ");
				String qtde = scan.next();
				itensVenda.setQtde(qtde);
				System.out.println("Insira o Preço ");
				String preco = scan.next();
				itensVenda.setPreco(preco);
				
				listarCadastrosVenda();
				System.out.println("Insira o ID da Venda: ");
				long id = scan.nextLong();
				venda.setId(id);
				itensVenda.setVenda(venda);
				listarProdutos();
				System.out.println("Insira o ID do Produto: ");
				long idProd = scan.nextLong();
				produto.setId(idProd);
				itensVenda.setProduto(produto);
				
				System.out.println("Alterando...");			
		
				daoitensvenda.alterar(itensVenda);
				principal.main(null);
			}
			
			if(op == 4) {
				listarCadastrosItensVenda();
			}

			
			System.out.println("Deseja realmente continuar? (s/n)");
			
			r = scan.nextLine();
			
		}while(r.contentEquals("s"));
	}
	
	public void listarCadastrosItensVenda() {
		DAOItensVenda daoitensvenda = new DAOItensVenda();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODOS Itens de Venda");
		List<ItensVenda> it = daoitensvenda.buscar(); //estudar melhor o percorrer da lista
		
		for(ItensVenda itensvenda : it) {
			System.out.println("Id: "+itensvenda.getId()+" Qtde: "+itensvenda.getQtde()+" Preço: "+itensvenda.getPreco()+" Id venda: "+itensvenda.getVenda().getId()+" Id Produto: "+itensvenda.getProduto().getId());
		}
	}
	public void listarCadastrosVenda() {
		DAOVenda daovenda = new DAOVenda();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODAS VENDAS");
		
		List<Venda> ven = daovenda.buscar(); //estudar melhor o percorrer da lista
		for(Venda venda : ven) {
			System.out.println("Id: "+venda.getId()+" Nome: "+venda.getDtVenda());//acabar de completar
		}
	}
	public void listarProdutos() {
		DAOProduto daoproduto = new DAOProduto();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODOS PRODUTOS");
		
		List<Produto> pro = daoproduto.buscar(); //estudar melhor o percorrer da lista
		for(Produto produto : pro) {
			System.out.println("Id: "+produto.getId()+" nome: "+produto.getNome()+" qtde: "+produto.getQtdeEst()+" qtde Min: "+produto.getQtdeMin()+" preço: "+produto.getPrecoVenda());
		}
	}

}
