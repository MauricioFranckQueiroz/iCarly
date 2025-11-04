package br.com.iCarly.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.iCarly.model.Cliente;

public class ClienteDAO implements DAO<Cliente>{
	private PSQLConnection c;
	public ClienteDAO() {
		 c = new PSQLConnection();
	}

	@Override
	public Cliente get(long id) throws SQLException {
		c.abrirConexao();
		String sql = "SELECT id_cliente, nome, e_mail, senha, cpf FROM cliente WHERE id_cliente= ?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			long id_cliente = rs.getInt("id_cliente");
			String nome = rs.getString("nome");
			String email = rs.getString("e_mail");
			String senha = rs.getString("senha");
			String cpf = rs.getString("cpf");
			
			Cliente cliente = new Cliente(id_cliente, cpf, nome, email, senha);
			c.fecharConexao();
			return cliente;
			
		}
		c.fecharConexao();
		return null;
	}

	@Override
	public List<Cliente> getAll() throws SQLException {
		c.abrirConexao();
		List<Cliente> clientes = new ArrayList<Cliente>();
		String sql = "SELECT id_cliente, nome, e_mail, senha, cpf FROM cliente";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			long id_cliente = rs.getInt("id_cliente");
			String nome = rs.getString("nome");
			String email = rs.getString("e_mail");
			String senha = rs.getString("senha");
			String cpf = rs.getString("cpf");
			Cliente cliente = new Cliente(id_cliente, cpf, nome, email, senha);
			clientes.add(cliente);
		}
		
		c.fecharConexao();
		return clientes;
	}

	@Override
	public void insert(Cliente cliente) throws SQLException {
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
	public void update(Cliente cliente) throws SQLException {
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
		c.abrirConexao();
		String sql = "DELETE FROM cliente WHERE id_cliente=?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		st.executeUpdate();
		c.fecharConexao();
		
	}

}
