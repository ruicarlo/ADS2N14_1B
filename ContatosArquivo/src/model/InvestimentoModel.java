package model;

public class InvestimentoModel extends ContaModel {
    int dataAplicacao;

    public InvestimentoModel(int numConta, int numVerificacao) throws Exception {
        super(numConta, numVerificacao);
    }

    public void dividendos(double taxa) throws Exception {
        double dividendos = this.getSaldo() * (taxa/100);
        this.setSaldo(this.getSaldo() + dividendos);
    }
        
    public char getTipoConta() {
        return 'I';
    }
}
