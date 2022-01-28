package br.com.diobank.dioBank;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Assert;

public class TesteBancoDio {

	@Test
	public void testarInclusaoDeContaComum() throws ContaInexistente {
		Banco bancoDio = new Banco();
		Cliente cliente1 = new Cliente("Antonio");
		Conta contaComum1 = new ContaCorrente(cliente1);
		Conta contaComum2 = new ContaCorrente(cliente1);

		bancoDio.incluir(contaComum1);
		bancoDio.incluir(contaComum2);
		assertEquals(0, bancoDio.saldo(contaComum1), 0.001);
		assertEquals(0, bancoDio.saldo(contaComum2), 0.001);

		// Teste inclusao de conta null
		try {
			bancoDio.incluir(null);
			Assert.fail();
		} catch (Exception e) {
			// TODO: handle exception
			Assert.assertTrue(true);
		}

	}

	@Test
	public void testarInclusaoDeContaPoupanca() throws ContaInexistente {
		Banco bancoDio = new Banco();
		Cliente cliente1 = new Cliente("Antonio");
		Conta poupanca1 = new ContaCorrente(cliente1);
		Conta poupanca2 = new ContaCorrente(cliente1);

		bancoDio.incluir(poupanca1);
		bancoDio.incluir(poupanca2);
		assertEquals(0, bancoDio.saldo(poupanca1), 0.001);
		assertEquals(0, bancoDio.saldo(poupanca2), 0.001);

		// Teste inclusao de conta null
		try {
			bancoDio.incluir(null);
			Assert.fail();
		} catch (Exception e) {
			// TODO: handle exception
			Assert.assertTrue(true);
		}
	}

	@Test
	public void testarDepositoDeContaPoupanca() throws ContaInexistente {
		Banco bancoDio = new Banco();
		Cliente cliente1 = new Cliente("Antonio");
		Conta poupanca1 = new ContaCorrente(cliente1);
		Conta poupanca2 = new ContaCorrente(cliente1);

		bancoDio.incluir(poupanca1);
		bancoDio.deposito(poupanca1, 2000);
		bancoDio.deposito(poupanca1, 1000);
		bancoDio.deposito(poupanca1, 1000);
		bancoDio.incluir(poupanca2);
		bancoDio.deposito(poupanca2, 2000);
		bancoDio.deposito(poupanca2, 1000);
		bancoDio.deposito(poupanca2, 1000);
		assertEquals(4000, bancoDio.saldo(poupanca1), 0.001);
		assertEquals(4000, bancoDio.saldo(poupanca2), 0.001);
	}

	@Test
	public void testarDepositoDeContaComum() throws ContaInexistente {
		Banco bancoDio = new Banco();
		Cliente cliente1 = new Cliente("Antonio");
		Conta contaComum1 = new ContaCorrente(cliente1);
		Conta contaComum2 = new ContaCorrente(cliente1);

		bancoDio.incluir(contaComum1);
		bancoDio.deposito(contaComum1, 2000);
		bancoDio.deposito(contaComum1, 1000);
		bancoDio.deposito(contaComum1, 1000);
		bancoDio.incluir(contaComum2);
		bancoDio.deposito(contaComum2, 2000);
		bancoDio.deposito(contaComum2, 1000);
		bancoDio.deposito(contaComum2, 1000);
		assertEquals(4000, bancoDio.saldo(contaComum1), 0.001);
		assertEquals(4000, bancoDio.saldo(contaComum2), 0.001);
	}

	@Test
	public void testarSaqueDeContaPoupanca() throws ContaInexistente, SaldoInsuficiente {
		Banco bancoDio = new Banco();
		Cliente cliente1 = new Cliente("Antonio");
		Conta poupanca1 = new ContaCorrente(cliente1);
		Conta poupanca2 = new ContaCorrente(cliente1);

		bancoDio.incluir(poupanca1);
		bancoDio.deposito(poupanca1, 2000);
		bancoDio.saque(poupanca1, 1000);
		bancoDio.saque(poupanca1, 500);
		bancoDio.incluir(poupanca2);
		bancoDio.deposito(poupanca2, 2000);
		bancoDio.saque(poupanca2, 1000);
		bancoDio.saque(poupanca2, 500);
		assertEquals(500, bancoDio.saldo(poupanca1), 0.001);
		assertEquals(500, bancoDio.saldo(poupanca2), 0.001);

		// Teste saque com valor maior que o disponivel em conta
		try {
			bancoDio.saque(poupanca2, 10000);
			Assert.fail();
		} catch (Exception e) {

			Assert.assertTrue(true);
		}
	}

	@Test
	public void testarSaqueDeContaComum() throws ContaInexistente, SaldoInsuficiente {
		Banco bancoDio = new Banco();
		Cliente cliente1 = new Cliente("Antonio");
		Conta contaComum1 = new ContaCorrente(cliente1);
		Conta contaComum2 = new ContaCorrente(cliente1);

		bancoDio.incluir(contaComum1);
		bancoDio.deposito(contaComum1, 2000);
		bancoDio.saque(contaComum1, 1000);
		bancoDio.saque(contaComum1, 500);
		bancoDio.incluir(contaComum2);
		bancoDio.deposito(contaComum2, 2000);
		bancoDio.saque(contaComum2, 1000);
		bancoDio.saque(contaComum2, 600);
		assertEquals(500, bancoDio.saldo(contaComum1), 0.001);
		assertEquals(400, bancoDio.saldo(contaComum2), 0.001);

		// Teste saque com valor maior que o disponivel em conta
		try {
			bancoDio.saque(contaComum2, 10000);
			Assert.fail();
		} catch (Exception e) {

			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void testarTranferencia() throws ContaInexistente, SaldoInsuficiente {
		Banco bancoDio = new Banco();
		Cliente cliente1 = new Cliente("Antonio");
		Conta poupanca1 = new ContaPoupanca(cliente1);
		Conta contaComum2 = new ContaCorrente(cliente1);

		bancoDio.incluir(poupanca1);
		bancoDio.deposito(poupanca1, 2000);
		
		bancoDio.incluir(contaComum2);
		bancoDio.deposito(contaComum2, 2000);
		
		bancoDio.transferir(poupanca1, contaComum2, 1000);
		
		assertEquals(3000, bancoDio.saldo(contaComum2), 0.001);
		assertEquals(1000, bancoDio.saldo(poupanca1), 0.001);

		// Teste tranferir valor maior que o disponivel em conta
		try {
			bancoDio.saque(contaComum2, 10000);
			Assert.fail();
		} catch (Exception e) {

			Assert.assertTrue(true);
		}
	}

}
