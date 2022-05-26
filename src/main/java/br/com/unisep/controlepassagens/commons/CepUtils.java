package br.com.unisep.controlepassagens.commons;

public abstract class CepUtils {
	
	private static final int NUMERO_DIGITOS = 8;
	
	public static boolean isCepValido(String cep) {
		
		if (cep.contains("-")) {
			return false;
		}
		
		if (cep.length() != NUMERO_DIGITOS) {
			return false;
		}
		
		if (!cep.matches("[0-9]{8}")) {
			return false;
		}
		
		return true;
	}
	
	public static String removerMascara(String cep) {
				
		return cep.replace("-", "");
	}
}
