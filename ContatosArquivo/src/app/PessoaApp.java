package app;

import controller.PessoaController;

public class PessoaApp {

    public static void main(String[] args) {
        PessoaController pessoa = new PessoaController();
        pessoa.armazenarPessoaNoArquivo(20);
    }
}