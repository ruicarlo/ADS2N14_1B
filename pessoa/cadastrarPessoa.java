package pessoa;

import java.util.Scanner;
import java.util.InputMismatchException;

import static java.lang.System.*;

public class cadastrarPessoa {

    public static void main(String[] args) {

        String nome;
        String RG;
        
        String CPF;
        boolean CPFValidado = false;
        String genero;
        boolean generoValidado = false;
        
        int idade;
        boolean idadeValidada = false;
        
        Scanner ler = new Scanner(in);
        Pessoa pessoa = new Pessoa();

        out.print("Digite seu nome: ");
        nome = ler.next();
        pessoa.setNome(nome);

        out.print("Digite seu RG: ");
        RG = ler.next();
        pessoa.setRG(RG);

        do {
            try {
                out.print("Digite seu CPF: ");
                CPF = ler.next();
                pessoa.validarCPF(CPF);
                pessoa.setCPF(CPF);
                CPFValidado = true;
            } catch(Exception Excecao) {
                out.println(Excecao.getMessage());
            }
        } while(!CPFValidado);

        do {
            try {
                out.print("Digite seu sexo (M ou F): ");
                genero = ler.next();
                pessoa.validarGenero(genero);
                pessoa.setGenero(genero);
                generoValidado = true;
            } catch(Exception Excecao) {
                out.println(Excecao.getMessage());
            }
        } while(!generoValidado);

        do {
            try {
                out.print("Digite sua idade: ");
                idade  = ler.nextInt();
                pessoa.validarIdade(idade);
                pessoa.setIdade(idade);
                idadeValidada = true;
            } catch(InputMismatchException e) {
                out.println("Idade inválida");
                ler = new Scanner(in);
            } catch(Exception e) {
                out.println(e.getMessage());
            }
        } while(!idadeValidada);
        
        out.println("Nome: " + pessoa.getNome());
        out.println("CPF: " + pessoa.getCPF());
        out.println("RG: " + pessoa.getRG());
        out.println("Genero: " + pessoa.getGenero());
        out.println("Idade: " + pessoa.getIdade());
    }    
}