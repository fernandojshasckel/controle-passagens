package br.com.unisep.controlepassagens.repository;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.model.Cidade;
import br.com.unisep.controlepassagens.model.Cliente;
import br.com.unisep.controlepassagens.model.Passagem;
import br.com.unisep.controlepassagens.repository.CidadeRepository;
import br.com.unisep.controlepassagens.repository.ClienteRepository;
import br.com.unisep.controlepassagens.repository.PassagemRepository;

public class PassagemRepositoryTest {
	
	private static PassagemRepository passagemRepository;
	private static CidadeRepository cidadeRepository;
	private static ClienteRepository clienteRepository;
	
	@BeforeClass
	public static void iniciarClasse() throws SQLException {

		passagemRepository = new PassagemRepository();
		cidadeRepository = new CidadeRepository();
		clienteRepository = new ClienteRepository();
	}
	
	@Test
	public void insertTeste() {
		
		Cidade origem = cidadeRepository.findAll().get(0);
		Cidade destino = cidadeRepository.findAll().get(0);
		Cliente cliente = clienteRepository.findAll().get(0);
		
		Passagem passagem = new Passagem();
		passagem.setOrigem(origem);
		passagem.setDestino(destino);
		passagem.setCliente(cliente);
		passagem.setNumAssento("04ABC");
		
		passagem = passagemRepository.insert(passagem);
		
		Assert.assertNotNull(passagem.getId());
	}
	
	@Test
	public void updateTest() {
		
		Cidade origem = cidadeRepository.findAll().get(1);
		Cidade destino = cidadeRepository.findAll().get(1);
		Cliente cliente = clienteRepository.findAll().get(1);
		
		List<Passagem> lista = passagemRepository.findAll();
		
		Passagem passagem = lista.get(0);
		passagem.setOrigem(origem);
		passagem.setDestino(destino);
		passagem.setCliente(cliente);
		passagem.setNumAssento("XXXX");
		
		passagem = passagemRepository.update(passagem);
		
		Passagem passagemAtualizada = passagemRepository.findOne(passagem.getId());

		Assert.assertEquals(passagemAtualizada.getOrigem().getId(), origem.getId());
		Assert.assertEquals(passagemAtualizada.getDestino().getId(), destino.getId());
		Assert.assertEquals(passagemAtualizada.getCliente().getId(), cliente.getId());
		Assert.assertEquals(passagemAtualizada.getNumAssento(), passagem.getNumAssento());
	}
	
	@Test
	public void findAllTest() {
		
		List<Passagem> lista = passagemRepository.findAll();
		
		Assert.assertNotNull(lista);
		Assert.assertNotEquals(lista.size(), 0);
		
		Passagem passagem = lista.get(0);
		
		Assert.assertNotNull(passagem.getOrigem());
		Assert.assertNotNull(passagem.getOrigem().getNome());
		
		Assert.assertNotNull(passagem.getDestino());
		Assert.assertNotNull(passagem.getDestino().getNome());
		
		Assert.assertNotNull(passagem.getCliente());
		Assert.assertNotNull(passagem.getCliente().getNome());
	}
	
	@Test
	public void findOneTest() {
		
		int id = passagemRepository.findAll().get(0).getId();
		
		Passagem passagem = passagemRepository.findOne(id);
		
		Assert.assertNotNull(passagem);
	}
	
	@Test
	public void deleteTest() {

		int id = passagemRepository.findAll().get(0).getId();
		
		passagemRepository.delete(id);
		
		try {
			passagemRepository.findOne(id);
		} catch (Exception e) {
			
			Assert.assertEquals("Registro não encontrado", e.getMessage());
		}
	}
	
	@Test(expected = RuntimeException.class)
	public void testandoExption() {
		
		int id = passagemRepository.findAll().get(0).getId();
		
		passagemRepository.delete(id);
		
		passagemRepository.findOne(id);
		
	}
	
	
	

}
