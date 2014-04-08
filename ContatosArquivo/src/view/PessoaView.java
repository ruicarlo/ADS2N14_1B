package view;

import static java.lang.System.out;

public class PessoaView {
    public void imprimeDadosPessoa(String nome, String telefone, String endereco) {
        out.println("Nome: " + nome + ", " + "telefone: " + telefone + " Endereço: " + endereco);
    }
}