package br.com.odondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.odonto.models.Dentista;
import br.com.odonto.models.Procedimento;
import br.com.odonto.queries.ProcedimentoQuery;
import br.com.odonto.util.ConnectionFactory;

public class ProcedimentoDao {
	
	private Connection con;
	private ConnectionFactory cn = new ConnectionFactory();
	private PreparedStatement preparedStatement;
	private ResultSet result;
	private ProcedimentoQuery Query = new ProcedimentoQuery();
	
	public ProcedimentoDao() throws Exception{
		try {
			con = cn.getConnection();
		}
		catch (Exception ex){
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public Procedimento GetporNome(String nome) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetporNome);
			preparedStatement.setString(1, nome);
			result = preparedStatement.executeQuery();
			
			var proc = new Procedimento();
			
			if(result.next())
			{
				var id = result.getInt("ID");
				var valor = result.getDouble("VALOR");

				proc.setDescricao(nome);
				proc.setValor(valor);
				proc.setId(id);
			}
			
			return proc;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public ArrayList<Procedimento> Listar() throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetAll);
			result = preparedStatement.executeQuery();
			
			var procs = new ArrayList<Procedimento>();
			
			while(result.next())
			{
				var id = result.getInt("ID");
				var desc = result.getString("DESCRICAO");
				var valor = result.getDouble("VALOR");

				var proc = new Procedimento();
				proc.setDescricao(desc);
				proc.setValor(valor);
				proc.setId(id);

				procs.add(proc);
			}
			
			return procs;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
}
