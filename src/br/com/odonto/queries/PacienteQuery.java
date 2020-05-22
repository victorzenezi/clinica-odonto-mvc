package br.com.odonto.queries;

public class PacienteQuery {
	
	public final String Post = "INSERT INTO dbOdonto.PACIENTE\r\n" + 
			"(NOME, DATA_NASCIMENTO, EMAIL, ENDERECO, CELULAR, SEXO)\r\n" + 
			"VALUES(?, ?, ?, ?, ?, ?)";
	
	public final String GetAll = "SELECT NOME, DATA_NASCIMENTO as DATANASCIMENTO, EMAIL, ENDERECO, CELULAR, SEXO FROM dbOdonto.PACIENTE";
	
	public final String GetporNome = "SELECT ID, NOME, DATA_NASCIMENTO as DATANASCIMENTO, EMAIL, ENDERECO, CELULAR, SEXO FROM dbOdonto.PACIENTE WHERE NOME = ?";
	
	public final String Delete = "DELETE FROM PACIENTE WHERE NOME = ?";
	
	public final String Update = "UPDATE dbOdonto.PACIENTE\r\n" + 
			"SET NOME=?, DATA_NASCIMENTO=?, EMAIL=?, ENDERECO=?, CELULAR=?, SEXO=?\r\n" + 
			"WHERE NOME = ?";
}
