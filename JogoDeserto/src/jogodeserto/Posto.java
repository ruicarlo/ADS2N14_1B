package jogodeserto;

import Exception.TanqueCheioException;

public class Posto {
    
    final   int qtdMaxAbastecimento = 6;
    private int qtdCargas = 0;

    public int getQtdCargaCombustivel() {
        return qtdCargas;
    }

    private void verificarTanqueCheio() throws TanqueCheioException {
        if(this.getQtdCargaCombustivel() == this.qtdMaxAbastecimento)
            throw new TanqueCheioException();
    }
    
    public void carregar(Caminhao caminhao) throws Exception {
        this.verificarTanqueCheio();
        caminhao.setQtdCombustivel(caminhao.getQtdCombustivel()+1);
        this.qtdCargas++;
    }
}
