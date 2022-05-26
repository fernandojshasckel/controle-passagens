package br.com.unisep.controlepassagens.commons;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public abstract class DocumentoUtils {
	
	public static boolean isCpfValido(String cpf) {
		CPFValidator validator = new CPFValidator();
		try {
			validator.assertValid(cpf);
			
		} catch(InvalidStateException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isCnpjValido(String cnpj) {
		
		CNPJValidator validator = new CNPJValidator();
		try {
			validator.assertValid(cnpj);
			
		} catch(InvalidStateException e) {
			return false;
		}
		return true;
	}
	
	public static String removerMascara(String documento) {
		
		String docSemMascara;
		
		docSemMascara = documento.replace(".", "");
		docSemMascara = docSemMascara.replace("/", "");
		docSemMascara = docSemMascara.replace("-", "");
		
		return docSemMascara;
	}

}
