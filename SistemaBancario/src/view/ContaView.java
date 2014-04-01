package view;
import java.util.Scanner;
public class ContaView {
    Scanner ler = new Scanner(System.in);

    public void imprimirSaldo(double saldo) {
        System.out.println(String.format("Saldo atual da conta R$ %1$,.2f", saldo));
    }

    public void imprimirLimite(double limite) {
        System.out.println(String.format("Limite atual da conta R$ %1$,.2f", limite));
    }

    public void imprimirSelecioneTipoConta() {
        System.out.print("Selecione o tipo de conta: ");
    }

    public void imprimirDigiteNumeroConta() {
        System.out.print("Digite o número da conta: ");
    }

    public void imprimirDigiteNumeroVerificacao() {
        System.out.print("Digite o número verificador da conta: ");
    }

    public String lerTipoConta() {
        return ler.nextLine();
    }

    public int lerNumeroConta() {
        return ler.nextInt();
    }

    public int lerNumeroVerificacao() {
        return ler.nextInt();
    }
    
    public void imprimirDadosDeposito(double valor) {
        System.out.println(String.format("Realizado Depósito de R$ %1$,.2f", valor));
    }

    public void imprimirDadosSaque(double valor) {
        System.out.println(String.format("Realizado Saque de R$ %1$,.2f", valor));
    }
}
