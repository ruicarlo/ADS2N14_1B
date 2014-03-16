package pessoa.view;

import static java.lang.System.out;

public class PessoaView {
    public void imprimeDadosPessoa(String nome, String endereco, String CPF, String RG, String genero, int idade, String telefone) {
        out.println("Nome: " + nome);
        out.println("Endereço: " + endereco);
        out.println("CPF: " + CPF);
        out.println("RG: " + RG);
        out.println("Genero: " + genero);
        out.println("Idade: " + idade);
        out.println("Telefone: " + telefone);
    }

    public void imprimeDadosPessoa(String nome, String telefone) {
        out.println("Nome: " + nome + ", " + "telefone: " + telefone);
    }
}