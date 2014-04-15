package app;

import controller.ContaController;

public class xBanco {

    public static void main(String[] args) {
        boolean sair;
        try {
            ContaController conta = new ContaController();
            conta.criarContaAleatoria();
            System.out.println(
            conta.getDadosContaParaSalvarArquivo()
                    );
//            do {
//                sair = conta.executarComando();
//            } while(sair);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}
