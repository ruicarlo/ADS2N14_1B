package pilhas;

import Exceptions.StackException;
import estruturas.Stack;
import java.util.StringTokenizer;

public class PosFixa {
    Stack<Double> pilha = new Stack(15, true);
    String expressao;

    public PosFixa(String expressao) {
        this.expressao = expressao;
    }

    public double calcular() {
        try {
            empilhar();
        }catch(Exception e) {
            System.out.println("Erro:" + e.getMessage());
        }
        return pilha.peek();
    }

    private void empilhar() throws Exception {
        StringTokenizer st = new StringTokenizer(this.expressao);
        while (st.hasMoreTokens()) {
            String item = st.nextToken();
            if(validarOperador(item)) {
                double resultado = calcularValor(item.charAt(0));
                pilha.push(resultado);
            } else {
                pilha.push(Double.parseDouble(item));
            }
        }
    }

    private boolean validarOperador(String operador) {
        return operador.equals("+") || operador.equals("-") || operador.equals("*") || operador.equals("/") || operador.equals("^");
    }

    private double calcularValor(char operador) throws StackException {
        double resultado = 0.0;
        double numeroDireita  = pilha.pop();
        double numeroEsquerda = pilha.pop();
        switch(operador) {
            case '+': resultado = numeroEsquerda + numeroDireita; break;
            case '-': resultado = numeroEsquerda - numeroDireita; break;
            case '*': resultado = numeroEsquerda * numeroDireita; break;
            case '/': resultado = numeroEsquerda / numeroDireita; break;
            case '^': resultado = Math.pow(numeroEsquerda, numeroDireita);break;
        }
        return resultado;
    }
}
