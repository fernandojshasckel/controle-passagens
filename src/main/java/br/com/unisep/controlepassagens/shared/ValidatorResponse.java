package br.com.unisep.controlepassagens.shared;

import java.util.ArrayList;
import java.util.List;

import br.com.unisep.controlepassagens.model.enumerator.EStatus;

public class ValidatorResponse {
	
	private EStatus status = EStatus.SUCESSO;
	
	List<String> erros = new ArrayList<>();

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErros(List<String> erros) {
		this.erros = erros;
	}
	
	public void addError(String erro) {
		this.erros.add(erro);
	}
}
