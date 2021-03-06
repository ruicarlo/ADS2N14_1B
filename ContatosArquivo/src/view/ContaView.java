package view;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ContaView {
    Scanner ler;

    public ContaView() {
        this.setLer();
    }

    private void setLer() {
        this.ler = new Scanner(System.in);
    }

    public String getMsgSaldoAtual(double saldo) {
        return String.format("Saldo atual da conta R$ %1$,.2f", saldo);
    }

    public void imprimirSaldo(double saldo) {
        System.out.println(this.getMsgSaldoAtual(saldo));
    }

    public String getMsgLimiteConta(double limite) {
        return String.format("Limite atual da conta R$ %1$,.2f", limite);
    }

    public void imprimirLimite(double limite) {
        System.out.println(this.getMsgLimiteConta(limite));
    }

    public void imprimirSelecioneTipoConta() {
        System.out.print("Selecione o tipo de conta (N para normal, E para Especial, I para Investimento): ");
    }

    public void imprimirDigiteNumeroConta() {
        System.out.print("Digite o numero da conta: ");
    }

    public void imprimirDigiteNumeroVerificacao() {
        System.out.print("Digite o numero verificador da conta: ");
    }

    public void imprimirSelecioneComando() {
        System.out.print("Selecione o comando (D:Deposito, S:Saque, I:Investimento, R:Saldo, outra tecla para sair): ");
    }

    public void imprimirDigiteValor() {
        System.out.print("Digite o valor: ");
    }

    public void imprimirDigiteTaxa() {
        System.out.print("Digite a taxa de investimento: ");
    }

    public char lerComando() {
        char comando   = 'Q';
        boolean validado = false;

        do {
            try {
                this.imprimirSelecioneComando();
                comando = Character.toUpperCase(this.ler.next().charAt(0));
                validado = true;
            } catch(InputMismatchException e) {
                System.out.println("Comando invalido");
                this.setLer();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return comando;
    }

    public double lerValorSaqueDeposito() {
        double valor   = 0;
        boolean validado = false;

        do {
            try {
                this.imprimirDigiteValor();
                valor = this.ler.nextDouble();
                validado = true;
            } catch(InputMismatchException e) {
                System.out.println("Valor invalido");
                this.setLer();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return valor;
    }

    public double lerTaxaInvestimento() {
        double taxa   = 0;
        boolean validado = false;

        do {
            try {
                this.imprimirDigiteTaxa();
                taxa = this.ler.nextDouble();
                validado = true;
            } catch(InputMismatchException e) {
                System.out.println("Valor invalido");
                this.setLer();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return taxa;
    }

    public String getMsgDadosDeposito(double valor) {
        return String.format("Realizado Deposito de R$ %1$,.2f", valor);
    }

    public void imprimirDadosDeposito(double valor) {
        System.out.println(this.getMsgDadosDeposito(valor));
    }

    public String getMsgDadosSaque(double valor) {
        return String.format("Realizado Saque de R$ %1$,.2f", valor);
    }

    public void imprimirDadosSaque(double valor) {
        System.out.println(this.getMsgDadosSaque(valor));
    }

    public String getMsgDadosInvestimento(double taxa) {
        return String.format("Realizado Investimento com taxa de %1$,.2f", taxa);
    }
}