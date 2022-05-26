package br.com.unisep.controlepassagens.validator;

import br.com.unisep.controlepassagens.model.Estado;
import br.com.unisep.controlepassagens.shared.ValidatorAbstrato;
import br.com.unisep.controlepassagens.shared.ValidatorGenerico;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class EstadoValidator extends ValidatorAbstrato<Estado> implements ValidatorGenerico<Estado> {

	@Override
	public ValidatorResponse validateInsert(Estado estado) {
		
		return super.validate(estado);
	}

	@Override
	public ValidatorResponse validateUpdate(Estado estado) {
		
		return super.validate(estado);
	}

	@Override
	public ValidatorResponse validateDelete(int id) {
		return super.validateDelete(id);
	}


}
