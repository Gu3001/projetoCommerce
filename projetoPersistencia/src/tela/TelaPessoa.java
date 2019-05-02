	// persist salva
	// merge altera
	// remove apaga
	// find busca
package tela;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.DAOCidade;
import dao.DAOEstado;
import dao.DAOPessoa;
import entidade.Cidade;
import entidade.Estado;
import entidade.Pessoa;
import principal.Principal;

public class TelaPessoa {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Principal principal = new Principal();
	
	public TelaPessoa() {
		Cidade cidade = new Cidade();
		DAOPessoa daopessoa = new DAOPessoa();
		Pessoa pessoa = new Pessoa();
		DAOCidade daocidade = new DAOCidade();
		
		String r = "s";
		int op = 0;
		do {
			do {
				System.out.println(menu);
				op = scan.nextInt();
				scan.nextLine();
			}while(op < 1 && op > 4);
			
			if(op == 1) {
				System.out.println("Nome da Pessoa: ");
				String nome = scan.nextLine();
				pessoa.setNome(nome);
				System.out.println("telefone: ");
				String telefone = scan.next();
				pessoa.setTelefone(telefone);
				System.out.println("Endereço: ");
				String endereco = scan.next();
				pessoa.setEndereco(endereco);
				System.out.println("email: ");
				String email = scan.next();
				pessoa.setEmail(email);
				
				listarCadastrosCidade();
				
				System.out.println("Insira o ID da cidade: ");
				long id = scan.nextLong();
				cidade.setId(id);
				pessoa.setCidade(cidade);
				daopessoa.inserir(pessoa);
				principal.main(null);
				//colocar para retornar para principal no final de cada um
			}
			if (op ==2) {
				listarCadastrosPessoa();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id da pessoa a ser excluido: ");
				pessoa.setId( scan.nextLong() );
				daopessoa.excluir(pessoa);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastrosPessoa();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do cadastro a ser alterado");
				pessoa.setId(scan.nextLong());
				System.out.println("Novo nome: ");
				String nome = scan.next();
				pessoa.setNome(nome);
				System.out.println("telefone: ");
				String telefone = scan.next();
				pessoa.setTelefone(telefone);
				System.out.println("Endereço: ");
				String endereco = scan.next();
				pessoa.setEndereco(endereco);
				System.out.println("email: ");
				String email = scan.next();
				pessoa.setEmail(email);
				
				listarCadastrosCidade();
				System.out.println("Nova Cidade, id: ");
				long id = scan.nextLong();
				
				System.out.println("Alterando...");			
				cidade.setId(id);
				pessoa.setCidade(cidade);
				daopessoa.alterar(pessoa);
				principal.main(null);
			}
			
			if(op == 4) {
				listarCadastrosPessoa();
			}

			
			System.out.println("Deseja realmente continuar? (s/n)");
			
			r = scan.nextLine();
			
		}while(r.contentEquals("s"));
	}
	public void listarCadastrosPessoa() {
		DAOPessoa daopessoa = new DAOPessoa();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODAS PESSOAS");
		
		List<Pessoa> pes = daopessoa.buscar(); //estudar melhor o percorrer da lista
		
		for(Pessoa pessoa : pes) {
	
			System.out.println("Id: "+pessoa.getId()+" Nome: "+pessoa.getNome()+" cidade: "+pessoa.getCidade().getNome());//acabar de completar
		}
	}
	
	public void listarCadastrosCidade() {
		DAOCidade daocidade = new DAOCidade();
		System.out.println("-----------------------------------------");
		System.out.println("LISTAR TODAS CIDADES");
		
		List<Cidade> cid = daocidade.buscar(); //estudar melhor o percorrer da lista
		
		for(Cidade cidade : cid) {
	
			System.out.println("Id: "+cidade.getId()+" Cidade: "+cidade.getNome()+" Estado: "+cidade.getEstado().getSigla());
		}
	}	
	//Só para fazer a listar todos os cadastros em operações

}
