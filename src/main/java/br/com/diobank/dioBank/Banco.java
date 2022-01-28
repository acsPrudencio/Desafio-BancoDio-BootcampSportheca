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

	public void incluir(Conta conta) throws ContaInexistente{
		if (conta == null) {
			throw new ContaInexistente();
		} else {
			contas.add(conta);
		}
	}

	public double saldo(Conta conta) throws ContaInexistente {
		Conta c = null;
		c = pesquisarConta(conta);
		return c.getSaldo();
	}

	public void saque(Conta conta, double value) throws ContaInexistente, SaldoInsuficiente {
		Conta c = null;
		c = pesquisarConta(conta);
		c.sacar(value);

	}

	public void deposito(Conta conta, double value) throws ContaInexistente {

		Conta c = null;
		c = pesquisarConta(conta);
		c.depositar(value);

	}

	public Conta pesquisarConta(Conta conta) throws ContaInexistente {
		for (Conta c : contas) {
			if (c.getNumero() == conta.getNumero()) {
				return c;
			}
		}
		throw new ContaInexistente(conta.getNumero());
	}

	public void rendeJuros(Conta conta, double t) throws ContaInexistente, NaoEhPoupanca {
		Conta c = null;
		c = pesquisarConta(conta);

		try {
			((ContaPoupanca) c).renderJuros(t);
		} catch (Exception e) {
			throw new NaoEhPoupanca(conta.getNumero());
		}
	}

	public void extrato(Conta n) throws ContaInexistente {
		Conta c = pesquisarConta(n);
		c.imprimirInfosComuns();
	}

	public void transferir(Conta contaOrigem, Conta contaDestino, double valor)
			throws ContaInexistente, SaldoInsuficiente {
		Conta c1, c2 = null;

		c1 = pesquisarConta(contaOrigem);
		c1.sacar(valor);
		c2 = pesquisarConta(contaDestino);
		c2.depositar(valor);

	}
}
