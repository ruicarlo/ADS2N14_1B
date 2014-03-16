package pessoa.app;

import pessoa.controller.PessoaController;

public class PessoaApp {

    public static void main(String[] args) {
        PessoaController pessoa = new PessoaController();
        pessoa.gerarCadastroAleatorioT2();
    }
    
}