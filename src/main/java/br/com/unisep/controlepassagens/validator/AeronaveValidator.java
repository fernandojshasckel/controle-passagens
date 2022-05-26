package br.com.unisep.controlepassagens.validator;

import br.com.unisep.controlepassagens.model.Aeronave;
import br.com.unisep.controlepassagens.shared.ValidatorAbstrato;
import br.com.unisep.controlepassagens.shared.ValidatorGenerico;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class AeronaveValidator extends ValidatorAbstrato<Aeronave> implements ValidatorGenerico<Aeronave> {

	@Override
	public ValidatorResponse validateInsert(Aeronave aeronave) {
		
		ValidatorResponse resposta = super.validate(aeronave);
		
		if (aeronave.isOperando() == false) {
			resposta.addError("Não é possível cadastrar uma aeronave que não esteja operando");
		}

		return resposta;
	}

	@Override
	public ValidatorResponse validateUpdate(Aeronave aeronave) {
		
		return super.validate(aeronave);
	}

	@Override
	public ValidatorResponse validateDelete(int id) {
		return super.validateDelete(id);
	}

}
