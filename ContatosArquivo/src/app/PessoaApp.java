package app;

import controller.PessoaController;
import java.io.IOException;

import java.io.FileWriter;
public class PessoaApp {

    public static void main(String[] args) {
        try {
            FileWriter arq = new FileWriter("d:\\tabuada.txt");
        
        }catch(Exception e) {
        }
        
    PrintWriter gravarArq = new PrintWriter(arq);

    gravarArq.printf("+--Resultado--+%n");


Leia mais em: Criando e Gravando dados em Txt com Java http://www.devmedia.com.br/criando-e-gravando-dados-em-txt-com-java/23060#ixzz2yL5QVJLp

        
        PessoaController pessoa = new PessoaController();
        for(int i = 0; i < 20; i++) {
            pessoa.gerarCadastroAleatorio();
        }
    }
    
}