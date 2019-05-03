	// persist salva
	// merge altera
	// remove apaga
	// find busca
package tela;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import dao.DAOFornecedor;
import dao.DAOPessoa;
import entidade.Fornecedor;
import entidade.Pessoa;
import principal.Principal;

public class TelaFornecedor {
	private Scanner scan = new Scanner(System.in);
	private String menu = " 1 - Inserir \n 2 - Excluir \n 3 - Alterar \n 4 - Consultar \n";
	private Principal principal = new Principal();
	
	public TelaFornecedor() {
		Pessoa pessoa = new Pessoa();
		DAOPessoa daopessoa = new DAOPessoa();
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
				System.out.println("Insira o CNPJ");
				String cnpj = scan.next();
				fornecedor.setCnpj(cnpj);
				
				listarCadastrosPessoa();
				
				System.out.println("Insira o ID da Pessoa: ");
				long id = scan.nextLong();
				pessoa.setId(id);
				fornecedor.setPessoa(pessoa);
				daofornecedor.inserir(fornecedor);
				principal.main(null);
				//colocar para retornar para principal no final de cada um
			}
			if (op ==2) {
				listarCadastrosFornecedor();
				System.out.println("EXCLUIR CADASTRO");
				System.out.println("Insira o id do Cliente a ser excluido: ");
				fornecedor.setId( scan.nextLong() );
				daofornecedor.excluir(fornecedor);
				principal.main(null);
			}
			if (op ==3) {
				listarCadastrosFornecedor();
				System.out.println("ALTERAR CADASTRO");
				System.out.println("Insira o Id do cadastro a ser alterado");
				fornecedor.setId(scan.nextLong());
				System.out.println("Insira o CNPJ");
				String cnpj = scan.next();
				fornecedor.setCnpj(cnpj);
				
				listarCadastrosPessoa();
				
				System.out.println("Insira o ID da Pessoa: ");
				long id = scan.nextLong();
				pessoa.setId(id);
				fornecedor.setPessoa(pessoa);
				System.out.println("Alterando...");			
		
				daofornecedor.alterar(fornecedor);
				principal.main(null);
			}
			
			if(op == 4) {
				listarCadastrosFornecedor();
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
			System.out.println("Id: "+fornecedor.getId()+" CNPJ: "+fornecedor.getCnpj()+" pessoa "+fornecedor.getPessoa().getNome());
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
