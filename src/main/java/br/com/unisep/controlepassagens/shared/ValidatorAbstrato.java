package br.com.unisep.controlepassagens.shared;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import br.com.unisep.controlepassagens.model.enumerator.EStatus;

public abstract class ValidatorAbstrato<T> {
	
	private Validator getValidator() {
		return Validation.buildDefaultValidatorFactory().getValidator();
	}
	
	public ValidatorResponse validate(T model) {
		
		ValidatorResponse resposta = new ValidatorResponse();
		
		Set<ConstraintViolation<T>> erros = getValidator().validate(model);

		for (ConstraintViolation<T> erro: erros) {
			resposta.addError(erro.getMessage());
		}
		
		if (erros.size() > 0) {
			resposta.setStatus(EStatus.ERRO);
		}
		
		return resposta;
	}
	
	public ValidatorResponse validateDelete(int id) {
		
		ValidatorResponse resposta = new ValidatorResponse();
		
		if (id == 0) {
			resposta.addError("Identificador não pode ser zero");
			resposta.setStatus(EStatus.ERRO);
		}

		return resposta;
	}

}
