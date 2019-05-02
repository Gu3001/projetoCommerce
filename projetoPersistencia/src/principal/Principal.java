package principal;

import java.util.Scanner;

import tela.TelaEstado;
import tela.TelaPessoa;
import tela.TelaVenda;
import tela.TelaCidade;
import tela.TelaCliente;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import entidade.Estado;

public class Principal {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("1 - Gerenciar Estado");
		System.out.println("2 - Gerenciar Cidade");
		System.out.println("3 - Gerenciar pessoa");
		System.out.println("4 - Gerenciar cliente");
		System.out.println("5 - Gerenciar venda");
		int op = scan.nextInt();
		scan.nextLine();
		
		if(op == 1) {
			TelaEstado estado = new TelaEstado();
		}
		if (op == 2) {
			TelaCidade cidade = new TelaCidade();
		}
		if(op ==3){
			TelaPessoa pessoa = new TelaPessoa();
		}
		if(op ==4){
			TelaCliente cliente = new TelaCliente();
		}
		if(op ==5){
			TelaVenda venda = new TelaVenda();
		}
	}
	
}
