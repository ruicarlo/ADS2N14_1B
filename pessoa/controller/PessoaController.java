package pessoa.controller;

//import pessoa.model.Pessoa;
import pessoa.view.PessoaView;

import java.util.Scanner;
import java.util.InputMismatchException;
import pessoa.model.Pessoa;

import static java.lang.System.*;
import java.util.Random;

public class PessoaController {

    private Scanner ler = new Scanner(in);
    private Pessoa pessoa = new Pessoa();
    private PessoaView view = new PessoaView();
    private Random gerador = new Random();

    private String nome;
    private String endereco;
    private String RG;
    private String CPF;
    private String genero;
    private String tipoTelefone;
    private String telefone;
    private int idade;

    private boolean CPFValidado;
    private boolean generoValidado;
    private boolean tipoTelefoneValidado;
    private boolean telefoneValidado;
    private boolean idadeValidada;
    
    public void cadastrarPessoaT2(String nome, String telefone) {
        this.pessoa.setNome(nome);
        this.pessoa.setTelefone(telefone);
    }

    public String gerarTelefoneAleatorioT2() {
        return (this.gerador.nextInt(1000-100)+100) + "-" + (this.gerador.nextInt(10000-1000)+1000);
    }
    
    public void gerarCadastroAleatorioT2() {
        String nomes[] = {"Miguel","Gabriel","Lucas","Gustavo","Felipe","Enzo","João Pedro","Cauã","Eduardo","Henrique","Vinicius","Pietro","Leonardo","Heitor","Isaac","Thiago","João","Bruno","Carlos Eduardo","Breno","Ryan","Yuri","Erick","Fernando","André","Lívia","Helena","Lorena","Larissa","Heloisa","Melissa","Eduarda","Rebeca","Alícia","Lavínia","Ester","Emily","Cecília","Pietra","Milena","Laís","Maria","Camila","Ana Laura","Maria Vitória","Olivia","Mirella","Stella","Stefany","Isabel"};
        for (String nome2 : nomes) {
            this.cadastrarPessoaT2(nome2, this.gerarTelefoneAleatorioT2());
            this.view.imprimeDadosPessoa(this.pessoa.getNome(), this.pessoa.getTelefone());        
        }
    }

    public void lerPessoa() {
        this.reiniciarValores();

        this.lerNome();
        this.lerEndereco();
        this.lerRG();
        this.lerCPF();
        this.lerGenero();
        this.lerIdade();
        this.lerTipoTelefone();
        this.lerTelefone();
    }
    
    private void reiniciarValores() {
        this.nome = "";
        this.endereco = "";
        this.RG = "";
        this.CPF = "";
        this.genero = "";
        this.tipoTelefone = "";
        this.telefone = "";
        this.idade = 0;

        this.CPFValidado = false;
        this.generoValidado = false;
        this.tipoTelefoneValidado = false;
        this.telefoneValidado = false;
        this.idadeValidada = false;
    }

    private void lerNome() {
        out.print("Digite seu nome: ");
        this.nome = this.ler.nextLine();
        this.pessoa.setNome(this.nome);
    }
    
    private void lerEndereco() {
        out.print("Digite seu endereço: ");
        this.endereco = this.ler.nextLine();
        this.pessoa.setEndereco(this.endereco);
    }
    
    private void lerRG() {
        out.print("Digite seu RG: ");
        this.RG = this.ler.nextLine();
        this.pessoa.setRG(this.RG);
    }
    
    private void lerCPF() {
        do {
            try {
                out.print("Digite seu CPF: ");
                this.CPF = this.ler.nextLine();
                this.pessoa.validarCPF(this.CPF);
                this.pessoa.setCPF(this.CPF);
                this.CPFValidado = true;
            } catch(Exception Excecao) {
                out.println(Excecao.getMessage());
            }
        } while(!this.CPFValidado);

    }
    
    private void lerGenero() {
        do {
            try {
                out.print("Digite seu sexo (M ou F): ");
                this.genero = this.ler.nextLine();
                this.pessoa.validarGenero(this.genero);
                this.pessoa.setGenero(this.genero);
                this.generoValidado = true;
            } catch(Exception Excecao) {
                out.println(Excecao.getMessage());
            }
        } while(!this.generoValidado);
    }

    private void lerIdade() {
        do {
            try {
                out.print("Digite sua idade: ");
                this.idade  = this.ler.nextInt();
                this.pessoa.validarIdade(this.idade);
                this.pessoa.setIdade(this.idade);
                this.idadeValidada = true;
            } catch(InputMismatchException e) {
                out.println("Idade inválida");
                this.ler = new Scanner(in);
            } catch(Exception e) {
                out.println(e.getMessage());
            }
        } while(!this.idadeValidada);    
    }

    private void lerTipoTelefone() {
        do {
            try {
                out.print("Qual telefone quer informar, escolha uma opção: R = Residencial, C = Celular, T = Trabalho: ");
                this.tipoTelefone = this.ler.nextLine();
                this.pessoa.validarTipoTelefone(this.tipoTelefone);
                this.pessoa.setTipoTelefone(this.tipoTelefone);
                this.tipoTelefoneValidado = true;
            } catch(Exception Excecao) {
                out.println(Excecao.getMessage());
            }
        } while(!this.tipoTelefoneValidado);
    }

    private void lerTelefone() {
        do {
            try {
                out.print("Digite seu telefone:");
                this.telefone  = this.ler.nextLine();
                this.pessoa.validarTelefone(this.telefone);
                this.pessoa.setTelefone(this.telefone);
                this.telefoneValidado = true;
            } catch(Exception e) {
                out.println(e.getMessage());
            }
        } while(!this.telefoneValidado);    
    }
}