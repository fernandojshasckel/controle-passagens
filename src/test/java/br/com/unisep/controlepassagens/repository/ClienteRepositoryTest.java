package br.com.unisep.controlepassagens.repository;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.unisep.controlepassagens.model.Cliente;
import br.com.unisep.controlepassagens.repository.ClienteRepository;

public class ClienteRepositoryTest {
	
	private static ClienteRepository clienteRepository;	
	
	@BeforeClass
	public static void iniciarClasse() throws SQLException {

		clienteRepository = new ClienteRepository();
	}
	
	@Test
	public void insertTest() {
		
		Cliente cliente = new Cliente();
		
		cliente.setNome("Airton");
		cliente.setCpf("999999999999");
		cliente.setTelefone("9992052352");
		
		cliente = clienteRepository.insert(cliente);
		
		Assert.assertNotNull(cliente.getId());
		
	}
	
	@Test
	public void updateTest() {
		
		Cliente cliente = new Cliente();
		
		cliente.setId(2);
		cliente.setNome("Registro Alterado");
		cliente.setCpf("7777777777777");
		cliente.setTelefone("1111111111111");
		
		cliente = clienteRepository.update(cliente);
		
		Cliente clienteAtualizado = clienteRepository.findOne(cliente.getId());
		
		Assert.assertEquals(cliente.getId(), clienteAtualizado.getId());
		Assert.assertEquals(cliente.getNome(), clienteAtualizado.getNome());
		Assert.assertEquals(cliente.getCpf(), clienteAtualizado.getCpf());
		Assert.assertEquals(cliente.getTelefone(), clienteAtualizado.getTelefone());
	}
	
	@Test
	public void findOneTest() {
		
		Cliente cliente = clienteRepository.findOne(1);
		
		Assert.assertNotNull(cliente);	
	}
	
	@Test
	public void findAllTest() {
		
		List<Cliente> listaCliente = clienteRepository.findAll();
		
		Assert.assertNotEquals(0, listaCliente.size());
	}
	
	@Test
	public void deleteTest() {
		//RETOMRAR NA PROXIMA AULA
		
		List<Cliente> listaCliente = clienteRepository.findAll();
		
		clienteRepository.delete(listaCliente.get(0).getId());
		
		Assert.assertEquals(null, clienteRepository.findOne(listaCliente.get(0).getId()));
	}

}
