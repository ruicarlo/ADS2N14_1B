package model;

import Exception.SaldoInsuficienteException;

public class EspecialModel extends ContaModel {
    private double limite;

    public EspecialModel(int numConta, int numVerificacao, double limite) throws Exception {
        super(numConta, numVerificacao);
        this.setLimite(limite);
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
