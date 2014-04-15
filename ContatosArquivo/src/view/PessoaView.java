package view;

import static java.lang.System.out;

public class PessoaView {

    public String getDadosPessoaFormatado(String nome, String telefone, String endereco) {
        return String.format("Nome: %s, Telefone: %s, Endereco: %s", nome, telefone, endereco);
    }
}