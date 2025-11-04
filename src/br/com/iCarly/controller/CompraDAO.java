package br.com.iCarly.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.iCarly.model.Compra;

public class CompraDAO{
	private PSQLConnection c;
	public CompraDAO() {
		c = new PSQLConnection();
	}
	public Compra get(long id) throws SQLException {

		return null;
	}

	public List<Compra> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Compra compra) throws SQLException {
		c.abrirConexao();
		String sql = "INSERT INTO compra(id_veiculo,id_vendedor,id_cliente,data_compra) VALUES(?, ?, ?, ?);";
		
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, compra.getVeiculo().getId());
		st.setLong(2, compra.getVendedor().getId());
		st.setLong(3, compra.getCliente().getId());
		st.setObject(4, compra.getData());
		c.fecharConexao();
		
	}

	public void update(Compra t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void delete(long idVeiculo) throws SQLException {
		c.abrirConexao();
		String sql = "DELETE FROM compra WHERE id_veiculo=?;";
		PreparedStatement st = c.getConnection().prepareStatement(sql);
		st.setLong(1, idVeiculo);
		c.fecharConexao();
		
	}

}
