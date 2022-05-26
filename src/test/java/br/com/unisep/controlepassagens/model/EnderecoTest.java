package br.com.unisep.controlepassagens.model;

import org.junit.Assert;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.CepUtils;
import br.com.unisep.controlepassagens.commons.TestUtil;
import br.com.unisep.controlepassagens.model.Cidade;
import br.com.unisep.controlepassagens.model.Endereco;
import br.com.unisep.controlepassagens.model.TipoEndereco;

public class EnderecoTest extends TestUtil {

	@Test
	@Override
	public void testaPropriedades() {
		
		Endereco endereco = new Endereco();
		endereco.setBairro("Centro Norte");
		endereco.setCep("85660000");
		endereco.setComplemento("Apto 201");
		endereco.setNumero("188");
		endereco.setLogradouro("Rua José cleto");
		
		Cidade cidade = new Cidade();
		cidade.setNome("Dois Vizinhos");
		
		Assert.assertEquals(TipoEndereco.RESIDENCIAL, endereco.getTipoEndereco());
		endereco.setTipoEndereco(TipoEndereco.COMERCIAL);
		Assert.assertEquals(TipoEndereco.COMERCIAL, endereco.getTipoEndereco());
		
		Assert.assertEquals("Centro Norte", endereco.getBairro());
		Assert.assertEquals("85660000", endereco.getCep());
		Assert.assertEquals("Apto 201", endereco.getComplemento());
		Assert.assertEquals("188", endereco.getNumero());
		Assert.assertEquals("Rua José cleto", endereco.getLogradouro());
		
		Assert.assertTrue(CepUtils.isCepValido(endereco.getCep()));
		
		endereco.setCep("85660-000");
		endereco.setCep(CepUtils.removerMascara(endereco.getCep()));
		
		Assert.assertEquals("85660000", endereco.getCep());
	}

}
