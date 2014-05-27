package jogodeserto;

import Exception.ForaPostoException;
import Exception.GameOverException;
import Exception.TanqueCheioException;

public class Caminhao {
    final int qtdMaxAbastecimento = 6;
    final String[] comandos = {"avançar","avancar", "voltar", "carregar", "descarregar"};
    
    private int qtdCombustivel;
    private int posicao = 0;
//    private int qtdCargas = 6;
    private String comandoUsuario;

    public Caminhao() {
        this.encherTanque();
    }

//    public int getQtdCargaCombustivel() {
//        return qtdCargas;
//    }

    public void setQtdCombustivel(int qtdCombustivel) {
        this.qtdCombustivel = qtdCombustivel;
    }

    public int getQtdCombustivel() {
        return qtdCombustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    private void encherTanque() {
        this.qtdCombustivel = this.qtdMaxAbastecimento;
    }

    private void verificarTanqueVazio() throws GameOverException {
        if (this.getQtdCombustivel() == 0)
            throw new GameOverException();
    }

    private void verificarSePodeAvancar() throws GameOverException {
        this.verificarTanqueVazio();
    }

    private void verificarSePodeVoltar() throws GameOverException, Exception {
        this.verificarTanqueVazio();
        if(this.posicao == 0) {
            throw new Exception("Ja esta no posto");
        }
    }

//    private void verificarTanqueCheio() throws TanqueCheioException {
//        if(this.getQtdCargaCombustivel() == this.qtdMaxAbastecimento)
//            throw new TanqueCheioException();
//        
//    }

//    private void verificarSeTaNoPosto() throws ForaPostoException {
//        if(this.posicao != 0) {
//            throw new ForaPostoException();
//        }
//    }

    private boolean validarComando(String comandoUsuario) throws Exception {
        for(String comando : this.comandos) {
            if(comando.equalsIgnoreCase(comandoUsuario)) {
                return true;
            }
        }
        throw new Exception("comando invalido");
    }

    private void validarSePodeExecutarComando() throws GameOverException, ForaPostoException, TanqueCheioException, Exception {
        switch(this.comandoUsuario) {
            case "avancar":
                this.verificarSePodeAvancar();
            break;
            case "voltar":
                this.verificarSePodeVoltar();
            break;
//            case "carregar":
//                this.verificarTanqueCheio();
//                this.verificarSeTaNoPosto();
//            break;
            case "descarregar":
                this.verificarTanqueVazio();
            break;
        }
    }

    public void executarComandoUsuario(String comando) throws Exception {System.out.println("teste");
        this.validarComando(comando);

        switch(comando.toLowerCase()) {
            case "avançar":
            case "avancar":
                this.comandoUsuario = "avancar";
                this.avancar();
            break;

            case "voltar":
                this.comandoUsuario = comando;
                this.voltar();
            break;

//            case "carregar":
//                this.comandoUsuario = comando;
//                this.carregar();
//            break;

            case "descarregar":
                this.comandoUsuario = comando;
                this.descarregar();
            break;
        }
    }
    
    private void avancar() throws Exception {
        this.validarSePodeExecutarComando();
        this.descarregar();
        this.posicao++;
//        this.qtdCargas = 0;
    }

    private void voltar() throws Exception {
        this.validarSePodeExecutarComando();
        this.descarregar();
        this.posicao--;
    }
    
//    private void carregar() throws Exception {
//        this.validarSePodeExecutarComando();
//        this.qtdCombustivel++;
//        this.qtdCargas++;
//    }
    
    private void descarregar() throws Exception {
        this.validarSePodeExecutarComando();
        this.qtdCombustivel--;
    }
}
