package br.com.unisep.controlepassagens.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.TestUtil;
import br.com.unisep.controlepassagens.model.Cliente;

public class ClienteTest extends TestUtil {
	
	@BeforeClass
	public static void iniciarTestes() {
		System.out.println(">>> public static void iniciarTestes() <<<");
	}
	
	@AfterClass
	public static void encerrarTestes() {
		System.out.println(">>> public static void encerrarTestes() <<<");
	}
	
	@Before
	public void iniciarTeste() {
		System.out.println(">>> public void inciarTeste() <<<");
	}
	
	@After
	public void encerrarTeste() {
		System.out.println(">>> public void encerrarTeste() <<<");
	}

	@Test
	@Override
	public void testaPropriedades() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("pedro");

		Assert.assertEquals("Cliente: pedro", cliente.getNome());
	}
}
