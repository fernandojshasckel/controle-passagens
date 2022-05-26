package br.com.unisep.controlepassagens.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.TestUtil;
import br.com.unisep.controlepassagens.model.Cidade;
import br.com.unisep.controlepassagens.model.Estado;

public class CidadeTest extends TestUtil {

	@Test
	@Override
	public void testaPropriedades() {
		Cidade cidade = new Cidade();
		cidade.setNome("Dois Vizinhos");
		
		Estado estado = new Estado();
		estado.setNome("Paraná");
		estado.setSigla("PR");
		
		cidade.setEstado(estado);
		
		Assert.assertEquals("Dois Vizinhos", cidade.getNome());
		Assert.assertNotNull(cidade.getEstado());
		Assert.assertEquals("Paraná", cidade.getEstado().getNome());
		Assert.assertEquals("PR", cidade.getEstado().getSigla());
		
	}

}
