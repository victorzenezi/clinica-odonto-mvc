package br.com.odonto.models;

import java.util.Date;

public class Paciente {

	private int Id;
	private String Nome;
	private String DataNascimento;
	private String Email;
	private String Endereco;
	private String Celular;
	private String Sexo;
	
	public Paciente(String nome, String dataNascimento, String email, String endereco, String celular, String sexo) {
		Nome = nome;
		DataNascimento = dataNascimento;
		Email = email;
		Endereco = endereco;
		Celular = celular;
		Sexo = sexo;
	}
	
	public Paciente() {};
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public String getCelular() {
		return Celular;
	}
	public void setCelular(String celular) {
		Celular = celular;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}

	
}