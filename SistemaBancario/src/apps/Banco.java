package apps;

import controller.ContaController;

public class Banco {

    public static void main(String[] args) {
        boolean sair;
        try {
            ContaController conta = new ContaController();
            do {
                sair = conta.executarComando();
            } while(sair);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
