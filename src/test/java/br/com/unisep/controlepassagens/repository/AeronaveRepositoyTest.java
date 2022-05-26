package br.com.unisep.controlepassagens.repository;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.model.Aeronave;
import br.com.unisep.controlepassagens.repository.AeronaveRepository;

public class AeronaveRepositoyTest {
	
	private static AeronaveRepository aeronaveRepository;
	
	@BeforeClass
	public static void iniciarClasse() throws SQLException {

		aeronaveRepository = new AeronaveRepository();
	}
	
	@Test
	public void insertTest() {
		
		Aeronave aeronave = new Aeronave();
		aeronave.setFabricante("Embraer");
		aeronave.setNumMaxPassageiros(102);
		aeronave.setOperando(true);
		
		aeronave = aeronaveRepository.insert(aeronave);
		
		Assert.assertNotNull(aeronave.getId());
	}
	
	@Test
	public void fndAllTest() {
		
		List<Aeronave> lista = aeronaveRepository.findAll();
		
		Assert.assertNotNull(lista);
		Assert.assertNotEquals(lista.size(), 0);
	}
	
	@Test
	public void findOneTest() {
		
		int id = aeronaveRepository.findAll().get(0).getId();
		
		Aeronave aeronave = aeronaveRepository.findOne(id);
		
		Assert.assertNotNull(aeronave);
	}
	
	@Test
	public void updateTest() {
		
		Aeronave aeronave = aeronaveRepository.findAll().get(0);
		aeronave.setFabricante("Unisep");
		aeronave.setNumMaxPassageiros(1000);
		aeronave.setOperando(false);
		
		aeronave = aeronaveRepository.update(aeronave);
		
		Aeronave aeronaveAtualizada = aeronaveRepository.findOne(aeronave.getId());
		
		Assert.assertEquals(aeronave.getFabricante(), aeronaveAtualizada.getFabricante());
		Assert.assertEquals(aeronave.getNumMaxPassageiros(), aeronaveAtualizada.getNumMaxPassageiros());
		Assert.assertEquals(aeronave.isOperando(), aeronaveAtualizada.isOperando());
	}
	
	@Test(expected = RuntimeException.class)
	public void deleteTest() {
		
		int id = aeronaveRepository.findAll().get(0).getId();
		
		aeronaveRepository.delete(id);
		
		aeronaveRepository.findOne(id);
	}
	
	@Test
	public void deleteComTryTest() {
		
		int id = aeronaveRepository.findAll().get(0).getId();
		
		aeronaveRepository.delete(id);
		
		try {
			aeronaveRepository.findOne(id);
		}catch (Exception e) {
			Assert.assertEquals("Illegal operation on empty result set.", e.getMessage());
		}
	}
}
