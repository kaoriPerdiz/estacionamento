package entities;

public class Carro extends Veiculo {
	private double valorInicial = 2.00;
	private double valorAdicional = 2.50;
	
	public Carro(Pessoa proprietario, Tipo tipo, String modelo, String placa) {
		super(proprietario, tipo, modelo, placa);
	}
	
	public double getValorInicial() {
		return valorInicial;
	}

	public double getValorAdicional() {
		return valorAdicional;
	}
}
