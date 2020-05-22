package br.com.odonto.models;

import java.sql.Time;
import java.util.Date;

public class Consulta {

	private int Id;
	private String DataConsulta;
	private String HoraConsulta;
	private Double Valor;
	private String Observacao;
	private int PacienteId;
	private int DentistaId;
	
	private String Paciente;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDataConsulta() {
		return DataConsulta;
	}
	public void setDataConsulta(String dataConsulta) {
		DataConsulta = dataConsulta;
	}
	public String getHoraConsulta() {
		return HoraConsulta;
	}
	public void setHoraConsulta(String horaConsulta) {
		HoraConsulta = horaConsulta;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}
	public String getObservacao() {
		return Observacao;
	}
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}
	public int getPacienteId() {
		return PacienteId;
	}
	public void setPacienteId(int pacienteId) {
		PacienteId = pacienteId;
	}
	public int getDentistaId() {
		return DentistaId;
	}
	public void setDentistaId(int dentistaId) {
		DentistaId = dentistaId;
	}
	public String getPaciente() {
		return Paciente;
	}
	public void setPaciente(String paciente) {
		Paciente = paciente;
	}

}
