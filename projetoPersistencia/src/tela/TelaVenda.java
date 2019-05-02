	// persist salva
	// merge altera
	// remove apaga
	// find busca
package tela;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DAOCidade;
import dao.DAOCliente;
import dao.DAOVenda;
import entidade.Cliente;
import entidade.Venda;
import principal.Principal;

public class TelaVenda {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Principal principal = new Principal();
	
	public TelaVenda() {
		Cliente cliente = new Cliente();
		DAOCliente daocliente = new DAOCliente();
		Venda venda = new Venda();
		DAOVenda daovenda = new DAOVenda();
		
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				listarCadastrosCliente();
				System.out.println("Insira a data da Venda de acordo com o Cliente: ");
				String dtVenda = scan.next();
				venda.setDtVenda(dtVenda);
				
				listarCadastrosCliente();
				System.out.println("Insira o ID da Venda: ");
				long id = scan.nextLong();
				cliente.setId(id);
				venda.setCliente(cliente);
				daovenda.inserir(venda);
				principal.main(null);
				//colocar para retornar para principal no final de cada um
			}
			if (op ==2) {
				listarCadastrosVenda();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id da venda a ser excluida: ");
				venda.setId( scan.nextLong() );
				daovenda.excluir(venda);
	
			}
			if (op ==3) { //arrumar
				listarCadastrosVenda();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id da venda a ser alterada: ");
				long idVenda = scan.nextLong();
				venda.setId(idVenda);
				listarCadastrosCliente();
				System.out.println("Insira a data da Venda de acordo com o Cliente: ");
				String dtVenda = scan.next();
				venda.setDtVenda(dtVenda);
				
				listarCadastrosCliente();
				System.out.println("Insira o ID do Cliente: ");
				long id = scan.nextLong();
				cliente.setId(id);
				venda.setCliente(cliente);
				
				System.out.println("Alterando...");			
		
				daovenda.alterar(venda);
			}
			
			if(op == 4) {
				listarCadastrosVenda();
			}

			
			System.out.println("Deseja realmente continuar? (s/n)");
			
			r = scan.nextLine();
			
		}while(r.contentEquals("s"));
	}
	
	public void listarCadastrosCliente() {
		DAOCliente daocliente = new DAOCliente();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODOS Clientes");
		List<Cliente> cli = daocliente.buscar(); //estudar melhor o percorrer da lista
		
		for(Cliente cliente : cli) {
			System.out.println("Id: "+cliente.getId()+" Cliente: "+cliente.getStatusCliente()+" RG: "+cliente.getRg()+" CPF: "+cliente.getCpf());
		}
	}
	public void listarCadastrosVenda() {
		DAOVenda daovenda = new DAOVenda();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODAS VENDAS");
		
		List<Venda> ven = daovenda.buscar(); //estudar melhor o percorrer da lista
		for(Venda venda : ven) {
			System.out.println("Id: "+venda.getId()+" Nome: "+venda.getDtVenda()+" Cliente: "+venda.getCliente().getId());//acabar de completar
		}
	}
	//Só para fazer a listar todos os cadastros em operações

}
