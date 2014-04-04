package apps;

import controller.ContaController;

public class Banco {

    public static void main(String[] args) {
        try {
            ContaController conta = new ContaController();
            conta.executarComando();
            conta.executarComando();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
