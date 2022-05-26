package br.com.unisep.controlepassagens.validator;

import br.com.unisep.controlepassagens.model.Cidade;
import br.com.unisep.controlepassagens.shared.ValidatorAbstrato;
import br.com.unisep.controlepassagens.shared.ValidatorGenerico;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class CidadeValidator extends ValidatorAbstrato<Cidade> implements ValidatorGenerico<Cidade> {

	@Override
	public ValidatorResponse validateInsert(Cidade cidade) {

		return super.validate(cidade);
	}

	@Override
	public ValidatorResponse validateUpdate(Cidade cidade) {

		return super.validate(cidade);
	}

	@Override
	public ValidatorResponse validateDelete(int id) {
		return super.validateDelete(id);
	}

}
