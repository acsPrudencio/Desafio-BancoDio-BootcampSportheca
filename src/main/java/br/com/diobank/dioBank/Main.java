package br.com.diobank.dioBank;

public class Main {

	public static void main(String[] args) throws ContaInexistente, NaoEhPoupanca, SaldoInsuficiente {
		Cliente venilton = new Cliente("Venilton");
		Cliente Jose = new Cliente("Jose");
		
		Conta cc1 = new ContaCorrente(venilton);
		Conta poupanca2 = new ContaPoupanca(Jose);

		
		cc1.depositar(100);
		poupanca2.depositar(100);
		
		cc1.sacar(1);
		poupanca2.sacar(1);
		
		Banco b1 = new Banco();
		
		b1.incluir(cc1);
		b1.incluir(poupanca2);
		
		b1.extrato(1);
		b1.debito(1, 2);
		b1.extrato(1);
		
		
	}

}
