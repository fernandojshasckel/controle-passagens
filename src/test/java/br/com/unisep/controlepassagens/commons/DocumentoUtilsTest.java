package br.com.unisep.controlepassagens.commons;

import org.junit.Assert;
import org.junit.Test;

import br.com.unisep.controlepassagens.commons.DocumentoUtils;


public class DocumentoUtilsTest extends TestUtil {

	@Override
	public void testaPropriedades() {
		// TODO Auto-generated method stub
	}
	
	@Test
	public void removerMascaraTest() {
		Assert.assertEquals("65988640036", DocumentoUtils.removerMascara("659.886.400-36"));
		Assert.assertEquals("88701553000112", DocumentoUtils.removerMascara("88.701.553/0001-12"));
	}
	
	@Test
	public void cpfValidoTest() {
		Assert.assertTrue(DocumentoUtils.isCpfValido("66055738031"));
		Assert.assertFalse(DocumentoUtils.isCpfValido("6605573803"));
		Assert.assertTrue(DocumentoUtils.isCpfValido("11737326086"));
	}
	
	@Test
	public void cnpjValidoTest() {
		Assert.assertTrue(DocumentoUtils.isCnpjValido("46608384000120"));
		Assert.assertFalse(DocumentoUtils.isCnpjValido("4660838400012"));
		Assert.assertTrue(DocumentoUtils.isCnpjValido("10466371000117"));
		
	}

}
