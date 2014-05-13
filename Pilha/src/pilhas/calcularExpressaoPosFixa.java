package pilhas;

import Exceptions.StackException;
import estruturas.Stack;

public class calcularExpressaoPosFixa {
    Stack<Integer> pilha = new Stack(15, true);
    
    int calcularExpressaoPosFixa(String expressao) throws Exception {
        try {
            for (int i = 0; i < expressao.length(); i++) {
                char caracter = expressao.charAt(i);
                if (Character.isDigit(caracter)) {
                    System.out.println("é um numero: " + Character.getNumericValue(caracter));
                    pilha.push(Character.getNumericValue(caracter));
                } else if(!Character.isSpaceChar(caracter)) {
                    if(!verificarOperador(caracter)) {
                        throw new Exception("Operador invalido");
                    }
                    pilha.push(calcularValor(caracter));
                }
            }
        }catch (StackException e) {
            //“3 11 + 2 * 1 2 + /” 
            //• Enquanto houverem elementos na entrada: 
            //• Se for um número, insira na pilha. 
            //• Se for um operador, retire dois elementos da 
            //pilha, execute a operação e empilhe o resultado. 
            System.out.println(e.getMessage());
        }
        return 0;
    }

    private boolean verificarOperador(char operador) {
        return operador == '+' || operador == '-'||operador == '*'||operador == '/';
    }

    private int calcularValor(char operador) throws StackException {
        int resultado = 0;
        try {
            int numeroDireita  = pilha.pop();
            int numeroEsquerda = pilha.pop();
            switch(operador) {
                case '+':
                    resultado = numeroEsquerda + numeroDireita;
                break;
                case '-':
                    resultado = numeroEsquerda - numeroDireita;
                break;
                case '*':
                    resultado = numeroEsquerda * numeroDireita;
                break;
                case '/':
                    resultado = numeroEsquerda / numeroDireita;
                break;
            }
            System.out.println(String.format("%d %c %d = %d", numeroEsquerda, operador, numeroDireita, resultado));
        } catch(StackException e) {}
        return resultado;
    }
}
