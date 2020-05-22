package br.com.odonto.models;

public class Agenda {
	
	public Agenda(int id, String data, String hora, String obs, String procedimento, String dentista, String paciente) {
		Id = id;
		Data = data;
		Hora = hora;
		Obs = obs;
		Procedimento = procedimento;
		Dentista = dentista;
		Paciente = paciente;
	}
	
	public Agenda() {};
	
	private int Id;
	private String Data;
	private String Hora;
	private String Obs;
	private String Procedimento;
	private String Dentista;
	private String Paciente;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public String getHora() {
		return Hora;
	}
	public void setHora(String hora) {
		Hora = hora;
	}
	public String getObs() {
		return Obs;
	}
	public void setObs(String obs) {
		Obs = obs;
	}
	public String getProcedimento() {
		return Procedimento;
	}
	public void setProcedimento(String procedimento) {
		Procedimento = procedimento;
	}
	public String getDentista() {
		return Dentista;
	}
	public void setDentista(String dentista) {
		Dentista = dentista;
	}
	public String getPaciente() {
		return Paciente;
	}
	public void setPaciente(String paciente) {
		Paciente = paciente;
	}


}
