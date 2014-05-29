package jogodeserto;

import Exception.GameOverException;
import view.View;

public class JogoDeserto {

    public static void main(String[] args) throws Exception {
        View view = new View();
        JogoController jogo = new JogoController(new Caminhao());
       
        boolean comandoValidado = false;

        do {
            view.imprimirSelecioneComando();
            String comando = view.lerComando();
            try {
                jogo.jogar(comando);
                view.imprimirMsgAposComando(jogo.getPosicaoCaminhao(), jogo.getQtdCombustivelCaminhao(), jogo.getQtdCombustivelPosicao());
            } catch(GameOverException goe) {
                System.out.println(goe.getMessage());
                System.exit(0);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!comandoValidado);
    }
}
