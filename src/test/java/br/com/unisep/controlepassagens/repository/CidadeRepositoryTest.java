package br.com.unisep.controlepassagens.repository;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.model.Cidade;
import br.com.unisep.controlepassagens.model.Estado;
import br.com.unisep.controlepassagens.repository.CidadeRepository;
import br.com.unisep.controlepassagens.repository.EstadoRepository;

public class CidadeRepositoryTest {

	private static CidadeRepository cidadeRepository;
	
	private static EstadoRepository estadoRepository;
	
	@BeforeClass
	public static void iniciarClasse() throws SQLException {

		cidadeRepository = new CidadeRepository();
		estadoRepository = new EstadoRepository();
	}
	
	@Test
	public void insertTest() {
		Cidade cidade = new Cidade();
		cidade.setNome("Dois Vizinhos");
		
		List<Estado> listaDeEstadosCadastrados = estadoRepository.findAll();
		
		cidade.setEstado(listaDeEstadosCadastrados.get(0));
		
		cidade = cidadeRepository.insert(cidade);
		
		Assert.assertNotNull(cidade.getId());
	}
	
	@Test
	public void updateTest() {
		
		Cidade cidade = new Cidade();
		cidade.setId(1);
		cidade.setNome("Pato Branco");
		
		List<Estado> listaDeEstadosCadastrados = estadoRepository.findAll();
		
		cidade.setEstado(listaDeEstadosCadastrados.get(1));
		
		cidade = cidadeRepository.insert(cidade);
		
		Assert.assertEquals("Pato Branco", cidade.getNome());
		
	}
	
	@Test
	public void deleteTest() {

		cidadeRepository.delete(3);
	}
	
	@Test
	public void findOneTest() {
		
		Cidade cidade = cidadeRepository.findOne(7);
		
		Assert.assertNotNull(cidade);
	}
	
	@Test
	public void findAllTest() {

		List<Cidade> cidadeLista = cidadeRepository.findAll();
		
		Assert.assertNotNull(cidadeLista);
		Assert.assertNotEquals(0, cidadeLista.size());	
	}

}
