package controller;

import view.PessoaView;


import model.Pessoa;
import java.util.Random;

public class PessoaController {

    private Pessoa pessoa = new Pessoa();
    private PessoaView view = new PessoaView();
    private Random gerador = new Random();

    

    public String gerarTelefoneAleatorio() {
        return (this.gerador.nextInt(1000-100)+100) + "-" + (this.gerador.nextInt(10000-1000)+1000);
    }
    
    public void gerarCadastroAleatorio() {
        String nomeAleatorio     = this.getNomeAleatorio() + " " + this.getSobrenomeAleatorio();
        String enderecoAleatorio = this.getEnderecoAleatorio();
        String telefoneAleatorio = this.gerarTelefoneAleatorio();

        this.pessoa.setNome(nomeAleatorio);
        this.pessoa.setTelefone(telefoneAleatorio);
        this.pessoa.setEndereco(enderecoAleatorio);              
        this.view.imprimeDadosPessoa(this.pessoa.getNome(), this.pessoa.getTelefone(), this.pessoa.getEndereco());
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
