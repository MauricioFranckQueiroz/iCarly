package br.com.iCarly.view;

import java.sql.SQLException;

import br.com.iCarly.controller.VendedorDAO;
import br.com.iCarly.model.Vendedor;
public class Main {

	public static void main(String[] args) throws SQLException {
		VendedorDAO vendedorDAO = new VendedorDAO();
		vendedorDAO.delete(4);
		for(int i = 0;i< vendedorDAO.getAll().size();i++) {
			System.out.println(vendedorDAO.getAll().get(i).getNome());
		}
		System.out.println(vendedorDAO.getAll().size());
	}

}
