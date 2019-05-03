package principal;

import java.util.Scanner;

import tela.TelaEstado;
import tela.TelaFornecedor;
import tela.TelaItensCompra;
import tela.TelaItensVenda;
import tela.TelaPessoa;
import tela.TelaProduto;
import tela.TelaVenda;
import tela.TelaCidade;
import tela.TelaCliente;
import tela.TelaCompra;

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
		System.out.println("6 - Gerenciar itens-venda");
		System.out.println("7 - Gerenciar fornecedor");
		System.out.println("8 - Gerenciar compra");
		System.out.println("9 - Gerenciar itens-compra");
		System.out.println("10 - Gerenciar Produtos");
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
		if(op ==6){
			TelaItensVenda itensVenda = new TelaItensVenda();
		}
		if (op==7) {
			TelaFornecedor fornecedor = new TelaFornecedor();
		}
		if (op==8) {
			TelaCompra compra = new TelaCompra();
		}
		if (op==9) {
			TelaItensCompra itensCompra = new TelaItensCompra();
		}
		if (op==10) {
			TelaProduto produto = new TelaProduto();
		}
	}
	
}
