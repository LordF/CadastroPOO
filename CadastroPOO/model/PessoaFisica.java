package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String cpf;
	int idade;
	
	public PessoaFisica(int id, String nome, String cpf, int idade) {
		super(id, nome);
		this.cpf= cpf;
		this.idade= idade;
	}
	
	@Override
    public void exibir() {
        super.exibir();
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade +"\n");
    }
	
	public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;	
    }
}
