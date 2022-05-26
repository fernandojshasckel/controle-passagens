package br.com.unisep.controlepassagens.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.TesteAbstrato;
import br.com.unisep.controlepassagens.model.Aeronave;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class AeronaveValidatorTest extends TesteAbstrato {
	
	private static AeronaveValidator aeronaveValidator;
	
	@BeforeClass
	public static void iniciarClasse() {

		aeronaveValidator = new AeronaveValidator();
	}
	
	@Test
	public void validateCamposObrigatorios() {
		
		Aeronave aeronave = new Aeronave();
		
		ValidatorResponse resposta = aeronaveValidator.validate(aeronave);
		
		Assert.assertTrue(super.verificarMensagem("Fabricante não pode ser nulo", resposta.getErros()));
	}
	
	@Test
	public void validateTamanhoMaximoTest() {
		
		Aeronave aeronave = new Aeronave();
		aeronave.setFabricante(super.mockString(256, true, false));
		
		ValidatorResponse resposta = aeronaveValidator.validate(aeronave);
		
		Assert.assertTrue(super.verificarMensagem("Numero máximo de caracteres é 255", resposta.getErros()));
	}
	
	@Test
	public void validateInsertTest() {
		
		Aeronave aeronave = new Aeronave();
		aeronave.setOperando(false);
		
		ValidatorResponse resposta = aeronaveValidator.validateInsert(aeronave);
		
		Assert.assertTrue(super.verificarMensagem("Não é possível cadastrar uma aeronave que não esteja operando", resposta.getErros()));
	}
	
	@Test
	public void validateNumeroPassageiros() {
		
		Aeronave aeronave = new Aeronave();
		aeronave.setNumMaxPassageiros(49);
		
		ValidatorResponse resposta = aeronaveValidator.validateInsert(aeronave);
		
		Assert.assertTrue(super.verificarMensagem("O número minimo de passageros é 50", resposta.getErros()));
		
		aeronave.setNumMaxPassageiros(1001);
		
		resposta = aeronaveValidator.validateInsert(aeronave);
		
		Assert.assertTrue(super.verificarMensagem("O número máximo de passageiros é 1000", resposta.getErros()));
	}
	

}
