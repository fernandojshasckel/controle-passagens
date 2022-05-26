package br.com.unisep.controlepassagens.validator;

import br.com.unisep.controlepassagens.model.Passagem;
import br.com.unisep.controlepassagens.shared.ValidatorAbstrato;
import br.com.unisep.controlepassagens.shared.ValidatorGenerico;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class PassagemValidator extends ValidatorAbstrato<Passagem> implements ValidatorGenerico<Passagem> {

	@Override
	public ValidatorResponse validateInsert(Passagem entity) {
		return super.validate(entity);
	}

	@Override
	public ValidatorResponse validateUpdate(Passagem entity) {
		return super.validate(entity);
	}

	@Override
	public ValidatorResponse validateDelete(int id) {
		return super.validateDelete(id);
	}

}
