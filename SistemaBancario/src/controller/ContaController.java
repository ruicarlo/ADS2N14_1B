package controller;

import model.ContaModel;
import model.EspecialModel;
import model.InvestimentoModel;
import view.ContaView;

public class ContaController {
    private ContaModel conta;
    private ContaView  view;
    
    public ContaController() throws Exception {
        this.view = new ContaView();
        this.criarConta();
    }

    private void criarConta() throws Exception {
        char tipoConta     = Character.toUpperCase(this.view.lerTipoConta());
        int numConta       = this.view.lerNumeroConta();
        int numVerificacao = this.view.lerNumeroVerificacao();
        
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

    public boolean executarComando() throws Exception {
        char comando = Character.toUpperCase(this.view.lerComando());
        double valor = 0;
        

        switch(comando) {
            case 'D':
                valor = this.view.lerValorSaqueDeposito();
                this.depositar(valor);
                this.view.imprimirDadosDeposito(valor);
            break;
            case 'S':
                valor = this.view.lerValorSaqueDeposito();
                this.sacar(valor);
                this.view.imprimirDadosSaque(valor);
            break;
            case 'I':
                double taxa = view.lerTaxaInvestimento();
                ((InvestimentoModel) this.conta).dividendos(taxa);
            break;
            case 'R':
                this.imprimirSaldo();
            break;
            default:    
                return false;
        }
        return true;
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
}