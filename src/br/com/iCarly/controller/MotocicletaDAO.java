package br.com.iCarly.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.iCarly.model.Motocicleta;

public class MotocicletaDAO implements DAO<Motocicleta>{
	@Override
	public Motocicleta get(long id) throws SQLException {
		PSQLConnection c = new PSQLConnection();
		c.abrirConexao();
		String sql = "SELECT id_cliente, nome, e_mail, senha, cpf FROM cliente WHERE id_cliente= ?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			long id_motocicleta = rs.getInt("id_motocicleta");
			
			Motocicleta cliente = new Motocicleta(id_motocicleta, );
			c.fecharConexao();
			return cliente;
			
		}
		c.fecharConexao();
		return null;
	}

	@Override
	public List<Carro> getAll() throws SQLException {
		PSQLConnection c = new PSQLConnection();
		c.abrirConexao();
		List<Carro> vendedores = new ArrayList<Carro>();
		String sql = "SELECT id_cliente, nome, e_mail, senha, cpf FROM cliente";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			long id_cliente = rs.getInt("id_cliente");
			String nome = rs.getString("nome");
			String email = rs.getString("e_mail");
			String senha = rs.getString("senha");
			String cpf = rs.getString("cpf");
			Carro cliente = new Carro(id_cliente, cpf, nome, email, senha);
			vendedores.add(cliente);
		}
		
		c.fecharConexao();
		return vendedores;
	}

	@Override
	public void insert(Carro cliente) throws SQLException {
		PSQLConnection c = new PSQLConnection();
		c.abrirConexao();
		String sql = "INSERT INTO cliente(nome, e_mail, senha, cpf) VALUES(?, ?, ?, ?)";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setString(1, cliente.getNome());
		st.setString(2, cliente.getEmail());
		st.setString(3, cliente.getSenha());
		st.setString(4, cliente.getCpf());
		st.executeUpdate();
		c.fecharConexao();
		
	}

	@Override
	public void update(Carro cliente) throws SQLException {
		PSQLConnection c = new PSQLConnection();
		c.abrirConexao();
		String sql = "UPDATE cliente SET nome=?, e_mail=?, senha=?, cpf=?, comissao=? WHERE id_cliente=?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setString(1, cliente.getNome());
		st.setString(2, cliente.getEmail());
		st.setString(3, cliente.getSenha());
		st.setString(4, cliente.getCpf());
		st.setLong(6, cliente.getId());
		st.executeUpdate();
		c.fecharConexao();
		
	}

	@Override
	public void delete(long id) throws SQLException {
		PSQLConnection c = new PSQLConnection();
		c.abrirConexao();
		String sql = "DELETE FROM cliente WHERE id_cliente=?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		st.executeUpdate();
		c.fecharConexao();
		
	}

	@Override
	public void insert(Motocicleta t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Motocicleta t) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
