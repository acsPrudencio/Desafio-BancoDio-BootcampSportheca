package br.com.diobank.dioBank;

public class Main {

	public static void main(String[] args) throws ContaInexistente, NaoEhPoupanca, SaldoInsuficiente {
		Cliente venilton = new Cliente("Venilton");
		Cliente Jose = new Cliente("Jose");
		
		Conta cc1 = new ContaCorrente(venilton);
		Conta poupanca1 = new ContaPoupanca(Jose);
		Conta poupanca2 = new ContaPoupanca(Jose);

		
		cc1.depositar(100);
		poupanca1.depositar(100);
		
		cc1.sacar(1);
		poupanca1.sacar(1);
		
		Banco b1 = new Banco();
		
		b1.incluir(cc1);
		b1.incluir(poupanca1);
		b1.incluir(poupanca2);
		b1.deposito(poupanca2, 2000);
		b1.saque(poupanca2, 200);
		
		b1.extrato(cc1);
		b1.saque(cc1, 50);
		b1.extrato(cc1);
		b1.extrato(poupanca2);
		
		
	}

}
