package br.com.diobank.dioBank;

public class SaldoInsuficiente extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsuficiente(int n, double s) {
		super("A conta de número " + n + 
				" não possui saldo para a operação. "
				+ "Saldo atual: " + s);
	}
}
