package jogodeserto;

import Exception.ForaPostoException;
import Exception.GameOverException;
import Exception.TanqueCheioException;

public class Caminhao {
    final int qtdMaxCombustivel = 6;
    final String[] comandos = {"avançar","avancar", "voltar", "carregar", "descarregar"};
    
    private int qtdCombustivel = 0;
    private int posicao = 0;
    private String comandoUsuario;

    public Caminhao() {
        this.encherTanque();
    }

    public int getQtdCombustivel() {
        return qtdCombustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    private void encherTanque() {
        this.qtdCombustivel = this.qtdMaxCombustivel;
    }

    private void verificarTanqueVazio() throws GameOverException{
        if (this.getQtdCombustivel() == 0)
            throw new GameOverException();
    }
    private void verificarSePodeAvancarVoltar() throws GameOverException {
        this.verificarTanqueVazio();
    }

    private void verificarTanqueCheio() throws TanqueCheioException {
        if(this.getQtdCombustivel() == this.qtdMaxCombustivel)
            throw new TanqueCheioException();
        
    }

    private void verificarSePodeCarregar() throws ForaPostoException {
        if(this.posicao != 0) {
            throw new ForaPostoException();
        }
    }

    private boolean validarComando(String comandoUsuario) throws Exception {
        for(String comando : this.comandos) {
            if(comando.equalsIgnoreCase(comandoUsuario)) {
                return true;
            }
        }
        throw new Exception("comando invalido");
    }

    private void validarSePodeExecutarComando() throws GameOverException, ForaPostoException, TanqueCheioException {
        switch(this.comandoUsuario) {
            case "avancar":
            case "voltar":
                this.verificarSePodeAvancarVoltar();
            break;
            case "carregar":
                this.verificarTanqueCheio();
                this.verificarSePodeCarregar();
            break;
            case "descarregar":
                this.verificarTanqueVazio();
            break;
        }
    }

    public void executarComandoUsuario(String comando) throws Exception {
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

            case "carregar":
                this.comandoUsuario = comando;
                this.carregar();
            break;

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
    }

    private void voltar() throws Exception {
        this.validarSePodeExecutarComando();
        this.descarregar();
        this.posicao--;
    }
    
    private void carregar() throws Exception {
        this.validarSePodeExecutarComando();
        this.qtdCombustivel++;
    }
    
    private void descarregar() throws Exception {
        this.validarSePodeExecutarComando();
        this.qtdCombustivel--;
    }
}
