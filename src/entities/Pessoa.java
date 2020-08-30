package entities;

public class Pessoa {
	private String cpf;
	private String nome;
	private String tel;
	
	public Pessoa(String cpf, String nome, String tel) {
		this.cpf = cpf;
		this.nome = nome;
		this.tel = tel;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return tel;
	}
}
