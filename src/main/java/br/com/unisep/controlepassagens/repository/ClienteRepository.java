package br.com.unisep.controlepassagens.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unisep.controlepassagens.model.Cliente;
import br.com.unisep.controlepassagens.shared.Repository;
import br.com.unisep.controlepassagens.shared.RepositoryAbstrato;

public class ClienteRepository extends RepositoryAbstrato implements Repository<Cliente> {

	@Override
	public Cliente insert(Cliente cliente) {
		
		String sql = "insert into cliente (nome, documento, telefone) values (?, ?, ?)";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getTelefone());
			
			preparedStatement.executeUpdate();
			
			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				
				resultSet.next();
				
				cliente.setId(resultSet.getInt(1));
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
			
		return cliente;
	}

	public Cliente update(Cliente cliente) {
		
		String sql = "update cliente set nome = ?, documento = ?, telefone = ? where id = ?";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCpf());
			preparedStatement.setString(3, cliente.getTelefone());
			preparedStatement.setInt(4, cliente.getId());
			
			preparedStatement.executeUpdate();			
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return cliente;
	}

	@Override
	public void delete(int id) {
		
		String sql = "delete from cliente where id = ?";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();	
			
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Cliente findOne(int id) {
		
		String sql = "select * from cliente where id = ?";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)){
			
			preparedStatement.setInt(1, id);
			
			try(ResultSet resultSet = preparedStatement.executeQuery()) {
				
				resultSet.next();
				
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id"));
				cliente.setNome(resultSet.getString("nome"));
				cliente.setCpf(resultSet.getString("documento"));
				cliente.setTelefone(resultSet.getString("telefone"));
				
				return cliente;
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Cliente> findAll() {
		String sql = "select * from cliente";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)){
			
			try(ResultSet resultSet = preparedStatement.executeQuery()) {
				
				List<Cliente> listaCliente = new ArrayList<Cliente>();
				
				while(resultSet.next()) {
					
					Cliente cliente = new Cliente();
					cliente.setId(resultSet.getInt("id"));
					cliente.setNome(resultSet.getString("nome"));
					cliente.setCpf(resultSet.getString("documento"));
					cliente.setTelefone(resultSet.getString("telefone"));
					
					listaCliente.add(cliente);					
				}				
								
				return listaCliente;
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
