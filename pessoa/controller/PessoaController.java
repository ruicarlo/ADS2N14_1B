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
    

    public String gerarTelefoneAleatorioT2() {
        return (this.gerador.nextInt(1000-100)+100) + "-" + (this.gerador.nextInt(10000-1000)+1000);
    }
    
    public void gerarCadastroAleatorioT2() {
        String nomeAleatorio     = this.getNomeAleatorio() + " " + this.getSobrenomeAleatorio();
        String enderecoAleatorio = this.getEnderecoAleatorio();
        String telefoneAleatorio = this.gerarTelefoneAleatorioT2();

        this.pessoa.setNome(nomeAleatorio);
        this.pessoa.setTelefone(telefoneAleatorio);
        this.pessoa.setEndereco(enderecoAleatorio);              
        this.view.imprimeDadosPessoa(this.pessoa.getNome(), this.pessoa.getTelefone(), this.pessoa.getEndereco());
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

    private String getNomeAleatorio() {
        String nomes[] = {"MIGUEL","GABRIEL","LUCAS","GUSTAVO","FELIPE","ENZO","JOÃO PEDRO","CAUÃ","EDUARDO","HENRIQUE","VINICIUS","PIETRO","LEONARDO","HEITOR","ISAAC","THIAGO","JOÃO","BRUNO","CARLOS EDUARDO","BRENO","RYAN","YURI","ERICK","FERNANDO","ANDRÉ","LÍVIA","HELENA","LORENA","LARISSA","HELOISA","MELISSA","EDUARDA","REBECA","ALÍCIA","LAVÍNIA","ESTER","EMILY","CECÍLIA","PIETRA","MILENA","LAÍS","MARIA","CAMILA","ANA LAURA","MARIA VITÓRIA","OLIVIA","MIRELLA","STELLA","STEFANY","ISABEL"};
        int aleatorio = this.gerador.nextInt(nomes.length);
        return nomes[aleatorio]; 
    }

    private String getSobrenomeAleatorio() {
        String sobrenomes[] = {"ABROMOVIZT","ABROMOVIZT FILHO","ABUEEAR","AGUIAR","AHID","GASPAROTO","ALBERS","ALBERT","ALBERTON","ALBINO","ALENCAR","ALFARO","ALFLEN","ALLEIN","ALMEIDA","ALTENBURG","ALTHOFF","ALVES","ALVES PANTOJA","AMARAL","AMBRÓSIO","AMORIM","AMORIM NETO","ANDRADE","ANDRADE FILHO","AZAMBUJA","BACKES","BADO","BALDESSIN","BALTAZAR","BAPTISTA","BARBOSA","BARDEN","BARDINI","BARNI","BARRA","BARRETO","BARRETO FILHO","BARROS","BARTH","BARTHES","BASON","BASTOS","BATISTA","BAUMER","BAUNGARTEN","BAYER","BECHER","BIANCHINI","BIANKM"};
        int aleatorio = this.gerador.nextInt(sobrenomes.length);
        return sobrenomes[aleatorio];
    }

    private String getEnderecoAleatorio() {
        String enderecos[] = {"RUA MARQUÊS DO HERVAL","RUA DINARTE RIBEIRO","RUA ENGENHEIRO ÁLVARO NUNES PEREIRA","RUA SANTO INÁCIO","RUA BARÃO DE SANTO ÂNGELO","RUA LUCIANA DE ABREU","AVENIDA PROTÁSIO ALVES","AVENIDA IPIRANGA","AVENIDA WENCESLAU ESCOBAR"};
        int aleatorio = this.gerador.nextInt(enderecos.length);
        return enderecos[aleatorio] + ", " + this.gerador.nextInt(9999);
    }
}
