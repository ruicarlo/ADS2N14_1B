package jogodeserto;

public class Caminhao {
    final int qtdMaxCombustivel = 6;
    final String[] comandos = {"avançar","avancar", "voltar", "carregar", "descarregar"};
    
    private int qtdCombustivel = 0;
    private int posicao = 0;
    private String comandoUsuario;

    public int getQtdCombustivel() {
        return qtdCombustivel;
    }

    public int getPosicao() {
        return posicao;
    }

    private boolean verificarTanqueVazio() {
        return this.getQtdCombustivel() == 0;
    }

    private boolean verificarTanqueCheio() {
        return this.getQtdCombustivel() == this.qtdMaxCombustivel;
    }

    private boolean validarComando(String comandoUsuario) throws Exception {
        for(String comando : this.comandos) {
            if(comando.equalsIgnoreCase(comandoUsuario)) {
                return true;
            }
        }
        throw new Exception("comando invalido");
    }

    private void validarSePodeExecutarComando() throws Exception {
        switch(this.comandoUsuario) {
            case "avancar":
                if(verificarTanqueVazio()) {
                    throw new Exception("o caminhao nao tem combustivel para avancar");
                }
            break;
            case "voltar":
                if(verificarTanqueVazio()) {
                    throw new Exception("o caminhao nao tem combustivel para voltar");
                }
            break;
            case "carregar":
                if(verificarTanqueCheio()) {
                    throw new Exception("o caminhao ja esta com o tanque cheio");
                } else if(this.posicao != 0) {
                    throw new Exception("o caminhao nao pode abastecer fora do posto");
                }
            break;
            case "descarregar":
                if(verificarTanqueVazio()) {
                    throw new Exception("o caminhao ja esta sem combustivel");
                }
            break;
        }
    }

    public void setComandoUsuario(String comando) throws Exception {
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
