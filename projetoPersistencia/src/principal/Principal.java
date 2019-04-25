package principal;

import java.util.Scanner;

import tela.TelaEstado;

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
		int op = scan.nextInt();
		scan.nextLine();
		
		if(op == 1) {
			TelaEstado t = new TelaEstado();
	}
	}
}
