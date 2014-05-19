package pilhas;

import Exceptions.*;
import estruturas.Stack;

public class Pilhas {

    public static void main(String[] args) {
        imprimirPalindromo("ovo");
        imprimirConversoesBinarias();
        imprimirInFixa();
    }

    static void imprimirInFixa() {
        InFixa calcI;
        PosFixa calcP;

        String[] a = {
                      "3 + 4 * 2",
                      "( 5 + 3 ) * 12 / 3",
                      "3 - 2",
                      "3 * 2 + 5",
                      "( 12 - 3 ) / 3",
                      "5 + 2 ^ 3",
                      "3 * 2 - 11",
                      "2 + 1 - 12 / 3",
                      "( 6 - 3 - 3 - 3 ) ^ 2 - 11",
                      "6 - 3 ^ 2 - 11",
                      "128 / ( 2 + 1 ) ^ 4"
        };

        for(String b:a) {
            calcI = new InFixa(b);
            String convertida = calcI.converter();
            try { 
                calcP = new PosFixa(convertida);
                System.out.println(String.format("A expressao "+b+"  foi convertida para "+convertida+". O resultado final da expressao eh: %1$,.2f", calcP.calcular()));
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void imprimirPalindromo(String texto) {
        if(testarPalindromo(texto)) {
            System.out.println(texto+" eh um palidromo");
        } else {
            System.out.println(texto+" nao eh um palidromo");
        }
    }
    
    static void imprimirConversoesBinarias() {
        int[] numerosDecimais = {1, 2, 3, 4, 5, 10, 16, 20, 50};
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
