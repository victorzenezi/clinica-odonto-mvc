package br.com.odonto.queries;

public class ProcedimentoQuery {

	public final String GetporNome = "SELECT * FROM PROCEDIMENTO WHERE DESCRICAO = ?";
	
	public final String GetAll = "SELECT * FROM PROCEDIMENTO";
	
	public final String Post = "INSERT INTO dbOdonto.PROCEDIMENTO (DESCRICAO, VALOR) VALUES (?, ?)";
}
