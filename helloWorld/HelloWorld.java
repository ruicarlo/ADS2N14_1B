package helloworld;
import java.util.Scanner;

public class HelloWorld {

  public static void main(String[] args) {
    String sNome;
    Scanner ler = new Scanner (System.in);
    System.out.print("Por favor digite seu nome: ");
    sNome = ler.next();
    System.out.println("Hello " + sNome);
  }
}
