package Exception;

public class CaminhaoJaNoPostoException extends Exception {
    public CaminhaoJaNoPostoException() {
        super("O caminhao ja esta no posto.");
    }
}
