package br.com.unisep.controlepassagens.validator;

import br.com.unisep.controlepassagens.model.Cliente;
import br.com.unisep.controlepassagens.shared.ValidatorAbstrato;
import br.com.unisep.controlepassagens.shared.ValidatorGenerico;
import br.com.unisep.controlepassagens.shared.ValidatorResponse;

public class ClienteValidator extends ValidatorAbstrato<Cliente> implements ValidatorGenerico<Cliente> {

	@Override
	public ValidatorResponse validateInsert(Cliente cliente) {

		return super.validate(cliente);
	}

	@Override
	public ValidatorResponse validateUpdate(Cliente cliente) {

		return super.validate(cliente);
	}

	@Override
	public ValidatorResponse validateDelete(int id) {
		return super.validateDelete(id);
	}

}
