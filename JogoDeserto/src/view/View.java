package view;

import java.util.Scanner;

public class View {
    Scanner ler;

    public View() {
        this.setLer();
    }

    public void imprimirParabens(){
        System.out.println("parabens");
    }

    private void setLer() {
        this.ler = new Scanner(System.in);
    }

    public void imprimirSelecioneComando() {
        System.out.print("Selecione um comando (avancar, voltar, descarregar, carregar): ");
    }

    public String lerComando() {
        return this.ler.next().toLowerCase();
    }

    public void imprimirMsgAposComando(int posicao, int combustivelTanque, int combustivelPosicao) {
        System.out.println(getMsgAposComando(posicao, combustivelTanque, combustivelPosicao));
    }

    public String getMsgAposComando(int posicao, int combustivelTanque, int combustivelPosicao) {
        return String.format("Posicao: %d. Combustivel no Tanque: %d. Combustivel no Tanque: %d.", posicao, combustivelTanque, combustivelPosicao);
    }
}