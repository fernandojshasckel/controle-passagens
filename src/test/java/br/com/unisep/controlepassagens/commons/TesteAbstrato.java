package br.com.unisep.controlepassagens.commons;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.RandomStringUtils;

public abstract class TesteAbstrato {
	
	public boolean verificarMensagem(String msg, List<String> listaErros) {
		
		if (Objects.isNull(listaErros) || listaErros.isEmpty()) {
			return false;
		}
		
		for (String erro: listaErros) {
			
			if (erro.equalsIgnoreCase(msg)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Metodo para criar strins falsas utilizadas nos testes
	 */
	public String mockString(int tamanho, boolean comLetras, boolean comNumeros) {
		
		return RandomStringUtils.random(tamanho, comLetras, comNumeros);
	}
}
