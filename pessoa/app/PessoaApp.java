package pessoa.app;

import pessoa.controller.PessoaController;

public class PessoaApp {

    public static void main(String[] args) {
        PessoaController pessoa = new PessoaController();
        for(int i = 0; i < 50; i++) {
            pessoa.gerarCadastroAleatorioT2();
        }
    }
    
}