package br.com.iCarly.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.com.iCarly.model.Vendedor;

public class VendedorDAO{
	private PSQLConnection c;
	public VendedorDAO(){
		c = new PSQLConnection();
	}
	public Vendedor get(String email) throws SQLException {
		c.abrirConexao();
		String sql = "SELECT id_vendedor, nome, e_mail, senha, cpf, comissao FROM vendedor WHERE e_mail = ?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setString(1, email);
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			long id_vendedor = rs.getInt("id_vendedor");
			String nome = rs.getString("nome");
			String senha = rs.getString("senha");
			String cpf = rs.getString("cpf");
			double comissao = rs.getDouble("comissao");
			
			Vendedor vendedor = new Vendedor(id_vendedor, cpf, nome, email, senha, comissao);
			c.fecharConexao();
			return vendedor;
			
		}
		c.fecharConexao();
		return null;
	}

	public List<Vendedor> getAll() throws SQLException {
		c.abrirConexao();
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		String sql = "SELECT id_vendedor, nome, e_mail, senha, cpf, comissao FROM vendedor";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			long id_vendedor = rs.getInt("id_vendedor");
			String nome = rs.getString("nome");
			String email = rs.getString("e_mail");
			String senha = rs.getString("senha");
			String cpf = rs.getString("cpf");
			double comissao = rs.getDouble("comissao");
			Vendedor vendedor = new Vendedor(id_vendedor, cpf, nome, email, senha, comissao);
			vendedores.add(vendedor);
		}
		
		c.fecharConexao();
		return vendedores;
	}

	public void insert(Vendedor vendedor) throws SQLException {
		c.abrirConexao();
		String sql = "INSERT INTO vendedor(nome, e_mail, senha, cpf, comissao) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setString(1, vendedor.getNome());
		st.setString(2, vendedor.getEmail());
		st.setString(3, vendedor.getSenha());
		st.setString(4, vendedor.getCpf());
		st.setDouble(5, vendedor.getComissao());
		st.executeUpdate();
		c.fecharConexao();
		
	}

	public void update(Vendedor vendedor) throws SQLException {
		c.abrirConexao();
		String sql = "UPDATE vendedor SET nome=?, e_mail=?, senha=?, cpf=?, comissao=? WHERE id_vendedor=?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setString(1, vendedor.getNome());
		st.setString(2, vendedor.getEmail());
		st.setString(3, vendedor.getSenha());
		st.setString(4, vendedor.getCpf());
		st.setDouble(5, vendedor.getComissao());
		st.setLong(6, vendedor.getId());
		st.executeUpdate();
		c.fecharConexao();
		
	}

	public void delete(long id) throws SQLException {
		c.abrirConexao();
		String sql = "DELETE FROM vendedor WHERE id_vendedor=?";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, id);
		st.executeUpdate();
		c.fecharConexao();
		
	}
	public Vendedor get(long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
