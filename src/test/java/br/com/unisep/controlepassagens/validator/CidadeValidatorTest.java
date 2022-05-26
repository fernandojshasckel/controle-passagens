package br.com.unisep.controlepassagens.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.TesteAbstrato;
import br.com.unisep.controlepassagens.model.Cidade;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class CidadeValidatorTest extends TesteAbstrato {
	
	private static CidadeValidator cidadeValidator;
	
	@BeforeClass
	public static void iniciarClasse() {

		cidadeValidator = new CidadeValidator();
	}
	
	@Test
	public void validateCamposObrigatoriosTest() {
		
		Cidade cidade = new Cidade();
		
		ValidatorResponse resposta = cidadeValidator.validate(cidade);
		
		Assert.assertTrue(super.verificarMensagem("Nome não pode ser nulo", resposta.getErros()));
		Assert.assertTrue(super.verificarMensagem("Estado não pode ser nulo", resposta.getErros()));
	}
	
	@Test
	public void validateTamanhoMaximoTest() {
		
		Cidade cidade = new Cidade();
		
		cidade.setNome(super.mockString(256, true, false));
		
		ValidatorResponse resposta = cidadeValidator.validate(cidade);
		
		Assert.assertTrue(super.verificarMensagem("Numero máximo de caracteres é 255", resposta.getErros()));
	}

}
