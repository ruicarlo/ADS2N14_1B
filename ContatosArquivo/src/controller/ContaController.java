package controller;

import java.util.Random;

import model.ContaModel;
import model.EspecialModel;
import model.InvestimentoModel;
import view.ContaView;

public class ContaController {
    private ContaModel conta;
    private ContaView  view;
    
    public ContaController(char tipoConta, int numConta, int numVerificacao) throws Exception {
        this.view = new ContaView();
        this.criarConta( tipoConta, numConta, numVerificacao);
    }
    public void setSaldo(double saldo) throws Exception {
        this.conta.setSaldo(saldo);
    }
    public static char getTipoContaAleatorio() {
        Random gerador = new Random();
        char tipos[] = {'E','I','N'};
        return tipos[gerador.nextInt(tipos.length)];
    }
    
    public static int getNumeroContaAleatorio() {
        Random gerador = new Random();
        return gerador.nextInt(10000-1000)+1000;
    }

    public static int getNumeroVerificacaoAleatorio() {
        Random gerador = new Random();
        return gerador.nextInt(10);
    }
    
    public void criarConta(char tipoConta, int numConta, int numVerificacao) throws Exception {
        switch(tipoConta) {
            case 'I':
                this.conta = new InvestimentoModel(numConta, numVerificacao);
            break;
            case 'E':
                this.conta = new EspecialModel(numConta, numVerificacao);
                ((EspecialModel) this.conta).setLimite(1000);
            break;
            default:
                this.conta = new ContaModel(numConta, numVerificacao); 
        }
    }

    public int getNumeroConta() {
        return this.conta.getNumConta();
    }

    public int getNumeroVerificacao() {
        return this.conta.getNumVerificacao();
    }

    public boolean executarComando() throws Exception {
        char comando = Character.toUpperCase(this.view.lerComando());
        double valor;

        switch(comando) {
            case 'D':
                valor = this.view.lerValorSaqueDeposito();
                this.depositar(valor);
                this.conta.setUltimoMovimento(this.view.getMsgDadosDeposito(valor));
            break;
            case 'S':
                valor = this.view.lerValorSaqueDeposito();
                this.sacar(valor);
                this.conta.setUltimoMovimento(this.view.getMsgDadosSaque(valor));
            break;
            case 'I':
                double taxa = view.lerTaxaInvestimento();
                ((InvestimentoModel) this.conta).dividendos(taxa);
                this.conta.setUltimoMovimento(this.view.getMsgDadosInvestimento(taxa));
            break;
            case 'R':
                this.imprimirSaldo();
                this.conta.setUltimoMovimento(null);
            break;
            default:
                this.conta.setUltimoMovimento(null);
                return false;
        }
        return true;
    }

    public String getUltimoMovimento() {
        return this.conta.getUltimoMovimento();
    }

    public double getSaldo() {
        return this.conta.getSaldo();
    }

    public void imprimirSaldo() {
        this.view.imprimirSaldo(this.conta.getSaldo());
    }

    public void imprimirLimite() {
        this.view.imprimirLimite(((EspecialModel) this.conta).getLimite());
    }

    public void depositar(double valor) throws Exception {
        this.conta.depositar(valor);
    }

    public void sacar(double valor) throws Exception {
        this.conta.sacar(valor);
    }

    public String getDadosContaParaSalvarArquivo() {
        return String.format("%d##%d##%s##%f", this.conta.getNumConta(), this.conta.getNumVerificacao(), this.conta.getTipoConta(),this.conta.getSaldo());
    }
}