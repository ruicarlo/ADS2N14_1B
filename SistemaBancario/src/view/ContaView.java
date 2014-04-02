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

    public void imprimirSaldo(double saldo) {
        System.out.println(String.format("Saldo atual da conta R$ %1$,.2f", saldo));
    }

    public void imprimirLimite(double limite) {
        System.out.println(String.format("Limite atual da conta R$ %1$,.2f", limite));
    }

    public void imprimirSelecioneTipoConta() {
        System.out.print("Selecione o tipo de conta (N para normal, E para Especial): ");
    }

    public void imprimirDigiteNumeroConta() {
        System.out.print("Digite o numero da conta: ");
    }

    public void imprimirDigiteNumeroVerificacao() {
        System.out.print("Digite o numero verificador da conta: ");
    }

    public void imprimirSelecioneComando() {
        System.out.print("Selecione um comando (D para Deposito, S para Saque, outra tecla para sair): ");
    }

    public void imprimirDigiteValor() {
        System.out.print("Digite o valor: ");
    }

    public char lerTipoConta() {
        char tipoConta   = 'N';
        boolean validado = false;

        do {
            try {
                this.imprimirSelecioneTipoConta();
                tipoConta = this.ler.next().charAt(0);
                switch(tipoConta) {
                    case 'N':
                    case 'E':
                    case 'n':
                    case 'e':
                        validado = true;
                    break;
                }
            } catch(InputMismatchException e) {
                System.out.println("Tipo de conta invalido");
                this.setLer();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return tipoConta;
    }

    public int lerNumeroConta() {
        int numConta = 0;
        boolean validado = false;

        do {
            try {
                this.imprimirDigiteNumeroConta();
                numConta = this.ler.nextInt();          
                validado = true;
            } catch(InputMismatchException e) {
                System.out.println("Numero de conta invalido");
                this.setLer();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return numConta;
    }

    public int lerNumeroVerificacao() {
        int numVerificacao = 0;
        boolean validado = false;

        do {
            try {
                this.imprimirDigiteNumeroVerificacao();
                numVerificacao = this.ler.nextInt();          
                validado = true;
            } catch(InputMismatchException e) {
                System.out.println("Digito de verificacao invalido");
                this.setLer();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return numVerificacao;
    }

    public char lerComando() {
        char comando   = 'O';
        boolean validado = false;

        do {
            try {
                this.imprimirSelecioneComando();
                comando = this.ler.next().charAt(0);
                switch(comando) {
                    case 'D':
                    case 'S':
                    case 's':
                    case 'd':
                        validado = true;
                    break;
                }
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
        double valor   = 'O';
        boolean validado = false;

        do {
            try {
                this.imprimirDigiteValor();
                valor = this.ler.nextFloat();
                validado = false;
            } catch(InputMismatchException e) {
                System.out.println(e.getMessage());
                System.out.println("Valor invalido");
                this.setLer();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        } while(!validado);
        return valor;
    }

    public void imprimirDadosDeposito(double valor) {
        System.out.println(String.format("Realizado Deposito de R$ %1$,.2f", valor));
    }

    public void imprimirDadosSaque(double valor) {
        System.out.println(String.format("Realizado Saque de R$ %1$,.2f", valor));
    }
}