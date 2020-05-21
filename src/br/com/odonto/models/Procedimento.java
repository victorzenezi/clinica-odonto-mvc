package br.com.odonto.models;

public class Procedimento {
	
	private int Id;
	private String Descricao;
	private Double Valor;
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Double getValor() {
		return Valor;
	}
	public void setValor(Double valor) {
		Valor = valor;
	}

}
