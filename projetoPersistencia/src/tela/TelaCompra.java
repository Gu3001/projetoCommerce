	// persist salva
	// merge altera
	// remove apaga
	// find busca
package tela;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompra;
import dao.DAOFornecedor;
import dao.DAOPessoa;
import entidade.Compra;
import entidade.Fornecedor;
import principal.Principal;

public class TelaCompra {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Principal principal = new Principal();
	
	public TelaCompra() {
		Compra compra = new Compra();
		DAOCompra daocompra = new DAOCompra();
		Fornecedor fornecedor = new Fornecedor();
		DAOFornecedor daofornecedor = new DAOFornecedor();
		
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				listarCadastrosFornecedor();
				System.out.println("Insira a Data da Compra de acordo com o id: ");
				String dtCompra = scan.next();
				compra.setDtCompra(dtCompra);
				
				listarCadastrosFornecedor();
				
				System.out.println("Insira o ID do fornecedor: ");
				long id = scan.nextLong();
				fornecedor.setId(id);
				compra.setFornecedor(fornecedor);
				daocompra.inserir(compra);
				principal.main(null);
				//colocar para retornar para principal no final de cada um
			}
			if (op ==2) {
				listarCadastrosCompra();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id da compra a ser excluido: ");
				compra.setId( scan.nextLong() );
				daocompra.excluir(compra);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastrosCompra();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do cadastro a ser alterado");
				compra.setId(scan.nextLong());
				listarCadastrosFornecedor();
				System.out.println("Insira a Data da Compra de acordo com o id: ");
				String dtCompra = scan.next();
				compra.setDtCompra(dtCompra);
				
				listarCadastrosFornecedor();
				
				System.out.println("Insira o ID do fornecedor: ");
				long id = scan.nextLong();
				fornecedor.setId(id);
				compra.setFornecedor(fornecedor);
				System.out.println("Alterando...");			
		
				daocompra.alterar(compra);
				principal.main(null);
			}
			
			if(op == 4) {
				listarCadastrosCompra();
			}

			
			System.out.println("Deseja realmente continuar? (s/n)");
			
			r = scan.nextLine();
			
		}while(r.contentEquals("s"));
	}
	
	public void listarCadastrosFornecedor() {
		DAOFornecedor daofornecedor = new DAOFornecedor();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODOS FORNECEDORES");
		List<Fornecedor> forn = daofornecedor.buscar(); //estudar melhor o percorrer da lista
		
		for(Fornecedor fornecedor : forn) {
			System.out.println("Id: "+fornecedor.getId()+" CNPJ: "+fornecedor.getCnpj());
		}
	}
	public void listarCadastrosCompra() {
		DAOCompra daocompra = new DAOCompra();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODAS COMPRAS");
		
		List<Compra> com = daocompra.buscar(); //estudar melhor o percorrer da lista
		for(Compra compra : com) {
			System.out.println("Id: "+compra.getId()+" Data da compra: "+compra.getDtCompra()+" id fornecedor: "+compra.getFornecedor().getId());
		}
	}
	//Só para fazer a listar todos os cadastros em operações

}
