package com.senac.jogos.apps.Matching.model;

import com.senac.jogos.Jogador;
import com.senac.jogos.cartas.Baralho;
import com.senac.jogos.cartas.Carta;

public class MatchingCardGame {
    private Baralho baralho;
    private Jogador[] jogador = new Jogador[4];
    private Carta mesa;

    public MatchingCardGame() {
        baralho = new Baralho();
        mesa = baralho.drawCarta();
        iniciarJogadores();
    }

    private void iniciarJogadores() {
        for(int i=0;i<jogador.length;i++) {
            jogador[i]=new Jogador();
        }
    }

    public int getNumeroJogadores() {
        return jogador.length;
    }

    public boolean verificarSeTemCarta() {
        return baralho.verificarSeTemCarta();
    }

    public int matchCarta(Carta carta) {
        if (carta.getValor() == mesa.getValor()) {
            return 4;
        } else if (carta.getNaipe() == mesa.getNaipe()) {
            return 1;
        } else {
            return -2;
        }
    }

    public void setMesa(Carta carta) {
        mesa = carta;
    }

    public Carta getMesa() {
        return mesa;
    }

    public Carta drawCarta() {
        return baralho.drawCarta();
    }
    
    public Jogador getJogador(int posicaoJogador) {
        return jogador[posicaoJogador];
    }
    
    public int[] getGanhador() {
        int posicaoGanhador = 0;
        int pontosGanhador = getJogador(0).getPontos();
        int pontos;
        
        for (int posicao = 0; posicao < getNumeroJogadores(); posicao++) {
            pontos = getJogador(posicao).getPontos();
            System.out.println("posicao: "+posicao+" pontos: "+pontos);
            if ( pontos > pontosGanhador) {
                pontosGanhador  = pontos;
                posicaoGanhador = posicao;
            }
        }
        int[] ganhador = {posicaoGanhador, pontosGanhador};
        return ganhador;
    }
}