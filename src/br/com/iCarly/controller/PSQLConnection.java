package br.com.iCarly.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PSQLConnection {
	private final String IP = "localhost";
	private final String PORTA = "5432";
	private final String LOGIN = "postgres";
	private final String SENHA = "pepita2020";
	private final String NOME_BD = "iCarly";
	private Connection connection;

	public PSQLConnection() {

	}
	
	public Connection getConnection() throws SQLException{
		return connection;
	}

	// abrir a conexao com BD
	public void abrirConexao() {
		String url = "jdbc:postgresql://" + IP + ":" + PORTA + "/" + NOME_BD;
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(url, LOGIN, SENHA);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// fechar a conexao com BD
	public void fecharConexao() {
		// verificar se esta aberta a conexao
		try {
			if (connection != null & !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
