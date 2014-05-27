package jogodeserto;

import Exception.ForaPostoException;

public class JogoController {
    public void verificarSeTaNoPosto(int posicao) throws ForaPostoException {
        if(posicao != 0) {
            throw new ForaPostoException();
        }
    }    
}
