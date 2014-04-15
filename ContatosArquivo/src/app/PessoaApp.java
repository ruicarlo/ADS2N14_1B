package app;

import controller.PessoaController;
import controller.ContaController;

public class PessoaApp {

    public static void main(String[] args) {
        int qtdContatos = 20;
        PessoaController pessoa = new PessoaController();
        pessoa.armazenarPessoaNoArquivo(qtdContatos);
        pessoa.lerPessoasDoArquivo();
        /*
        try {
            boolean sair;
            ContaController conta = new ContaController();
            conta.criarContaAleatoria();
            System.out.println(
            conta.getDadosContaParaSalvarArquivo()
                    );
//            do {
//                sair = conta.executarComando();
//            } while(sair);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        * */
    }
}