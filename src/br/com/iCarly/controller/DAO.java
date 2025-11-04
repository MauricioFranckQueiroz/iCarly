package br.com.iCarly.controller;

import java.sql.SQLException;
import java.util.List;

public interface DAO <T>{
	
	T get(long id) throws SQLException;
	List<T> getAll() throws SQLException;
	
	void insert(T t) throws SQLException;
	void update(T t) throws SQLException;
	void delete(long id) throws SQLException;

}
