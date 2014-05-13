package pilhas;

import Exceptions.*;
import estruturas.Stack;

public class Pilhas {

    public static void main(String[] args) {
        imprimirPalindromo("ovo");
        
        imprimirConversoesBinarias();
        
        /*
        try{ 
            calcularExpressaoPosFixa calc = new calcularExpressaoPosFixa();
            calc.calcularExpressaoPosFixa("3 1 + 2 * 1 2 + /");
        }catch(Exception e){}
        */ 
    }
    static void imprimirPalindromo(String texto) {
        if(testarPalindromo(texto)) {
            System.out.println(texto+" eh um palidromo");
        } else {
            System.out.println(texto+" nao eh um palidromo");
        }
    }
    
    static void imprimirConversoesBinarias() {
        int[] numerosDecimais = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 16, 20, 500000};
        for(int numero : numerosDecimais) {
            System.out.println(String.format("%d: %s", numero,
                                                       converterBinario(numero))
            );
        }
    }

    static String converterBinario(int numeroDecimal) {
        Stack<Integer> pilha = new Stack(15, true);
        int divisao = numeroDecimal;
        try {
            while(divisao > 0) {
                pilha.push(divisao%2);
                divisao = (int) divisao/2;
            }

            StringBuilder binario = new StringBuilder(pilha.size());
            while(!pilha.isEmpty()) {
                binario.append(pilha.pop());
            }
            return binario.toString();
        } catch(StackException e) {
            return null;
        }
    }

    static boolean testarPalindromo(String texto) {
        Stack<Character> pilha = new Stack(15, true);
        StringBuilder textoPilha = new StringBuilder(texto.length());

        try {
            for (int i = 0; i < texto.length(); i++) {
                pilha.push(texto.charAt(i));
            }

            while(!pilha.isEmpty()) {
                textoPilha.append(pilha.pop());
            }
        } catch(StackException e) {
        }
            return textoPilha.toString().equals(texto);
    }


}
