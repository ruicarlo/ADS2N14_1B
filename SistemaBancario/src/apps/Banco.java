package apps;

import controller.ContaController;

public class Banco {

    public static void main(String[] args) {
        try {
            ContaController conta = new ContaController(123,5);
            conta.imprimirSaldo();
            conta.imprimirLimite();
            conta.sacar(6001);
            conta.imprimirSaldo();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
