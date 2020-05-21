package br.com.odonto.models;

import java.util.Date;

public class Paciente {

	private int Id;
	private String Nome;
	private Date DataNascimento;
	private String Email;
	private String Endereco;
	private String Celular;
	private String Sexo;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
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