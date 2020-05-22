package br.com.odondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.odonto.models.Dentista;
import br.com.odonto.models.Paciente;
import br.com.odonto.queries.DentistaQuery;
import br.com.odonto.util.ConnectionFactory;

public class DentistaDao {
	
	private Connection con;
	private ConnectionFactory cn = new ConnectionFactory();
	private PreparedStatement preparedStatement;
	private ResultSet result;
	private DentistaQuery Query = new DentistaQuery();
	
	public DentistaDao() throws Exception{
		try {
			con = cn.getConnection();
		}
		catch (Exception ex){
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public ArrayList<Dentista> Listar() throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetAll);
			result = preparedStatement.executeQuery();
			
			var dentistas = new ArrayList<Dentista>();
			
			while(result.next())
			{
				var nome = result.getString("NOME");
				var especialidade = result.getString("ESPECIALIDADE");
				
				var dentista = new Dentista();
				dentista.setEspecialidade(especialidade);
				dentista.setNome(nome);
				
				dentistas.add(dentista);
			}
			
			return dentistas;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}

	
	public Dentista GetporNome(String nome) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetporNome);
			preparedStatement.setString(1, nome);
			result = preparedStatement.executeQuery();
			
			var dentista = new Dentista();
			
			if(result.next())
			{
				var id = result.getInt("ID");
				var especialidade = result.getString("ESPECIALIDADE");

				dentista.setNome(nome);
				dentista.setId(id);
				dentista.setEspecialidade(especialidade);
			}
			
			return dentista;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
}
