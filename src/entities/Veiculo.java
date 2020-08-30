package entities;

import java.util.Date;

public abstract class Veiculo {
	private int horario;
	private Pessoa proprietario;
	private Tipo tipo;
	private String modelo;
	private String placa;
	
	@SuppressWarnings("deprecation")
	public Veiculo(Pessoa proprietario, Tipo tipo, String modelo, String placa) {
		this.proprietario = proprietario;
		this.tipo = tipo;
		this.modelo = modelo;
		this.placa = placa;
		
		Date date = new Date();
		this.horario = date.getHours();
	}
	
	public Pessoa getProprietario() {
		return proprietario;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public int getHorario() {
		return horario;
	}
	
	public abstract double getValorInicial();
	public abstract double getValorAdicional();
}
