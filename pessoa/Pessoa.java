package pessoa;

public class Pessoa {
    private String nome;
    private String CPF;
    private String RG;
    private String genero;
    private int idade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public void setGenero(String genero) {
        this.genero = genero.toUpperCase();
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getRG() {
        return this.RG;
    }

    public String getGenero() {
        return this.genero;
    }

    public int getIdade() {
        return this.idade;
    }

    public void validarGenero(String genero) throws Exception {
        if(!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F")) {
            throw new Exception("Genero inválido, digite uma opção entre M ou F");
        }
    }

    public void validarIdade(int idade) throws Exception{
        if(idade <= 0) {
            throw new Exception("Idade deve ser maior que zero");
        }
    }

    public void validarCPF(String CPF) throws Exception {
        if(!CPF.matches("^((\\d{3})\\.){2}(\\d{3})-(\\d{2})$")) {
            throw new Exception("Formato do CPF inválido");
        }
    }
}