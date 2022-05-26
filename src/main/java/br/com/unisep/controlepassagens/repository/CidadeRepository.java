package br.com.unisep.controlepassagens.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.unisep.controlepassagens.model.Cidade;
import br.com.unisep.controlepassagens.model.Estado;
import br.com.unisep.controlepassagens.shared.Repository;
import br.com.unisep.controlepassagens.shared.RepositoryAbstrato;

public class CidadeRepository extends RepositoryAbstrato implements Repository<Cidade> {

	@Override
	public Cidade insert(Cidade cidade) {
		
		String sql = "insert into cidade (nome, id_estado) values (?, ?)";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			preparedStatement.setString(1, cidade.getNome());
			preparedStatement.setInt(2, cidade.getEstado().getId());
			
			preparedStatement.executeUpdate();
			
			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				
				resultSet.next();
				
				cidade.setId(resultSet.getInt(1));
			}

		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		return cidade;
	}

	@Override
	public Cidade update(Cidade cidade) {
		String sql = "update cidade set nome = ?, id_estado = ? where id = ? ";

		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setString(1, cidade.getNome());
			preparedStatement.setInt(2, cidade.getEstado().getId());
			preparedStatement.setInt(3, cidade.getId());
			
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}

		return cidade;
	}

	@Override
	public void delete(int id) {
		String sql = "delete from cidade where id = ?";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setInt(1, id);			
			preparedStatement.execute();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}				
	}

	@Override
	public Cidade findOne(int id) {
		
		String sql = "select \n" + 
				" cidade.id,\n" + 
				" cidade.nome,\n" + 
				" estado.id as id_estado,\n" + 
				" estado.nome as nome_estado\n" + 
				" from controlepassagens.cidade\n" + 
				" inner join controlepassagens.estado\n" + 
				" on cidade.id_estado = estado.id\n" + 
				" where cidade.id = ?;";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			preparedStatement.setInt(1, id);
			
			try(ResultSet resultSet = preparedStatement.executeQuery()) {
				
				resultSet.next();
				
				Cidade cidade = new Cidade();
				cidade.setId(resultSet.getInt("id"));
				cidade.setNome(resultSet.getString("nome"));
				
				Estado estado = new Estado();
				estado.setId(resultSet.getInt("id_estado"));
				estado.setNome(resultSet.getString("nome_estado"));
				
				cidade.setEstado(estado);
				
				return cidade;
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<Cidade> findAll() {
		
		String sql = "select \n" + 
				" cidade.id,\n" + 
				" cidade.nome,\n" + 
				" estado.id as id_estado,\n" + 
				" estado.nome as nome_estado\n" + 
				" from controlepassagens.cidade\n" + 
				" inner join controlepassagens.estado\n" + 
				" on cidade.id_estado = estado.id";
		
		try(PreparedStatement preparedStatement = openConnection().prepareStatement(sql)) {
			
			try(ResultSet resultSet = preparedStatement.executeQuery()) {
				
				List<Cidade> listaCidades = new ArrayList<Cidade>();
				
				while(resultSet.next()) {
					
					Cidade cidade = new Cidade();
					cidade.setId(resultSet.getInt("id"));
					cidade.setNome(resultSet.getString("nome"));
					
					Estado estado = new Estado();
					estado.setId(resultSet.getInt("id_estado"));
					estado.setNome(resultSet.getString("nome_estado"));
					
					cidade.setEstado(estado);
					
					listaCidades.add(cidade);					
				}
				
				return listaCidades;
				
			}
		}catch (SQLException e) {
			
			throw new RuntimeException(e.getMessage());
		}
	}

}
