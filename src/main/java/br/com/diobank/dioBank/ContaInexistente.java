package br.com.diobank.dioBank;

public class ContaInexistente extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaInexistente(int n) {
		super("A conta de numero "
				+ n
				+ " nao existe");
	}
}
