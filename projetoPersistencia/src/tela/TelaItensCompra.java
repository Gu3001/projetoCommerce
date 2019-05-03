	// persist salva
	// merge altera
	// remove apaga
	// find busca
package tela;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompra;
import dao.DAOItensCompra;
import dao.DAOProduto;
import entidade.Compra;
import entidade.ItensCompra;
import entidade.Produto;
import principal.Principal;

public class TelaItensCompra {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Principal principal = new Principal();
	
	public TelaItensCompra() {
		Compra compra = new Compra();
		DAOCompra daocompra = new DAOCompra();
		ItensCompra itensCompra = new ItensCompra();
		DAOItensCompra daoitenscompra = new DAOItensCompra();
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
				listarCadastrosCompra();
				System.out.println("Insira a quantidade de acordo com o id de compra: ");
				String qtde = scan.next();
				itensCompra.setQtde(qtde);
				System.out.println("Insira o preço: ");
				String preco = scan.next();
				itensCompra.setPreco(preco);
				
				listarCadastrosCompra();
				System.out.println("Insira o ID da compra: ");
				long id = scan.nextLong();
				compra.setId(id);
				itensCompra.setCompra(compra);
				listarProdutos();
				System.out.println("Insira o ID do Produto: ");
				long idProd = scan.nextLong();
				produto.setId(idProd);
				itensCompra.setProduto(produto);
				daoitenscompra.inserir(itensCompra);
				principal.main(null);
				//colocar para retornar para principal no final de cada um
			}
			if (op ==2) {
				listarCadastrosItensCompra();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id do Item de compra a ser excluido: ");
				itensCompra.setId( scan.nextLong() );
				daoitenscompra.excluir(itensCompra);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastrosItensCompra();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do cadastro a ser alterado");
				itensCompra.setId(scan.nextLong());
				listarCadastrosCompra();
				System.out.println("Insira a quantidade de acordo com o id de compra: ");
				String qtde = scan.next();
				itensCompra.setQtde(qtde);
				System.out.println("Insira o preço: ");
				String preco = scan.next();
				itensCompra.setPreco(preco);
				
				listarCadastrosCompra();
				
				System.out.println("Insira o ID da compra: ");
				long id = scan.nextLong();
				compra.setId(id);
				itensCompra.setCompra(compra);
				listarProdutos();
				System.out.println("Insira o ID do Produto: ");
				long idProd = scan.nextLong();
				produto.setId(idProd);
				itensCompra.setProduto(produto);
				System.out.println("Alterando...");			
		
				daoitenscompra.alterar(itensCompra);
				principal.main(null);
			}
			
			if(op == 4) {
				listarCadastrosItensCompra();
			}

			
			System.out.println("Deseja realmente continuar? (s/n)");
			
			r = scan.nextLine();
			
		}while(r.contentEquals("s"));
	}
	
	public void listarCadastrosItensCompra() {
		DAOItensCompra daoitenscompra = new DAOItensCompra();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODOS Itens de Compra");
		List<ItensCompra> it = daoitenscompra.buscar(); //estudar melhor o percorrer da lista
		
		for(ItensCompra itensCompra : it) {
			System.out.println("Id: "+itensCompra.getId()+" Qtde: "+itensCompra.getQtde()+" preço: "+itensCompra.getPreco()+" id Compra "+itensCompra.getCompra().getId()+" Id Prod: "+itensCompra.getProduto().getId());
		}
	}
	public void listarCadastrosCompra() {
		DAOCompra daocompra = new DAOCompra();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODAS COMPRAS");
		
		List<Compra> com = daocompra.buscar(); //estudar melhor o percorrer da lista
		for(Compra compra : com) {
			System.out.println("Id: "+compra.getId()+" Data da compra: "+compra.getDtCompra());
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
	//Só para fazer a listar todos os cadastros em operações

}
