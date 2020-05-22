package br.com.odondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.odonto.models.Agenda;
import br.com.odonto.models.Consulta;
import br.com.odonto.models.Dentista;
import br.com.odonto.models.Paciente;
import br.com.odonto.queries.ConsultaQuery;
import br.com.odonto.util.ConnectionFactory;

public class ConsultaDao {
	
	private Connection con;
	private ConnectionFactory cn = new ConnectionFactory();
	private PreparedStatement preparedStatement;
	private ResultSet result;
	private ConsultaQuery Query = new ConsultaQuery();
	
	public ConsultaDao() throws Exception{
		try {
			con = cn.getConnection();
		}
		catch (Exception ex){
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public ArrayList<Consulta> GetAllporDentista(String nome) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetAllporDentista);
			preparedStatement.setString(1, nome);
			result = preparedStatement.executeQuery();
			
			var consultas = new ArrayList<Consulta>();
			
			while(result.next())
			{
				var id = result.getInt("ID");
				var data = result.getString("DATA_CONSULTA");
				var hora = result.getString("HORA_CONSULTA");
				var valor = result.getDouble("VALOR_CONSULTA");
				var obs = result.getString("OBS");
				var paciente = result.getString("PACIENTE");
				
				var consulta = new Consulta();
				
				consulta.setId(id);
				consulta.setDataConsulta(data);
				consulta.setHoraConsulta(hora);
				consulta.setValor(valor);
				consulta.setObservacao(obs);
				consulta.setPaciente(paciente);
				
				consultas.add(consulta);
			}
			
			return consultas;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public Consulta GetbyId(int id) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetbyId);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			
			var consulta = new Consulta();
			
			if(result.next())
			{
				var obs = result.getString("OBS");

				consulta.setId(id);
				consulta.setObservacao(obs);
			}
			
			return consulta;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public void AtualizarConsulta(int id, String obs) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.Update);
			preparedStatement.setString(1, obs);
			preparedStatement.setInt(2, id);


			preparedStatement.executeUpdate();
			
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public ArrayList<Agenda> GetAgenda(String nome) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetAgenda);
			preparedStatement.setString(1, nome);
			result = preparedStatement.executeQuery();
			
			var agenda = new ArrayList<Agenda>();
			
			while(result.next())
			{
				var id = result.getInt("ID");
				var data = result.getString("DATA_CONSULTA");
				var hora = result.getString("HORA_CONSULTA");
				var obs = result.getString("OBS");
				var procedimento = result.getString("PROCEDIMENTO");
				var dentista = result.getString("DENTISTA");
				var paciente = result.getString("PACIENTE");
				
				var consulta = new Agenda();
				
				consulta.setId(id);
				consulta.setData(data);
				consulta.setHora(hora);
				consulta.setObs(obs);
				consulta.setProcedimento(procedimento);
				consulta.setDentista(dentista);
				consulta.setPaciente(paciente);
				
				agenda.add(consulta);
			}
			
			return agenda;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public ArrayList<Agenda> GetAgendaHistorico(String nome) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetAgendaHistorico);
			preparedStatement.setString(1, nome);
			result = preparedStatement.executeQuery();
			
			var agenda = new ArrayList<Agenda>();
			
			while(result.next())
			{
				var id = result.getInt("ID");
				var data = result.getString("DATA_CONSULTA");
				var hora = result.getString("HORA_CONSULTA");
				var obs = result.getString("OBS");
				var procedimento = result.getString("PROCEDIMENTO");
				var dentista = result.getString("DENTISTA");
				var paciente = result.getString("PACIENTE");
				
				var consulta = new Agenda();
				
				consulta.setId(id);
				consulta.setData(data);
				consulta.setHora(hora);
				consulta.setObs(obs);
				consulta.setProcedimento(procedimento);
				consulta.setDentista(dentista);
				consulta.setPaciente(paciente);
				
				agenda.add(consulta);
			}
			
			return agenda;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public void MarcarConsulta(Consulta consulta, int idprocedimento) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.MarcarConsulta);
			preparedStatement.setString(1, consulta.getDataConsulta());
			preparedStatement.setString(2, consulta.getHoraConsulta());
			preparedStatement.setDouble(3, consulta.getValor());
			preparedStatement.setString(4, consulta.getObservacao());
			preparedStatement.setInt(5, consulta.getPacienteId());
			preparedStatement.setInt(6, consulta.getDentistaId());

			preparedStatement.execute();
			
			var idConsulta = GetLastId();

			preparedStatement = con.prepareStatement(Query.ConsultaProcedimento);
			preparedStatement.setInt(1, idConsulta);
			preparedStatement.setInt(2, idprocedimento);
			
			preparedStatement.execute();
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	
	public int GetLastId() throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetLastId);
			result = preparedStatement.executeQuery();
			result.next();
			return result.getInt("ID");
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
}
