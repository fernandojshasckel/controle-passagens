package br.com.unisep.controlepassagens.repository;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.model.Estado;
import br.com.unisep.controlepassagens.repository.EstadoRepository;

public class EstadoRepositoryTest {
	
	private static EstadoRepository estadoRepository;
	
	@BeforeClass
	public static void iniciarClasse() throws SQLException {
		
		estadoRepository = new EstadoRepository();
	}
	
	@Test
	public void insertTest() {
		
		Estado estado = new Estado();
		estado.setNome("Paraná");
		estado.setSigla("PR");
		
		estado = estadoRepository.insert(estado);
		
		Assert.assertNotNull(estado.getId());
	}
	
	@Test
	public void deleteTest() {

		estadoRepository.delete(1);
	}
	
	@Test
	public void findAllTest() {
		
		List<Estado> lista = estadoRepository.findAll();
		
		lista.forEach(estado -> {
			System.out.println(estado.getNome());
			
		});
		
		Assert.assertNotEquals(0, lista.size());
	}

	@Test
	public void updateTest() {
		Estado estado = new Estado();
		estado.setId(2);
		estado.setNome("Estado alterado");
		estado.setSigla("EA");
		
		estadoRepository.update(estado);
		
		//testar utilizando o findOne
	}
}
