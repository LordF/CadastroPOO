package model;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1, "Ana", "1111111111", 25));
        repo1.inserir(new PessoaFisica(2, "Carlos", "2222222222", 35));

        try {
            repo1.persistir("pessoas_fisicas.dat");
            System.out.println("Dados de Pessoa Física Armazenados");
        } catch (IOException e) {
            System.out.println("Erro ao persistir dados de pessoas físicas: " + e.getMessage());
        }

        PessoaFisicaRepo repo2 = null;
        try {
            repo2 = PessoaFisicaRepo.recuperar("pessoas_fisicas.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados de pessoas físicas: " + e.getMessage());
        }

        if (repo2 != null) {
            System.out.println("Dados de pessoa física recuperada:");
            for (PessoaFisica pessoa : repo2.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }
        }

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(1, "Empresa A", "12345678901234"));
        repo3.inserir(new PessoaJuridica(2, "Empresa B", "98765432109876"));

        try {
            repo3.persistir("pessoas_juridicas.dat");
            System.out.println("Dados de Pessoa Jurídica Armazenados");
        } catch (IOException e) {
            System.out.println("Erro ao persistir dados de pessoas jurídicas: " + e.getMessage());
        }
        
        PessoaJuridicaRepo repo4 = null;
        try {
            repo4 = PessoaJuridicaRepo.recuperar("pessoas_juridicas.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados de pessoas jurídicas: " + e.getMessage());
        }

        if (repo4 != null) {
            System.out.println("Pessoas Jurídicas Recuperadas:");
            for (PessoaJuridica pessoa : repo4.obterTodos()) {
                pessoa.exibir();
                System.out.println();
            }
        }
    }
}
