package jogodeserto;

public class Caminhao {
    final int qtdMaxCombustivel = 6;

    private int qtdCombustivel = 0;
    
    public int getQtdCombustivel() {
        return qtdCombustivel;
    }

    public void setQtdCombustivel(int combustivel) {
        this.qtdCombustivel = combustivel;
    }

    public boolean verificaTanqueCheio() {
        return this.qtdCombustivel == this.qtdMaxCombustivel;
    }
    
    public void abastecer() throws Exception {
        if(verificaTanqueCheio()) {
            throw new Exception("o caminhao ja esta com o tanque cheio");
        }
        this.qtdCombustivel++;
    }
}
