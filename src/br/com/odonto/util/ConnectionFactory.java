package br.com.odonto.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private String username = "root";
	private String password = "dbAluno";
	private String url = "jdbc:mysql://localhost:3306/dbOdonto";
	
	public Connection getConnection() throws Exception{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			var con = DriverManager.getConnection(url, username, password);		
			
			return con;			
		} 
		catch(Exception ex)
		{
			throw new Exception(ex.getMessage());
		}
	}
}
