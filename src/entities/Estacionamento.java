package entities;

import java.util.ArrayList;
import java.util.Date;

public class Estacionamento {
	private Veiculo[][] vaga = new Veiculo[60][2];
	int nVeiculos = 0;
	
	public int getnVeiculos() {
        return nVeiculos;
    }
	
	public boolean entraVeiculo(String placa, String modelo, Tipo tipo, Pessoa proprietario){
        for (int a=0; a < this.vaga.length; a++){
            if (tipo.equals(Tipo.CARRO)){
            	Carro carro = new Carro(proprietario, Tipo.CARRO, modelo, placa);
                if (this.vaga[a][0] == null && this.vaga[a][1] == null){
                    this.vaga[a][0] = carro;
                    nVeiculos++;
                    return true;
                }
            } else {
            	Moto moto = new Moto(proprietario, Tipo.MOTO, modelo, placa);
                if (this.vaga[a][0] == null){
                    this.vaga[a][0] = moto;
                    nVeiculos++;
                    return true;
                } else if (this.vaga[a][0].getTipo().equals(Tipo.MOTO)){
                    if (this.vaga[a][1] == null){
                        this.vaga[a][1] = moto;
                        nVeiculos++;
                        return true;
                    }
                }
            }
        }
        return false;
    }
	
	private void removeVeiculo(int g, int l){
        this.vaga[g][l] = null;
        nVeiculos--;
    }
    
    private float calculatotal(int g, int l){
        float total = 0;
        if (this.vaga[g][l] != null){
            Date data = new Date();
            @SuppressWarnings("deprecation")
			int horaAtual = data.getHours();
			int tempo = horaAtual - this.vaga[g][l].getHorario();
			if (tempo <= 1) {
				total = (float) this.vaga[g][l].getValorInicial();
			} else {
				total = (float) (((tempo - 1) * this.vaga[g][l].getValorAdicional()) + this.vaga[g][l].getValorInicial());
			}
        }
        return total;
    }
    
    public float saiVeiculo(String placa){
        float total = 0;
        for (int a=0; a < this.vaga.length; a++){
            if (this.vaga[a][0] != null){
                if (placa.equals(this.vaga[a][0].getPlaca())){
                    total = calculatotal(a, 0);
                    removeVeiculo(a, 0);
                    return total;
                }
            } else if (this.vaga[a][1] != null){
                if (placa.equals(this.vaga[a][1].getPlaca())){
                    total = calculatotal(a, 1);
                    removeVeiculo(a, 1);
                    return total;
                }   
            }
        }
        return total;
    }
	
    public ArrayList<Veiculo> listaEstacionados(){
    	ArrayList<Veiculo> lista = new ArrayList<>();
        for (int a=0; a < this.vaga.length; a++){
            if (this.vaga[a][0] != null){
            	lista.add(this.vaga[a][0]);
            }
            if (this.vaga[a][1] != null){
            	lista.add(this.vaga[a][1]);
            }
        }
        return lista;
    }
}
