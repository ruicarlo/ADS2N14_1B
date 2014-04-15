package controller;

import java.io.*;
import view.PessoaView;

import java.util.Random;

public class PessoaController {
    private String nomeArquivoContatos = "src/contatos.txt";
    private String nomeArquivoContas   = "src/contas.txt";
    private PessoaView view = new PessoaView();
    private Random gerador = new Random();
   
    public String gerarCadastroAleatorio() {
        String nomeAleatorio     = this.getNomeCompletoAleatorio();
        String enderecoAleatorio = this.getEnderecoAleatorio();
        String telefoneAleatorio = this.getTelefoneAleatorio();

        return this.view.getDadosPessoaFormatado(nomeAleatorio, telefoneAleatorio, enderecoAleatorio);
    }

    private String getTelefoneAleatorio() {
        return (this.gerador.nextInt(1000-100)+100) + "-" + (this.gerador.nextInt(10000-1000)+1000);
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

    private String getNomeCompletoAleatorio() {
        return this.getNomeAleatorio() + " " + this.getSobrenomeAleatorio();
    }
 
    private String getEnderecoAleatorio() {
        String enderecos[] = {"RUA MARQUÊS DO HERVAL","RUA DINARTE RIBEIRO","RUA ENGENHEIRO ÁLVARO NUNES PEREIRA","RUA SANTO INÁCIO","RUA BARÃO DE SANTO ÂNGELO","RUA LUCIANA DE ABREU","AVENIDA PROTÁSIO ALVES","AVENIDA IPIRANGA","AVENIDA WENCESLAU ESCOBAR"};
        int aleatorio = this.gerador.nextInt(enderecos.length);
        return enderecos[aleatorio] + ", " + this.gerador.nextInt(9999);
    }

    public void armazenarPessoaNoArquivo(int numeroPessoas) {
        File f = new File(this.nomeArquivoContatos);
        if(f.exists()) {
            return;
        }

        DataOutputStream out = null;
        try {
            out = new DataOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream(this.nomeArquivoContatos)
                )
            );

            for(int i = 0; i < numeroPessoas; i++) {
                out.writeUTF(this.gerarCadastroAleatorio()+"\n");
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void armazenarContasNoArquivo(int numeroPessoas) {
        File f = new File(this.nomeArquivoContas);
        if(f.exists()) {
            return;
        }

        DataOutputStream out = null;
        try {
            out = new DataOutputStream(
                new BufferedOutputStream(
                    new FileOutputStream(this.nomeArquivoContas)
                )
            );

            for(int i = 0; i < numeroPessoas; i++) {
                out.writeUTF(this.gerarCadastroAleatorio()+"\n");
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String[] lerPessoasDoArquivo() {
        DataInputStream in = null;
        String[] pessoas = {};
        try {
            in = new DataInputStream(
                new BufferedInputStream(
                    new FileInputStream(this.nomeArquivoContatos)
                )
            );
            String s = in.readUTF();
            System.out.println(s);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return pessoas;
    }
}