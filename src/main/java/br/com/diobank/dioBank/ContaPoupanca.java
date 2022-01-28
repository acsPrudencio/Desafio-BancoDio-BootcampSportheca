package br.com.diobank.dioBank;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupanca ===");
		super.imprimirInfosComuns();
	}
	
	public void renderJuros(double taxa) {
		extrato += "Rendimento Juros R$ "+ getSaldo() * taxa +" \n";
		depositar(getSaldo() * taxa);
	}
}
