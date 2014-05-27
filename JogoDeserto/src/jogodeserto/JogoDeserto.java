package jogodeserto;

import Exception.GameOverException;
import view.View;

public class JogoDeserto {

    public static void main(String[] args) throws Exception {
        JogoController jogo = new JogoController();
        View view = new View();
        Caminhao caminhao = new Caminhao();
        Posto posto = new Posto();
        boolean comandoValidado = false;

        do {
            view.imprimirSelecioneComando();
            String comando = view.lerComando();
            try {
                if(comando.equals("carregar")) {
                    jogo.verificarSeTaNoPosto(caminhao.getPosicao());
                    posto.carregar(caminhao);
                } else if(comando.equals("avancar")){
                    posto.zerarQtdCargaCombustivel();
                }
                caminhao.executarComandoUsuario(comando);
                view.imprimirMsgAposComando(caminhao.getPosicao(), caminhao.getQtdCombustivel());
                
            } catch(GameOverException goe) {
                System.out.println(goe.getMessage());
                System.exit(0);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!comandoValidado);
    }
}
