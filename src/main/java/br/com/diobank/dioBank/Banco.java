package br.com.diobank.dioBank;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banco {

	private String nome;
	private List<Conta> contas = new ArrayList<Conta>();

	public void incluir(Conta c) {
		contas.add(c);
	}
	
	public double saldo(int conta) throws ContaInexistente {
		Conta c = null;
		c = pesquisarConta(conta);
		return c.getSaldo();
	}

	public void debito(int conta, double value) throws ContaInexistente, SaldoInsuficiente {
		Conta c = null;
		c = pesquisarConta(conta);
		c.sacar(value);

	}

	public void credito(int n, double value) throws ContaInexistente {
		
		Conta c = null;
		c = pesquisarConta(n);
		c.depositar(value);


	}

	public Conta pesquisarConta(int num) throws ContaInexistente {
		for (Conta conta : contas) {
			if (conta.getNumero() == num) {
				return conta;
			}
		}
		throw new ContaInexistente(num);
	}

	public void rendeJuros(int n, double t) throws ContaInexistente, NaoEhPoupanca {
		Conta c = null;
		c = pesquisarConta(n);
		
		try {
			((ContaPoupanca) c).renderJuros(t);
		} catch (Exception e) {
			throw new NaoEhPoupanca(n);
		}
	}

	public void extrato(int n) throws ContaInexistente {
		Conta c = pesquisarConta(n);
		c.imprimirInfosComuns();
	}
	

	public void transferir(int contaOrigem, int contaDestino, double valor) throws ContaInexistente, SaldoInsuficiente {
			Conta c1, c2 = null;
			
			c1 = pesquisarConta(contaOrigem);
			c1.sacar(valor);
			c2 = pesquisarConta(contaDestino);
			c2.depositar(valor);
		
	}
}
