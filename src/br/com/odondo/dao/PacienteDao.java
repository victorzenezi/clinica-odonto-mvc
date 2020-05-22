package br.com.odondo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.odonto.models.Paciente;
import br.com.odonto.queries.PacienteQuery;
import br.com.odonto.util.ConnectionFactory;

public class PacienteDao {
	
	private Connection con;
	private ConnectionFactory cn = new ConnectionFactory();
	private PreparedStatement preparedStatement;
	private ResultSet result;
	private PacienteQuery Query = new PacienteQuery();
	
	public PacienteDao() throws Exception{
		try {
			con = cn.getConnection();
		}
		catch (Exception ex){
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public void Cadastrar(Paciente paciente) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.Post);
			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setString(2, paciente.getDataNascimento());
			preparedStatement.setString(3, paciente.getEmail());
			preparedStatement.setString(4, paciente.getEndereco());
			preparedStatement.setString(5, paciente.getCelular());
			preparedStatement.setString(6, paciente.getSexo());

			preparedStatement.execute();
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public ArrayList<Paciente> Listar() throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetAll);
			result = preparedStatement.executeQuery();
			
			var pacientes = new ArrayList<Paciente>();
			
			while(result.next())
			{
				var nome = result.getString("NOME");
				var data = result.getString("DATANASCIMENTO");
				var email = result.getString("EMAIL");
				var endereco = result.getString("ENDERECO");
				var cel = result.getString("CELULAR");
				var sexo = result.getString("SEXO");
				
				var paciente = new Paciente(nome, data, email, endereco, cel, sexo);
				
				pacientes.add(paciente);
			}
			
			return pacientes;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public Paciente GetporNome(String nome) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetporNome);
			preparedStatement.setString(1, nome);
			result = preparedStatement.executeQuery();
			
			var paciente = new Paciente();
			
			if(result.next())
			{
				var id = result.getInt("ID");
				var data = result.getString("DATANASCIMENTO");
				var email = result.getString("EMAIL");
				var endereco = result.getString("ENDERECO");
				var cel = result.getString("CELULAR");
				var sexo = result.getString("SEXO");
				
				paciente.setNome(nome);
				paciente.setDataNascimento(data);
				paciente.setEmail(email);
				paciente.setEndereco(endereco);
				paciente.setCelular(cel);
				paciente.setSexo(sexo);
				paciente.setId(id);
			}
			
			return paciente;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public Paciente GetById(int id) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.GetById);
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			
			var paciente = new Paciente();
			
			if(result.next())
			{
				var nome = result.getString("NOME");
				var data = result.getString("DATANASCIMENTO");
				var email = result.getString("EMAIL");
				var endereco = result.getString("ENDERECO");
				var cel = result.getString("CELULAR");
				var sexo = result.getString("SEXO");
				
				paciente.setNome(nome);
				paciente.setDataNascimento(data);
				paciente.setEmail(email);
				paciente.setEndereco(endereco);
				paciente.setCelular(cel);
				paciente.setSexo(sexo);
				paciente.setId(id);
			}
			
			return paciente;
						
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
	}
	
	public void Remover(String nome) throws Exception {
		try 
		{
			preparedStatement = con.prepareStatement(Query.Delete);
			preparedStatement.setString(1, nome);
			preparedStatement.execute();
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
		
	}
	
	public void Update(Paciente paciente, String nome) throws Exception {
		
		try 
		{
			preparedStatement = con.prepareStatement(Query.Update);
			preparedStatement.setString(1, paciente.getNome());
			preparedStatement.setString(2, paciente.getDataNascimento());
			preparedStatement.setString(3, paciente.getEmail());
			preparedStatement.setString(4, paciente.getEndereco());
			preparedStatement.setString(5, paciente.getCelular());
			preparedStatement.setString(6, paciente.getSexo());
			preparedStatement.setString(7, nome);

			preparedStatement.executeUpdate();
			
		}
		catch(Exception ex)
		{
			throw new Exception("Erro: " + ex.getMessage());		
		}
		
	}
}
