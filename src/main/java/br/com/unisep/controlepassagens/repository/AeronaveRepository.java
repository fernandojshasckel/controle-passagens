package br.com.unisep.controlepassagens.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unisep.controlepassagens.model.Aeronave;
import br.com.unisep.controlepassagens.shared.Repository;
import br.com.unisep.controlepassagens.shared.RepositoryAbstrato;

public class AeronaveRepository extends RepositoryAbstrato implements Repository<Aeronave> {

	@Override
	public Aeronave insert(Aeronave aeronave) {
		
		String sql = "INSERT INTO controlepassagens.aeronave (fabricante, num_max_passageiros, is_operando) VALUES(?, ?, ?)";
		
		try (PreparedStatement preparedStatement = openConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			preparedStatement.setString(1, aeronave.getFabricante());
			preparedStatement.setInt(2, aeronave.getNumMaxPassageiros());
			preparedStatement.setBoolean(3, aeronave.isOperando());
			
			preparedStatement.executeUpdate();
			
			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				
				resultSet.next();
				
				aeronave.setId(resultSet.getInt(1));
				
				return aeronave;
			}
			
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Aeronave update(Aeronave aeronave) {
		
		String sql = "UPDATE controlepassagens.aeronave SET fabricante = ?, num_max_passageiros = ?, is_operando = ? WHERE id = ?";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setString(1, aeronave.getFabricante());
			preparedStatement.setInt(2, aeronave.getNumMaxPassageiros());
			preparedStatement.setBoolean(3, aeronave.isOperando());
			preparedStatement.setInt(4, aeronave.getId());
			
			preparedStatement.executeUpdate();
			
			return aeronave;
			
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		
		String sql = "DELETE from controlepassagens.aeronave WHERE id = ?";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Aeronave findOne(int id) {
		String sql = "SELECT * from controlepassagens.aeronave WHERE id = ?";
		
		try (PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setInt(1, id);
			
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				
				resultSet.next();
			 
				Aeronave aeronave = new Aeronave();
				aeronave.setId(resultSet.getInt("id"));
				aeronave.setFabricante(resultSet.getString("fabricante"));
				aeronave.setNumMaxPassageiros(resultSet.getInt("num_max_passageiros"));
				aeronave.setOperando(resultSet.getBoolean("is_operando"));
				
				return aeronave;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Aeronave> findAll() {
		
		String sql = "SELECT * from controlepassagens.aeronave";
		
		try (PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				
				List<Aeronave> lista = new ArrayList<>();
				
				while (resultSet.next()) {
					
					Aeronave aeronave = new Aeronave();
					aeronave.setId(resultSet.getInt("id"));
					aeronave.setFabricante(resultSet.getString("fabricante"));
					aeronave.setNumMaxPassageiros(resultSet.getInt("num_max_passageiros"));
					aeronave.setOperando(resultSet.getBoolean("is_operando"));
					
					lista.add(aeronave);
				}
				
				return lista;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
