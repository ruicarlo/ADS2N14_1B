package pessoa.model;

public class Pessoa {
    private String nome;
    private String endereco;
    private String CPF;
    private String RG;
    private String genero;
    private String telefone;
    private int idade;
    private String tipoTelefone;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public void setTipoTelefone(String tipoTelefone) {
        this.tipoTelefone = tipoTelefone.toUpperCase();
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCPF() {
        return this.CPF;
    }

    public String getRG() {
        return this.RG;
    }

    public String getGenero() {
        return this.genero.equals("M") ? "Masculino" : "Feminino";
    }

    public String getTipoTelefone() {
        String tipo = "";
        switch(this.tipoTelefone) {
            case "R":
                tipo = "Residencial";
            break;
            case "C":
                tipo = "Celular";
            break;
            case "T":
                tipo = "Trabalho";
            break;
        }
        return tipo;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public int getIdade() {
        return this.idade;
    }

    public void validarGenero(String genero) throws Exception {
        if(!genero.equalsIgnoreCase("M") && !genero.equalsIgnoreCase("F")) {
            throw new Exception("Genero inválido, digite uma opção entre M ou F");
        }
    }

    public void validarTipoTelefone(String tipoTelefone) throws Exception {
        if(!tipoTelefone.equalsIgnoreCase("T") && !tipoTelefone.equalsIgnoreCase("R") && !tipoTelefone.equalsIgnoreCase("C")) {
            throw new Exception("Tipo do telefone inválido, digite uma opção entre C, R ou T");
        }
    }

    public void validarIdade(int idade) throws Exception {
        if(idade <= 0) {
            throw new Exception("Idade deve ser maior que zero");
        }
    }

    public void validarCPF(String CPF) throws Exception {
        if(!CPF.matches("^((\\d{3})\\.){2}(\\d{3})-(\\d{2})$")) {
            throw new Exception("Formato do CPF inválido");
        }
    }

    public void validarTelefone(String telefone) throws Exception {
        if(!telefone.matches("^(\\(\\d{2}\\))?(\\d{3})-(\\d{4})$")) {
            throw new Exception("Formato do telefone inválido");
        }
    }
}