package br.com.odonto.queries;

public class ConsultaQuery {

	public final String GetAllporDentista = "SELECT C.ID, DATA_CONSULTA, HORA_CONSULTA, VALOR_CONSULTA, OBS, P.NOME as PACIENTE  FROM CONSULTA AS C\r\n" + 
			"INNER JOIN DENTISTA AS D ON D.ID = C.ID_DENTISTA \r\n" + 
			"INNER JOIN PACIENTE AS P ON P.ID = C.ID_PACIENTE \r\n" + 
			"WHERE D.NOME = ? and C.ATIVO = 1 ORDER BY C.DATA_CONSULTA ";
	
	public final String GetbyId = "SELECT * FROM CONSULTA WHERE ID = ?";
	
	public final String Update = "UPDATE dbOdonto.CONSULTA SET OBS = ? , ATIVO = 0 WHERE ID = ?";
	
	public final String GetAgenda = "SELECT C.ID , C.DATA_CONSULTA , C.HORA_CONSULTA , C.OBS , PROC.DESCRICAO AS PROCEDIMENTO ,D.NOME AS DENTISTA , P.NOME AS PACIENTE FROM CONSULTA C\r\n" + 
			"INNER JOIN PACIENTE AS P ON P.ID = C.ID_PACIENTE \r\n" + 
			"INNER JOIN DENTISTA AS D ON D.ID = C.ID_DENTISTA \r\n" + 
			"INNER JOIN CONSULTA_PROCEDIMENTO AS CP ON CP.ID_CONSULTA = C.ID \r\n" + 
			"INNER JOIN PROCEDIMENTO AS PROC ON PROC.ID = CP.ID_PROCEDIMENTO \r\n" + 
			"WHERE D.NOME = ? and C.ATIVO = 1\r\n" + 
			"ORDER BY C.DATA_CONSULTA AND C.HORA_CONSULTA ";
	
	public final String GetAgendaHistorico = "SELECT C.ID , C.DATA_CONSULTA , C.HORA_CONSULTA , C.OBS , PROC.DESCRICAO AS PROCEDIMENTO ,D.NOME AS DENTISTA , P.NOME AS PACIENTE FROM CONSULTA C\r\n" + 
			"INNER JOIN PACIENTE AS P ON P.ID = C.ID_PACIENTE \r\n" + 
			"INNER JOIN DENTISTA AS D ON D.ID = C.ID_DENTISTA \r\n" + 
			"INNER JOIN CONSULTA_PROCEDIMENTO AS CP ON CP.ID_CONSULTA = C.ID \r\n" + 
			"INNER JOIN PROCEDIMENTO AS PROC ON PROC.ID = CP.ID_PROCEDIMENTO \r\n" + 
			"WHERE D.NOME = ? \r\n" + 
			"ORDER BY C.DATA_CONSULTA AND C.HORA_CONSULTA ";
	
	public final String MarcarConsulta = "INSERT INTO dbOdonto.CONSULTA\r\n" + 
			"(DATA_CONSULTA, HORA_CONSULTA, VALOR_CONSULTA, OBS, ID_PACIENTE, ID_DENTISTA, ATIVO)\r\n" + 
			"VALUES(?, ?, ?, ?, ?, ?, 1)";
	
	public final String ConsultaProcedimento = "INSERT INTO dbOdonto.CONSULTA_PROCEDIMENTO\r\n" + 
			"(ID_CONSULTA, ID_PROCEDIMENTO)\r\n" + 
			"VALUES(?, ?);";
	
	public final String GetAll = "SELECT * FROM CONSULTA";
	
	public final String GetAllAtivos = "SELECT * FROM CONSULTA WHERE ATIVO = 1";
	
	public final String Delete = "DELETE FROM CONSULTA WHERE ID = ?";
	
	public final String GetLastId = "SELECT LAST_INSERT_ID() as ID";
}
