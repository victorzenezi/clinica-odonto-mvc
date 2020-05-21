package br.com.odondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.odonto.util.ConnectionFactory;

public class ProcedimentoDao {
	
	private Connection con;
	private ConnectionFactory cn = new ConnectionFactory();
	private PreparedStatement preparedStatement;
	private ResultSet result;
	
	public ProcedimentoDao() throws Exception{
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
