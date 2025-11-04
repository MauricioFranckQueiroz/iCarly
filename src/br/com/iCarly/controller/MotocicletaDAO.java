package br.com.iCarly.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.iCarly.model.Motocicleta;

public class MotocicletaDAO{
	PSQLConnection c;
	public MotocicletaDAO(){
		c = new PSQLConnection();
	}
	public Motocicleta get(long id) throws SQLException {
		c.abrirConexao();
		String sql = "SELECT id_motocicleta, placa, modelo, cor, preco, ano, km_rodados FROM motocicleta WHERE id_motocicleta= ?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			long id_motocicleta = rs.getInt("id_motocicleta");
			String placa = rs.getString("placa");
			String modelo = rs.getString("modelo");
			int ano = rs.getInt("ano");
			double kmRodados = rs.getDouble("km_rodados");
			Motocicleta motocicleta = new Motocicleta(id_motocicleta, placa, modelo, ano, kmRodados);
			c.fecharConexao();
//			return motocicleta;
			
		}
		c.fecharConexao();
		return null;
	}

	public List<Motocicleta> getAll() throws SQLException {
		c.abrirConexao();
		List<Motocicleta> motocicletas = new ArrayList<Motocicleta>();
		String sql = "SELECT id_motocicleta, placa, modelo, cor, preco, ano, km_rodados FROM motocicleta";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			long id_motocicleta = rs.getInt("id_motocicleta");
			String placa = rs.getString("placa");
			String modelo = rs.getString("modelo");
			int ano = rs.getInt("ano");
			double kmRodados = rs.getDouble("km_rodados");
			Motocicleta motocicleta = new Motocicleta(id_motocicleta, placa, modelo, ano, kmRodados);
			motocicletas.add(motocicleta);
		}
		
		c.fecharConexao();
		return motocicletas;
	}

	@Override
	public void insert(Motocicleta motocicleta) throws SQLException {
		c.abrirConexao();
		String sql = "INSERT INTO carro(placa,modelo,cor,preco,ano,km_rodados) VALUES(?, ?, ?, ?)";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setString(1, motocicleta.getPlaca());
		st.setString(2, motocicleta.getModelo());
		st.setString(3, motocicleta.getCor());
		st.setDouble(4, motocicleta.getPreco());
		st.setInt(5, motocicleta.getAno());
		st.setDouble(6, motocicleta.getKmRodados());
		st.executeUpdate();
		c.fecharConexao();
		
	}

	@Override
	public void update(Motocicleta motocicleta) throws SQLException {
		c.abrirConexao();
		String sql = "UPDATE cliente SET nome=?, e_mail=?, senha=?, cpf=?, comissao=? WHERE id_cliente=?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setString(1, motocicleta.getPlaca());
		st.setString(2, motocicleta.getModelo());
		st.setString(3, motocicleta.getCor());
		st.setDouble(4, motocicleta.getPreco());
		st.setInt(5, motocicleta.getAno());
		st.setDouble(6, motocicleta.getKmRodados());
		st.setLong(6, motocicleta.getId());
		st.executeUpdate();
		c.fecharConexao();
		
	}

	@Override
	public void delete(long id) throws SQLException {
		c.abrirConexao();
		String sql = "DELETE FROM motocicleta WHERE id_motocicleta=?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		st.executeUpdate();
		c.fecharConexao();
		
	}


}
