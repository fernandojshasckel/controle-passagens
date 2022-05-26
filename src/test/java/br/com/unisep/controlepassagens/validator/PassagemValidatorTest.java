package br.com.unisep.controlepassagens.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.TesteAbstrato;
import br.com.unisep.controlepassagens.model.Passagem;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class PassagemValidatorTest extends TesteAbstrato {
	
	private static PassagemValidator passagemValidator;
	
	@BeforeClass
	public static void iniciarClasse() {

		passagemValidator = new PassagemValidator();
	}
	
	@Test
	public void validateInsertCamposObrigatorios() {
		
		Passagem passagem = new Passagem();
		
		ValidatorResponse resposta = passagemValidator.validate(passagem);
		
		Assert.assertTrue(verificarMensagem("Origem não pode ser nulo", resposta.getErros()));
		Assert.assertTrue(verificarMensagem("Destino não pode ser nulo", resposta.getErros()));
		Assert.assertTrue(verificarMensagem("Cliente não pode ser nulo", resposta.getErros()));
		Assert.assertTrue(verificarMensagem("Assento não pode ser nulo", resposta.getErros()));
	}
	
	@Test
	public void validateInsertTamanho() {
		
		Passagem passagem = new Passagem();
		passagem.setNumAssento(mockString(21, true, true));
		
		ValidatorResponse resposta = passagemValidator.validate(passagem);
		
		Assert.assertTrue(verificarMensagem("Numero minimo 5 e numero máximo de caracteres é 20", resposta.getErros()));
		
		passagem.setNumAssento(mockString(3, true, true));
		
		resposta = passagemValidator.validate(passagem);
		
		Assert.assertTrue(verificarMensagem("Numero minimo 5 e numero máximo de caracteres é 20", resposta.getErros()));
		
	}

}
