	// persist salva
	// merge altera
	// remove apaga
	// find busca
package tela;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DAOPessoa;
import dao.DAOProduto;
import principal.Principal;
import entidade.Produto;

public class TelaProduto {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Principal principal = new Principal();
	
	public TelaProduto() {
		Produto produto = new Produto();
		DAOProduto daoproduto = new DAOProduto();
		
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				System.out.println("Insira o nome do Produto:");
				String nome = scan.next();
				produto.setNome(nome);
				System.out.println("Insira a Qtde de Est: ");
				String qtdeEst = scan.next();
				produto.setQtdeEst(qtdeEst);
				System.out.println("Insira a Qtde Min: ");
				String qtdeMin = scan.next();
				produto.setQtdeMin(qtdeMin);
				System.out.println("Insira o Preço de Venda: ");
				String preco = scan.next();
				produto.setPrecoVenda(preco);
				

				daoproduto.inserir(produto);
				principal.main(null);
				
			}
			if (op ==2) {
				listarProdutos();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id do Produto a ser excluido: ");
				produto.setId( scan.nextLong() );
				daoproduto.excluir(produto);
				principal.main(null);
			}
			if (op ==3) {
				listarProdutos();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do cadastro a ser alterado");
				produto.setId(scan.nextLong());
				System.out.println("Insira o nome do Produto:");
				String nome = scan.next();
				produto.setNome(nome);
				System.out.println("Insira a Qtde de Est: ");
				String qtdeEst = scan.next();
				produto.setQtdeEst(qtdeEst);
				System.out.println("Insira a Qtde Min: ");
				String qtdeMin = scan.next();
				produto.setQtdeMin(qtdeMin);
				System.out.println("Insira o Preço de Venda: ");
				String preco = scan.next();
				produto.setPrecoVenda(preco);
				
				System.out.println("Alterando...");			
		
				daoproduto.alterar(produto);
				principal.main(null);
			}
			
			if(op == 4) {
				listarProdutos();
			}

			
			System.out.println("Deseja realmente continuar? (s/n)");
			
			r = scan.nextLine();
			
		}while(r.contentEquals("s"));
	}
	
//	public void listarCadastrosItensCompra() {
//		DAOItensCompra daoitenscompra = new DAOItensCompra();
//		System.out.println("-----------------------------------------");
//		System.out.println("LISTAR TODOS Itens de Compra");
//		List<ItensCompra> it = daoitenscompra.buscar(); //estudar melhor o percorrer da lista
//		
//		for(ItensCompra itensCompra : it) {
//			System.out.println("Id: "+itensCompra.getId()+" Qtde: "+itensCompra.getQtde()+" preço: "+itensCompra.getPreco());
//		}
//	}
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
