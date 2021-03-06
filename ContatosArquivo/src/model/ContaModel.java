package model;

import Exception.SaldoInsuficienteException;

public class ContaModel {
    private double saldo = 0;
    private int    numConta;
    private int    numVerificacao;
    private String ultimoMovimento;

    public String getUltimoMovimento() {
        return ultimoMovimento;
    }

    public void setUltimoMovimento(String ultimoMovimento) {
        this.ultimoMovimento = ultimoMovimento;
    }

    public ContaModel(int numConta, int numVerificacao) throws Exception {
        this.setNumConta(numConta);
        this.setNumVerificacao(numVerificacao);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) throws Exception {
        this.saldo = saldo;
    }

    public int getNumConta() {
        return this.numConta;
    }

    private void setNumConta(int numConta) throws Exception {
        this.validarNumConta(numConta);
        this.numConta = numConta;
    }

    public int getNumVerificacao() {
        return this.numVerificacao;
    }

    private void setNumVerificacao(int numVerificacao) throws Exception {
        this.validarNumVerificacao(numVerificacao);
        this.numVerificacao = numVerificacao;
    }

    private void validarNumConta(int numConta) throws Exception {
        if(numConta < 1) {
            throw new Exception("Numero de conta inv�lido.");
        }
    }

    public void validarNumVerificacao(int numVerificacao) throws Exception {
        if(numVerificacao < 0) {
            throw new Exception("Numero de verificacao invalido.");
        }
    }

    protected void validarSaque(double valor) throws SaldoInsuficienteException {
        if(valor > this.saldo) {
            throw new SaldoInsuficienteException();
        }
    }
    
    public void sacar(double valor) throws Exception {
        this.validarValorSaque(valor);
        this.validarSaque(valor);
        this.setSaldo(this.saldo - valor);
    }

    private void validarValorSaque(double valor) throws Exception {
        if(valor <= 0) {
            throw new Exception("Valor invalido para saque.");
        }
    }
    
    public void depositar(double valor) throws Exception {
        this.validarValorDeposito(valor);
        this.setSaldo(this.saldo + valor);
    }

    private void validarValorDeposito(double valor) throws Exception {
        if(valor <= 0) {
            throw new Exception("Valor invalido para dep�sito.");
        }
    }

    public char getTipoConta() {
        return 'N';
    }
}
