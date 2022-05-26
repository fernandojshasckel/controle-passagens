package br.com.unisep.controlepassagens.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unisep.controlepassagens.model.Cidade;
import br.com.unisep.controlepassagens.model.Cliente;
import br.com.unisep.controlepassagens.model.Passagem;
import br.com.unisep.controlepassagens.shared.Repository;
import br.com.unisep.controlepassagens.shared.RepositoryAbstrato;

public class PassagemRepository extends RepositoryAbstrato implements Repository<Passagem> {

	@Override
	public Passagem insert(Passagem passagem) {
		
		String sql = "INSERT INTO controlepassagens.passagem (id_origem, id_destino, id_cliente, num_assento) VALUES(?, ?, ?, ?)";
		
		try (PreparedStatement preparedStatement = openConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			preparedStatement.setInt(1, passagem.getOrigem().getId());
			preparedStatement.setInt(2, passagem.getDestino().getId());
			preparedStatement.setInt(3, passagem.getCliente().getId());
			preparedStatement.setString(4, passagem.getNumAssento());
			
			preparedStatement.executeUpdate();
			
			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				
				resultSet.next();
				
				passagem.setId(resultSet.getInt(1));
				
				return passagem;
			} 
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Passagem update(Passagem passagem) {
	
		String sql = "UPDATE controlepassagens.passagem SET id_origem = ?, id_destino = ?, id_cliente = ?, num_assento = ? WHERE id = ?";
		
		try (PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setInt(1, passagem.getOrigem().getId());
			preparedStatement.setInt(2, passagem.getDestino().getId());
			preparedStatement.setInt(3, passagem.getCliente().getId());
			preparedStatement.setString(4, passagem.getNumAssento());
			preparedStatement.setInt(5, passagem.getId());
			
			preparedStatement.executeUpdate();
			
			return passagem;
			
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		
		String sql = "DELETE FROM controlepassagens.passagem WHERE id = ?";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Passagem findOne(int id) {
		
		String sql = "SELECT "
				+ "	   passagem.id, "
				+ "    passagem.num_assento, "
				+ "    origem.id as id_origem, "
				+ "    origem.nome as nome_origem, "
				+ "    destino.id as id_destino, "
				+ "    destino.nome as nome_destino, "
				+ "    cliente.id as id_cliente, "
				+ "    cliente.nome as nome_cliente "
				+ "FROM controlepassagens.passagem "
				+ "INNER JOIN controlepassagens.cidade origem ON origem.id = passagem.id_origem "
				+ "INNER JOIN controlepassagens.cidade destino ON destino.id = passagem.id_destino "
				+ "INNER JOIN controlepassagens.cliente cliente ON cliente.id = passagem.id_cliente "
				+ "WHERE passagem.id = ?";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setInt(1, id);
			
			try(ResultSet resultSet = preparedStatement.executeQuery()) {
				
				resultSet.next();
				
				Passagem passagem = new Passagem();
				
				passagem.setId(resultSet.getInt("id"));
				passagem.setNumAssento(resultSet.getString("num_assento"));
				
				Cidade origem = new Cidade();
				origem.setId(resultSet.getInt("id_origem"));
				origem.setNome(resultSet.getString("nome_origem"));
				
				Cidade destino = new Cidade();
				destino.setId(resultSet.getInt("id_destino"));
				destino.setNome(resultSet.getString("nome_destino"));
				
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getInt("id_cliente"));
				cliente.setNome(resultSet.getString("nome_cliente"));
				
				passagem.setOrigem(origem);
				passagem.setDestino(destino);
				passagem.setCliente(cliente);
				
				return passagem;
	
			}
		}catch (SQLException e) {
			throw new RuntimeException("Registro não encontrado");
		}
	}

	@Override
	public List<Passagem> findAll() {
		
		String sql = "SELECT "
				+ "	   passagem.id, "
				+ "    passagem.num_assento, "
				+ "    origem.id as id_origem, "
				+ "    origem.nome as nome_origem, "
				+ "    destino.id as id_destino, "
				+ "    destino.nome as nome_destino, "
				+ "    cliente.id as id_cliente, "
				+ "    cliente.nome as nome_cliente "
				+ "FROM controlepassagens.passagem "
				+ "INNER JOIN controlepassagens.cidade origem ON origem.id = passagem.id_origem "
				+ "INNER JOIN controlepassagens.cidade destino ON destino.id = passagem.id_destino "
				+ "INNER JOIN controlepassagens.cliente cliente ON cliente.id = passagem.id_cliente ";
		
		try (PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			try(ResultSet resultSet = preparedStatement.executeQuery()) {
				
				List<Passagem> lista = new ArrayList<>();
				
				while(resultSet.next()) {
					
					Passagem passagem = new Passagem();
					
					passagem.setId(resultSet.getInt("id"));
					passagem.setNumAssento(resultSet.getString("num_assento"));
					
					Cidade origem = new Cidade();
					origem.setId(resultSet.getInt("id_origem"));
					origem.setNome(resultSet.getString("nome_origem"));
					
					Cidade destino = new Cidade();
					destino.setId(resultSet.getInt("id_destino"));
					destino.setNome(resultSet.getString("nome_destino"));
					
					Cliente cliente = new Cliente();
					cliente.setId(resultSet.getInt("id_cliente"));
					cliente.setNome(resultSet.getString("nome_cliente"));
					
					passagem.setOrigem(origem);
					passagem.setDestino(destino);
					passagem.setCliente(cliente);
					
					lista.add(passagem);
				}
				
				return lista;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
