package br.com.unisep.controlepassagens.validator;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.TesteAbstrato;
import br.com.unisep.controlepassagens.model.Cliente;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class ClienteValidatorTest extends TesteAbstrato {
	
	private static ClienteValidator clienteValidator;
	
	@BeforeClass
	public static void iniciarClasse() {

		clienteValidator = new ClienteValidator();
	}
	
	@Test
	public void validateCamposObigatoriosTest() {
		
		Cliente cliente = new Cliente();
		
		ValidatorResponse resposta = clienteValidator.validate(cliente);
		
		Assert.assertTrue(super.verificarMensagem("Nome não pode ser nulo", resposta.getErros()));
		Assert.assertTrue(super.verificarMensagem("Telefone não pode ser nulo", resposta.getErros()));
	}
	
	@Test
	public void validateTamanhoMaximoTest() {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome(super.mockString(256, true, false));
		cliente.setTelefone(super.mockString(21, false, true));
		
		ValidatorResponse resposta = clienteValidator.validate(cliente);
		
		Assert.assertTrue(super.verificarMensagem("Numero máximo de caracteres é 20", resposta.getErros()));
		Assert.assertTrue(super.verificarMensagem("Numero máximo de caracteres é 255", resposta.getErros()));
	}
	
	@Test
	public void validateDeleteTest() {
		
		ValidatorResponse resposta = clienteValidator.validateDelete(0);
		
		Assert.assertTrue(super.verificarMensagem("Identificador não pode ser zero", resposta.getErros()));
		
	}
	

}
