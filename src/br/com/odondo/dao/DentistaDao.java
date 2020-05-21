package br.com.odondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odonto.util.ConnectionFactory;

public class DentistaDao {
	
	private Connection con;
	private ConnectionFactory cn = new ConnectionFactory();
	private PreparedStatement preparedStatement;
	private ResultSet result;
	
	public DentistaDao() throws Exception{
		try {
			con = cn.getConnection();
		}
		catch (Exception ex){
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public void Post() {
		
	}
}
