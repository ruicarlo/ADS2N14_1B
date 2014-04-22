package app;

import controller.ContaController;
import controller.PessoaController;

public class PessoaApp {

    public static void main(String[] args) {
        int qtdContatos = 2;
        boolean sair;
        
        try {
            PessoaController pessoa = new PessoaController();
            pessoa.armazenarPessoaNoArquivo(qtdContatos);
            
            String[] contatos = pessoa.getContatosArquivo();
            
            ContaController[] contas = pessoa.getContaPessoas(contatos.length);
       
            
            for(int i=0; i<contas.length;i++) {
                try {
                    do {
                        sair = contas[i].executarComando();
                        if(sair && !contas[i].getUltimoMovimento().isEmpty()){
                            pessoa.adicionarMovimento(String.format("%d##%s##%f", contas[i].getNumeroConta(), 
                                                                                  contas[i].getUltimoMovimento(),
                                                                                  contas[i].getSaldo())
                            );
                        }
                    } while(sair);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            pessoa.armazenarContasNoArquivo(contas);
            pessoa.armazenarMovimentosNoArquivo();
       
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}