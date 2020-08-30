package main;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Estacionamento;
import entities.Pessoa;
import entities.Tipo;
import entities.Veiculo;

public class Main {
	
	public static void main(String[] args) {
		Estacionamento estacionamento = new Estacionamento();
		Scanner sc = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("Selecione uma opção:");
			System.out.println("1 - adicionar veículo");
			System.out.println("2 - saída de um veículo");
			System.out.println("3 - listagem de veículos estacionados");
			System.out.println("4 - sair");
			opcao = sc.nextInt();
			sc.nextLine();
			switch(opcao) {
				case 1:
					String cpf;
					String nome;
					String tel;
					String modelo;
					String placa;
					String tipo = "";
					
					System.out.println("Informe o CPF do cliente: ");
					cpf = sc.nextLine();
					System.out.println("Informe o nome do cliente: ");
					nome = sc.nextLine();
					System.out.println("Informe o telefone do cliente: ");
					tel = sc.nextLine();
					
					Pessoa p = new Pessoa(cpf, nome, tel);
					
					while(!(tipo.equals("CARRO")) && !(tipo.equals("MOTO"))) {
						System.out.println("Qual o tipo do veículo? Carro ou moto?");
						tipo = sc.nextLine().toUpperCase();
					}
					
					System.out.println("Qual o modelo do veículo?");
					modelo = sc.nextLine();
					System.out.println("Qual a placa do veículo?");
					placa = sc.nextLine();
					
					if(tipo == "CARRO") {
						if(estacionamento.entraVeiculo(placa, modelo, Tipo.CARRO, p)) {
							System.out.println("Incluído com sucesso!");
						}else {
							System.out.println("Erro!\n");
						}
					}else {
						if(estacionamento.entraVeiculo(placa, modelo, Tipo.MOTO, p)) {
							System.out.println("Incluído com sucesso!");
						}else {
							System.out.println("Erro!");
						}
					}
				break;
				case 2:
					System.out.println("Informe a placa do veículo a ser retirado:");
					placa = sc.nextLine();
					System.out.printf("Total a ser pago: %.2f", estacionamento.saiVeiculo(placa), "\n");
				break;
				case 3:
					ArrayList<Veiculo> lista = estacionamento.listaEstacionados();
					for (int i=0; i < lista.size(); i++) {
						
						System.out.println(lista.get(i).getPlaca());
					}
				break;
			}
		}while(opcao < 4);
		return;
	}
	
}
