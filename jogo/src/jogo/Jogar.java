package jogo;

import apps.Matching.controller.JogoController;

public class Jogar {
    public static void main(String[] args) {
        JogoController controller = new JogoController();
        controller.iniciarJogo();
        do {    
            controller.jogada();
        } while(controller.verificarSeTemCarta());
        controller.decretarGanhador();
    }
    
}
