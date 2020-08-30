package entities;

public class Moto extends Veiculo {

	private double valorInicial = 2.00;
	private double valorAdicional = 1.50;
	
	public Moto(Pessoa proprietario, Tipo tipo, String modelo, String placa) {
		super(proprietario, tipo, modelo, placa);
	}
	
	public double getValorInicial() {
		return valorInicial;
	}

	public double getValorAdicional() {
		return valorAdicional;
	}
}
