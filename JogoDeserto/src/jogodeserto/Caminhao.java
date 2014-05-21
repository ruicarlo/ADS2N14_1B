package jogodeserto;

public class Caminhao {
    final int qtdMaxCombustivel = 6;
    final String[] comandos = {"avançar","avancar", "voltar", "carregar", "descarregar"};
    
    private int qtdCombustivel = 0;
    private String comandoUsuario;
    
    public int getQtdCombustivel() {
        return qtdCombustivel;
    }

    public void setQtdCombustivel(int combustivel) {
        this.qtdCombustivel = combustivel;
    }

    public boolean verificarTanqueCheio() {
        return this.qtdCombustivel == this.qtdMaxCombustivel;
    }
    
    public void abastecer() throws Exception {
        if(verificarTanqueCheio()) {
            throw new Exception("o caminhao ja esta com o tanque cheio");
        }
        this.qtdCombustivel++;
    }

    public boolean validarComando(String comandoUsuario) throws Exception {
        for(String comando : this.comandos) {
            if(comando.equalsIgnoreCase(comandoUsuario)) {
                return true;
            }
        }
        throw new Exception("comando invalido");
    }

    private void setComandoUsuario(String comando) {
        switch(comando.toLowerCase()) {
            case "avançar":
                this.comandoUsuario = "avancar";
            break;
            default:
                this.comandoUsuario = comando;
        }
    }
}
