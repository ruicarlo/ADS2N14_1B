package controller;

import model.ContaModel;
import model.EspecialModel;
import view.ContaView;

public class ContaController {
    private ContaModel conta;
    private EspecialModel especial;
    private ContaView  view = new ContaView();;

    
    public ContaController(int numConta, int numVerificacao) throws Exception {
        //this.conta = new ContaModel(1234,5);
        this.especial = new EspecialModel(numConta, numVerificacao, 1000);
        this.especial.depositar(5000);
    }

    public void imprimirSaldo() {
        this.view.imprimirSaldo(this.especial.getSaldo());
    }

    public void imprimirLimite() {
        this.view.imprimirLimite(this.especial.getLimite());
    }

    public void sacar(double valor) throws Exception {
        this.especial.sacar(valor);
    }

}