package Exception;

public class GameOverException extends Exception {
    public GameOverException() {
        super("Sem Combustivel\nGame Over.");
    }
}
