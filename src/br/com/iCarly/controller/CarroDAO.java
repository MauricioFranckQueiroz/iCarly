package br.com.iCarly.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.iCarly.model.Carro;

public class CarroDAO{
	private PSQLConnection connection;
	public CarroDAO() {
		 connection = new PSQLConnection();
	}
	public Carro get(long id) throws SQLException {
		connection.abrirConexao();
		String sql = "SELECT id_carro, placa, modelo, cor, preco, ano, km_rodados, ar, num_portas FROM carro WHERE id_carro= ?";
		PreparedStatement st = connection.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			long id_carro = rs.getInt("id_cliente");
			String placa = rs.getString("placa");
			String modelo = rs.getString("modelo");
			String cor = rs.getString("cor");
			double preco = rs.getDouble("preco");
			int ano = rs.getInt("ano");
			double kmRodados = rs.getDouble("km_rodados");
			boolean ar = rs.getBoolean("ar");
			int numPortas = rs.getInt("num_portas");
			Carro carro = new Carro(id_carro, placa, modelo, cor, preco, ano, kmRodados, ar, numPortas);
			connection.fecharConexao();
			return carro;
			
		}
		connection.fecharConexao();
		return null;
	}

	public List<Carro> getAll() throws SQLException {
		connection.abrirConexao();
		List<Carro> carros = new ArrayList<Carro>();
		String sql = "SELECT id_carro, placa, modelo, cor, preco, ano, km_rodados, ar, num_portas FROM carro WHERE id_carro= ?";
		PreparedStatement st = connection.getConnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			long id_carro = rs.getInt("id_cliente");
			String placa = rs.getString("placa");
			String modelo = rs.getString("modelo");
			String cor = rs.getString("cor");
			double preco = rs.getDouble("preco");
			int ano = rs.getInt("ano");
			double kmRodados = rs.getDouble("km_rodados");
			boolean ar = rs.getBoolean("ar");
			int numPortas = rs.getInt("num_portas");
			Carro carro = new Carro(id_carro, placa, modelo, cor, preco, ano, kmRodados, ar, numPortas);
			carros.add(carro);
		}
		connection.fecharConexao();
		return null;
	}

	public void insert(Carro carro) throws SQLException {
		connection.abrirConexao();
		String sql = "INSERT INTO carro(placa,modelo,cor,preco,ano,km_rodados,ar,num_portas) VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement st = connection.getConnection().prepareStatement(sql);
		st.setString(1, carro.getPlaca());
		st.setString(2, carro.getModelo());
		st.setString(3, carro.getCor());
		st.setDouble(4, carro.getPreco());
		st.setInt(5, carro.getAno());
		st.setDouble(6, carro.getKmRodados());
		st.setBoolean(7, carro.getAr());
		st.setInt(8, carro.getNumPortas());
		connection.fecharConexao();
		
	}

	public void update(Carro carro) throws SQLException {
		connection.abrirConexao();
		String sql = "UPDATE motocicleta SET preco=? WHERE placa=?";
		PreparedStatement st = connection.getConnection().prepareStatement(sql);

		st.setDouble(1, carro.getPreco());
		st.setString(2, carro.getPlaca());
		
		st.executeUpdate();
		connection.fecharConexao();
		
	}

	public void delete(long id) throws SQLException {
		connection.abrirConexao();
		String sql = "DELETE FROM carro WHERE id_carro=?";
		PreparedStatement st = connection.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		st.executeUpdate();
		connection.fecharConexao();
		
	}

}
