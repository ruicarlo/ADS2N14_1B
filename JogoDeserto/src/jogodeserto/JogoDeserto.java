package jogodeserto;

import Exception.GameOverException;
import view.View;

public class JogoDeserto {

    public static void main(String[] args) throws Exception {
        View view = new View();
        Caminhao caminhao = new Caminhao();
        
        view.imprimirSelecioneComando();
        String comando = view.lerComando();
        try {
            caminhao.executarComandoUsuario("descarregar");
            caminhao.executarComandoUsuario("descarregar");
            caminhao.executarComandoUsuario("descarregar");
            caminhao.executarComandoUsuario("descarregar");
            caminhao.executarComandoUsuario("descarregar");
            caminhao.executarComandoUsuario("descarregar");
            caminhao.executarComandoUsuario(comando);
        } catch(GameOverException goe) {
            System.out.println(goe.getMessage());
            System.exit(0);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        view.imprimirMsgAposComando(caminhao.getPosicao(), caminhao.getQtdCombustivel());
        
    }
}
