package com.senac.jogos;

public class Jogador {
	
    private int pontos;
    private String ultimoComando = "";
    
    public Jogador() {
        this.pontos = 0;
    }

    public int getPontos() {
        return pontos;
    }

    public String getUltimoComando() {
        return ultimoComando;
    }

    public void addPontos(int amount) {
        pontos += amount;
    }

    public void subtractPontos(int amount) {
        pontos -= amount;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setUltimoComando(String comando) {
        ultimoComando = comando;
    }
}