package com.senac.jogos.apps.Matching.controller;

import com.senac.jogos.apps.Matching.model.MatchingCardGame;
import com.senac.jogos.apps.Matching.view.JogoView;
import com.senac.jogos.cartas.Carta;

public class JogoController {

    private MatchingCardGame jogo;
    private Carta cartaJogador;
    private JogoView view;
    
    private int posicaoJogador = 0;
	
    public JogoController()	{
        jogo = new MatchingCardGame();
        view = new JogoView();
        cartaJogador = null;
    }
    
    public void setPosicaoJogador(int posicao) {
        if(posicao >= jogo.getNumeroJogadores() || posicao < 0) {
            posicaoJogador = 0;
        } else {
            posicaoJogador = posicao;
        }
    }
    
    public void iniciarJogo() {
        view.imprimirCartaMesa(showMesa());
    }

    public boolean verificarSeTemCarta() {
        return jogo.verificarSeTemCarta();
    }

    public void jogada() {
        view.imprimirSelecionarComando(posicaoJogador+1);
        String comando = view.lerComando();
        if(executarComandoJogador(comando)) {
            if(cartaJogador != null) {
                view.imprimirCartaJogador(showCarta(cartaJogador));
            }
            view.imprimirPontosJogador(showJogador());
        } else {
            view.imprimirMensagemComandoRepetido();
        }
    }

    public void pularVezJogador() {
        jogo.getJogador(posicaoJogador).subtractPontos(10);
    }

    public void playTurno() {
        int pontos = jogo.matchCarta(cartaJogador);
        jogo.getJogador(posicaoJogador).addPontos(pontos);
        jogo.setMesa(cartaJogador);
    }
    
    public String showJogador() {
        return String.format("Pontos: %d", jogo.getJogador(posicaoJogador).getPontos());
    }
	
    private String showCarta(Carta carta) {
        return String.format("%d%c", carta.getValor(), carta.getNaipe());
    }

    public String showMesa() {
        return showCarta(jogo.getMesa());
    }
	
    public void setCartaJogador() {
        cartaJogador = jogo.drawCarta();
        playTurno();
    }

    public boolean executarComandoJogador(String comando) {
        comando = comando.equalsIgnoreCase("JOGAR") ? "JOGAR" : "PULAR";
        setPosicaoJogador(posicaoJogador+1);
        
        if(comando.equals("PULAR") && jogo.getJogador(posicaoJogador).getUltimoComando().equals("PULAR")) {
            setPosicaoJogador(posicaoJogador-1);
            return false;
        } else if(comando.equalsIgnoreCase("JOGAR")) {
            this.setCartaJogador();
        } else {
            this.pularVezJogador();
        }
        jogo.getJogador(posicaoJogador).setUltimoComando(comando);
        return true;
    }
            
}
