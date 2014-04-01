package controller;

import model.ContaModel;
import model.EspecialModel;
import view.ContaView;

public class ContaController {
    private ContaModel    contaNormal;
    private EspecialModel contaEspecial;
    private ContaView     view    = new ContaView();;
    private char          tpConta = 'N';

    
    public ContaController() throws Exception {
        this.criarConta();
    }
    private void criarConta() throws Exception {
        int numConta; 
        int numVerificacao;
        char tipoConta;

        this.view.imprimirSelecioneTipoConta();
        tipoConta = this.view.lerTipoConta().charAt(0);
        
        this.view.imprimirDigiteNumeroConta();
        numConta = this.view.lerNumeroConta();
        
        this.view.imprimirDigiteNumeroVerificacao();
        numVerificacao = this.view.lerNumeroVerificacao();
        
        switch(tipoConta) {
            case 'E':
                this.criarContaEspecial(numConta, numVerificacao);
                this.tpConta = 'E';
                break;
            default:
                this.criarContaNormal(numConta, numVerificacao);
                this.tpConta = 'N';
        }
    }

    private void criarContaEspecial(int numConta, int numVerificacao) throws Exception {
        this.contaEspecial = new EspecialModel(numConta, numVerificacao);
        this.contaEspecial.setLimite(1000);
    }

    private void criarContaNormal(int numConta, int numVerificacao) throws Exception {
        this.contaNormal = new ContaModel(numConta, numVerificacao);    
    }

    public void imprimirSaldo() {
        this.view.imprimirSaldo(this.getSaldo());
    }

    public void imprimirLimite() {
        this.view.imprimirLimite(this.contaEspecial.getLimite());
    }

    public void depositar(double valor) throws Exception {
        switch(tpConta) {
            case 'E':
                this.contaEspecial.depositar(valor);
            break;
            default:
                this.contaNormal.depositar(valor);
        }
        this.view.imprimirDadosDeposito(valor);
        this.imprimirSaldo();
    }

    public void sacar(double valor) throws Exception {
        switch(tpConta) {
            case 'E':
                this.contaEspecial.sacar(valor);
            break;
            default:
                this.contaNormal.sacar(valor);
        }
        this.view.imprimirDadosSaque(valor);
        this.imprimirSaldo();
    }

    public double getSaldo() {
        return tpConta == 'E' ? this.contaEspecial.getSaldo() : this.contaNormal.getSaldo();
    }
}