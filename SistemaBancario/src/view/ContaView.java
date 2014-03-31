package view;

public class ContaView {
    public void imprimirSaldo(double saldo) {
        System.out.println(String.format("Saldo atual da conta: %1$,.2f", saldo));
    }

    public void imprimirLimite(double limite) {
        System.out.println(String.format("Limite atual da conta: %1$,.2f", limite));
    }
}
