package pilhas;

import Exceptions.StackException;
import estruturas.Stack;
import java.util.StringTokenizer;

public class InFixa {
    Stack<String> pilha = new Stack(15, true);
    String expressao;

    public InFixa(String expressao) {
        this.expressao = expressao;
    }

    public String converter() {
        String itemPilha;
        StringTokenizer st = new StringTokenizer(this.expressao);
        StringBuilder sb = new StringBuilder();
        try {
            while (st.hasMoreTokens()) {
                String itemExp = st.nextToken();
                switch(itemExp) {
                    case "(":
                        pilha.push(itemExp);
                    break;

                    case "^":
                    case "*":
                    case "/":
                        if(pilha.isEmpty() || pilha.peek().equals("+") || pilha.peek().equals("-")) {
                            pilha.push(itemExp);
                        } else {
                            while(!pilha.isEmpty()) {
                                sb.append(pilha.pop());
                                sb.append(" ");
                            }
                            
                            pilha.push(itemExp);
                        }
                    break;
                    case "+":
                    case "-":
                        while(!pilha.isEmpty()) {
                            itemPilha = pilha.pop();
                            if(itemPilha.equals("(")) {
                                break;
                            }
                            sb.append(itemPilha);
                            sb.append(" ");
                        }
                        pilha.push(itemExp);
                    break;
                    case ")":
                        while(!pilha.isEmpty()) {
                            itemPilha = pilha.pop();
                            if(itemPilha.equals("(")) {
                                break;
                            }
                            sb.append(itemPilha);
                            sb.append(" ");
                        }
                    break;
                    default:
                        sb.append(itemExp);
                        sb.append(" ");
                }
            }
            while(!pilha.isEmpty()) {
                String resto = pilha.pop();
                sb.append(resto);
                sb.append(" ");
            }
        }catch(StackException e) {
            System.out.println("Erro:" + e.getMessage());
        }
        return sb.toString().trim();
    }
}
