package br.com.unisep.controlepassagens.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RepositoryAbstrato {
	
	private Connection connection;
	
	public RepositoryAbstrato() {
		this.connectar();
	}	
	
	public Connection openConnection() {
		return connection;
	}
	
	private void connectar() {
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/controlepassagens?useTimezone=true&serverTimezone=UTC",
					"root", "12345678");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
