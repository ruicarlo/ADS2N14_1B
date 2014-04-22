package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import view.PessoaView;

public class PessoaController {
    final String nomeArquivoContatos = "src/contatos.txt";
    final String nomeArquivoContas   = "src/contas.txt";
    final String nomeArquivoExtrato  = "src/movimentos.txt";
    
    final Random gerador = new Random();
    private PessoaView view = new PessoaView();
    private ArrayList<Integer> contasUtilizadas =  new ArrayList();
    private ArrayList<String> movimentos = new ArrayList();

    public String gerarCadastroAleatorio() {
        String nome     = this.getNomeCompletoAleatorio();
        String endereco = this.getEnderecoAleatorio();
        String telefone = this.getTelefoneAleatorio();
        return String.format("%s##%s##%s", nome, endereco, telefone);
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

    public String[] getContatosArquivo() {
        return new ArquivosController(this.nomeArquivoContatos).getRegistros();
    }

    public String[] getContasArquivo() {
        return new ArquivosController(this.nomeArquivoContas).getRegistros();
    }

    public void adicionarMovimento(String movimento) {
        this.movimentos.add(movimento);
    }

    public ContaController[] getContaPessoas(int numeroContas) throws Exception {
        ContaController[] contas = new ContaController[numeroContas];
        ArquivosController arquivo = new ArquivosController(this.nomeArquivoContas);
        if(arquivo.verificarSeExiste()) {
            String[] contasArquivo = this.getContasArquivo();
            String dados[];
            for(int i=0; i < contasArquivo.length; i++){
                dados = contasArquivo[i].split("##");
                contas[i] = new ContaController(dados[2].charAt(0), Integer.parseInt(dados[0]), Integer.parseInt(dados[1]));
                contas[i].setSaldo(Double.parseDouble(dados[3].replaceAll(",", ".")));
            }
            return contas;
        }else {
            contas = this.cadastrarContaPessoas(numeroContas);
            this.armazenarContasNoArquivo(contas);
            return contas;
        }
    }

    public ContaController[] cadastrarContaPessoas(int numeroContas) throws Exception {
        ContaController[] contas = new ContaController[numeroContas];

        for (int i=0; i < numeroContas; i++) {
            try {
                boolean validada = false;
                char tipoConta     = Character.toUpperCase(ContaController.getTipoContaAleatorio());
                int numConta       = ContaController.getNumeroContaAleatorio();
                int numVerificacao = ContaController.getNumeroVerificacaoAleatorio();
                do {
                    if(!this.contasUtilizadas.contains(numConta)) {
                        this.contasUtilizadas.add(numConta);
                        contas[i] = new ContaController(tipoConta, numConta, numVerificacao);
                        validada = true;
                    }
                } while(!validada);
            } catch(Exception e) {
                throw new Exception (String.format("Erro ao criar contas para os contatos: %s", e.getMessage()));
            }
        }
        return contas;
    }

    public void armazenarPessoaNoArquivo(int numeroPessoas) {
        ArquivosController arquivo = new ArquivosController(this.nomeArquivoContatos);
        if(arquivo.verificarSeExiste()) {
            return;
        }

        String[] conteudo = new String[numeroPessoas];
        for(int i = 0; i < numeroPessoas; i++) {
            conteudo[i] = this.gerarCadastroAleatorio();
        }

        arquivo.escrever(conteudo, true);
    }

    public void armazenarContasNoArquivo(ContaController[] contas) {
        ArquivosController arquivo = new ArquivosController(this.nomeArquivoContas);

        String[] conteudo = new String[contas.length];
        for(int i = 0; i < contas.length; i++) {
            conteudo[i] = contas[i].getDadosContaParaSalvarArquivo();
        }

        arquivo.escrever(conteudo, true);
    }

    public void armazenarMovimentosNoArquivo() {
        ArquivosController arquivo = new ArquivosController(this.nomeArquivoExtrato);

        String[] conteudo = new String[this.movimentos.size()];        
        for(int i = 0; i < this.movimentos.size(); i++) {
            conteudo[i] = this.movimentos.get(i);
        }

        arquivo.escrever(conteudo, false);
    }   

    private Object ArquivosController(String nomeArquivoContatos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}