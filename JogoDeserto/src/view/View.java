package view;

import java.util.Scanner;
import java.util.InputMismatchException;

public class View {
    Scanner ler;

    public View() {
        this.setLer();
    }

    private void setLer() {
        this.ler = new Scanner(System.in);
    }

    public void imprimirSelecioneComando() {
        System.out.print("Selecione um comando (avancar, voltar, descarregar, carregar): ");
    }

    public String lerComando() {
        return this.ler.next();
    }

    public void imprimirMsgAposComando(int posicao, int combustivel) {
        System.out.println(getMsgAposComando(posicao, combustivel));
    }

    public String getMsgAposComando(int posicao, int combustivel) {
        return String.format("Posicao: %d. Combustivel: %d.", posicao, combustivel);
    }
}