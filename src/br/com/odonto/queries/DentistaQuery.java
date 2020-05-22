package br.com.odonto.queries;

public class DentistaQuery {

	public final String GetporNome = "SELECT * FROM DENTISTA WHERE NOME = ?";
	
	public final String GetById = "SELECT * FROM DENTISTA WHERE ID = ?";
	
	public final String GetAll = "SELECT * FROM DENTISTA";
}
