package pessoa;

import java.util.Scanner;
import java.util.InputMismatchException;

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
        
        Scanner ler = new Scanner(System.in);
        Pessoa pessoa = new Pessoa();

        System.out.print("Digite seu nome: ");
        nome = ler.next();
        pessoa.setNome(nome);

        System.out.print("Digite seu RG: ");
        RG = ler.next();
        pessoa.setRG(RG);

        do {
            try {
                System.out.print("Digite seu CPF: ");
                CPF = ler.next();
                pessoa.validarCPF(CPF);
                pessoa.setCPF(CPF);
                CPFValidado = true;
            } catch(Exception Excecao) {
                System.out.println(Excecao.getMessage());
            }
        } while(!CPFValidado);

        do {
            try {
                System.out.print("Digite seu sexo (M ou F): ");
                genero = ler.next();
                pessoa.validarGenero(genero);
                pessoa.setGenero(genero);
                generoValidado = true;
            } catch(Exception Excecao) {
                System.out.println(Excecao.getMessage());
            }
        } while(!generoValidado);

        do {
            try {
                System.out.print("Digite sua idade: ");
                idade  = ler.nextInt();
                pessoa.validarIdade(idade);
                pessoa.setIdade(idade);
                idadeValidada = true;
            } catch(InputMismatchException e) {
                System.out.println("Idade inválida");
                ler = new Scanner(System.in);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!idadeValidada);
        
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("CPF: " + pessoa.getCPF());
        System.out.println("RG: " + pessoa.getRG());
        System.out.println("Genero: " + pessoa.getGenero());
        System.out.println("Idade: " + pessoa.getIdade());
    }    
}