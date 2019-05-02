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
import dao.DAOPessoa;
import entidade.Cliente;
import entidade.Estado;
import entidade.Pessoa;
import principal.Principal;

public class TelaCliente {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Principal principal = new Principal();
	
	public TelaCliente() {
		Pessoa pessoa = new Pessoa();
		DAOPessoa daopessoa = new DAOPessoa();
		Cliente cliente = new Cliente();
		DAOCliente daocliente = new DAOCliente();
		
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				System.out.println("Insira o Status, 1 para pessoaFisica, 0 para pessoa Jurídica");
				int status = scan.nextInt();
				cliente.setStatusCliente(status);
				System.out.println("rg: ");
				String rg = scan.next();
				cliente.setRg(rg);
				System.out.println("cpf: ");
				String cpf = scan.next();
				cliente.setCpf(cpf);
				System.out.println("Data de nascimento: ");
				String dtNasc = scan.next();
				cliente.setDtNasc(dtNasc);
				
				listarCadastrosPessoa();
				
				System.out.println("Insira o ID da Pessoa: ");
				long id = scan.nextLong();
				pessoa.setId(id);
				cliente.setPessoa(pessoa);
				daocliente.inserir(cliente);
				principal.main(null);
				//colocar para retornar para principal no final de cada um
			}
			if (op ==2) {
				listarCadastrosCliente();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id do Cliente a ser excluido: ");
				cliente.setId( scan.nextLong() );
				daocliente.excluir(cliente);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastrosCliente();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do cadastro a ser alterado");
				pessoa.setId(scan.nextLong());
				System.out.println("Insira o Status, 1 para pessoaFisica, 0 para pessoa Jurídica");
				int status = scan.nextInt();
				cliente.setStatusCliente(status);
				System.out.println("rg: ");
				String rg = scan.next();
				cliente.setRg(rg);
				System.out.println("cpf: ");
				String cpf = scan.next();
				cliente.setCpf(cpf);
				System.out.println("Data de nascimento: ");
				String dtNasc = scan.next();
				cliente.setDtNasc(dtNasc);
				
				listarCadastrosPessoa();
				System.out.println("Insira o ID da Pessoa: ");
				long id = scan.nextLong();
				pessoa.setId(id);
				cliente.setPessoa(pessoa);
				System.out.println("Alterando...");			
		
				daocliente.alterar(cliente);
				principal.main(null);
			}
			
			if(op == 4) {
				listarCadastrosCliente();
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
			System.out.println("Id: "+cliente.getId()+" Cliente: "+cliente.getStatusCliente()+" RG: "+cliente.getRg()+" CPF: "+cliente.getCpf()+" pessoa "+cliente.getPessoa().getNome());
		}
	}
	public void listarCadastrosPessoa() {
		DAOPessoa daopessoa = new DAOPessoa();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODAS PESSOAS");
		
		List<Pessoa> pes = daopessoa.buscar(); //estudar melhor o percorrer da lista
		for(Pessoa pessoa : pes) {
			System.out.println("Id: "+pessoa.getId()+" Nome: "+pessoa.getNome());//acabar de completar
		}
	}
	//Só para fazer a listar todos os cadastros em operações

}
