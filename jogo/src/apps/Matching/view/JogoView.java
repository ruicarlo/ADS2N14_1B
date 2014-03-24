package com.senac.jogos.apps.Matching.view;

import java.util.Scanner;
import static java.lang.System.*;

public class JogoView {
    private static Scanner teclado = new Scanner(System.in);
    
    public String lerComando() {
        return teclado.nextLine();
    }
    
    public void imprimirCartaMesa(String cartaMesa) {
        out.println("Carta na mesa: " + cartaMesa);
    }

    public void imprimirSelecionarComando(int posicao) {
        out.print(String.format("Jogador %d. Digite 'jogar' para jogar, 'pular' para passar a vez: ", posicao));
    }

    public void imprimirCartaJogador(String cartaJogador) {
        out.println("Carta do jogador: " + cartaJogador);
    }

    public void imprimirPontosJogador(String pontosJogador) {
        out.println("Pontos do Jogador: " + pontosJogador);
    }
    
    public void imprimirMensagemComandoRepetido() {
        out.println("Você não pode pular novamente");
    }
}
