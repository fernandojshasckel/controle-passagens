package br.com.unisep.controlepassagens.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.TesteAbstrato;
import br.com.unisep.controlepassagens.model.Estado;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class EstadoValidatorTest extends TesteAbstrato {
	
	private static EstadoValidator estadoValidator;
	
	@BeforeClass
	public static void iniciarClasse() {

		estadoValidator = new EstadoValidator();
	}
	
	@Test
	public void validateInsertCamposObrigatorios() {
		
		Estado estado = new Estado();
		
		ValidatorResponse resposta = estadoValidator.validateInsert(estado);
		
		Assert.assertTrue(super.verificarMensagem("Nome não pode ser nulo", resposta.getErros()));
		Assert.assertTrue(super.verificarMensagem("Sigla não pode ser nula", resposta.getErros()));
	}
	
	@Test
	public void validateInsertTamanhoMaximoTest() {
		
		Estado estado = new Estado();
		
		estado.setNome(super.mockString(256, true, false));
		estado.setSigla(super.mockString(3, true, false));
		
		ValidatorResponse resposta = estadoValidator.validateInsert(estado);
		
		Assert.assertTrue(super.verificarMensagem("Numero máximo de caracteres é 255", resposta.getErros()));
		Assert.assertTrue(super.verificarMensagem("Numero máximo de caracteres é 2", resposta.getErros()));
	}
}
