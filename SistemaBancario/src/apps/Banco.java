package apps;

import controller.ContaController;

public class Banco {

    public static void main(String[] args) {
        try {
            ContaController conta = new ContaController();
            conta.depositar(5000);
            conta.depositar(200);
            conta.depositar(7.5);
            conta.depositar(20.02);
            conta.depositar(1999.4);
            conta.sacar(600);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
