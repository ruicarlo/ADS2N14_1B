package jogodeserto;


public class JogoController {
    int[] combustivelPosicoes = new int[10];
    Posto posto = new Posto();
    Caminhao caminhao;
    
    public JogoController(Caminhao caminhao) {
        this.caminhao = caminhao;
    }
    
    public void descarregarCombustivelNaPosicao() throws Exception {
        this.caminhao.executarComandoUsuario("descarregar");
        this.combustivelPosicoes[this.caminhao.getPosicao()]++;
    }

    public int getQtdCombustivelPosicao() {
        return this.caminhao.getPosicao() == 0 ? this.caminhao.getTamanhoTanque() - this.caminhao.getQtdCombustivel(): this.combustivelPosicoes[this.caminhao.getPosicao()];
    }
    
    public void carregarCombustivelDaPosicao() throws Exception {
        int posicao = this.caminhao.getPosicao();
        if(this.combustivelPosicoes[posicao] < 1) {
            throw new Exception("Nao tem combustivel nesta posicao para carregar");
        }
        this.combustivelPosicoes[posicao]--;
        this.caminhao.adicionarQtdCombustivel();
    }
    public void jogar(String comando) throws Exception{
        switch(comando) {
            case "carregar":
                if(this.caminhao.getPosicao() == 0) {
                    this.posto.carregar(this.caminhao);
                } else {
                    carregarCombustivelDaPosicao();
                }
            break;
            case "descarregar":
                if(this.caminhao.getPosicao() > 0) {
                    if(this.caminhao.getQtdCombustivel() > 0) {
                        descarregarCombustivelNaPosicao();
                    } else {
                        throw new Exception("O caminhao não tem combustivel para descarregar");
                    }
                }
            break;
            default:
                this.caminhao.executarComandoUsuario(comando);
        }
    }

    public int getPosicaoCaminhao() {
       return this.caminhao.getPosicao(); 
    }

    public int getQtdCombustivelCaminhao() {
        return this.caminhao.getQtdCombustivel();
    }
}
