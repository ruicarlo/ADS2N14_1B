package model;

import Exception.SaldoInsuficienteException;

public class EspecialModel extends ContaModel {
    private double limite = 0;

    public EspecialModel(int numConta, int numVerificacao) throws Exception {
        super(numConta, numVerificacao);
    }

    public double getLimite() {
        return this.limite;
    }

    public void setLimite(double limite) throws Exception {
        this.validarLimite(limite);
        this.limite = limite;
    }

    private void validarLimite(double limite) throws Exception {
        if(limite < 0) {
            throw new Exception("Limite inválido.");
        }
    }

    protected void validarSaque(double valor) throws SaldoInsuficienteException {
        if(valor > (this.getSaldo() + this.getLimite())) {
            throw new SaldoInsuficienteException();
        }
    }
}
