package br.com.unisep.controlepassagens.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.TestUtil;
import br.com.unisep.controlepassagens.model.Estado;

public class EstadoTest extends TestUtil {

	@Test
	@Override
	public void testaPropriedades() {
		Estado estado = new Estado();
		estado.setNome("Paraná");
		estado.setSigla("PR");
		
		Assert.assertEquals("Paraná", estado.getNome());
		Assert.assertEquals("PR", estado.getSigla());
		Assert.assertNotEquals("PR", estado.getNome());
		
	}

}
