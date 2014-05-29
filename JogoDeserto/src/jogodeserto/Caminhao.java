package jogodeserto;

import Exception.CaminhaoJaNoPostoException;
import Exception.ForaPostoException;
import Exception.GameOverException;
import Exception.TanqueCheioException;

public class Caminhao {
    final int qtdMaxAbastecimento = 6;
    final String[] comandos = {"avançar","avancar", "voltar", "carregar", "descarregar"};
    
    private int qtdCombustivel;
    private int posicao = 0;
    private String comandoUsuario;

    public int getTamanhoTanque() {
        return this.qtdMaxAbastecimento;
    }

    public void adicionarQtdCombustivel() throws TanqueCheioException {
        verificarTanqueCheio();
        this.qtdCombustivel++;
    }

    public int getQtdCombustivel() {
        return qtdCombustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    private void verificarTanqueCheio() throws TanqueCheioException {
        if (this.getQtdCombustivel() == qtdMaxAbastecimento)
            throw new TanqueCheioException();
    }

    private void verificarTanqueVazio() throws GameOverException {
        if (this.getQtdCombustivel() == 0)
            throw new GameOverException();
    }

    private void verificarSePodeAvancar() throws GameOverException {
        this.verificarTanqueVazio();
    }

    private void verificarSePodeVoltar() throws GameOverException, Exception {
        if(this.posicao == 0) {
            throw new CaminhaoJaNoPostoException();
        }
        this.verificarTanqueVazio();
    }

    private boolean validarComando(String comandoUsuario) throws Exception {
        for(String comando : this.comandos) {
            if(comando.equalsIgnoreCase(comandoUsuario)) {
                return true;
            }
        }
        throw new Exception("comando invalido");
    }

    private void validarSePodeExecutarComando() throws GameOverException, ForaPostoException, Exception {
        switch(this.comandoUsuario) {
            case "avancar":
                this.verificarSePodeAvancar();
            break;
            case "voltar":
                this.verificarSePodeVoltar();
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
    
    private void descarregar() throws Exception {
        this.validarSePodeExecutarComando();
        this.qtdCombustivel--;
    }
}
