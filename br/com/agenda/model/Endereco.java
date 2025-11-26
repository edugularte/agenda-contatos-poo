package br.com.agenda.model;

/**
 * CLASSE: Representa um endereço com todos os seus atributos
 * ENCAPSULAMENTO: Atributos privados com getters/setters
 */
public class Endereco {
    // ATRIBUTOS: rua, cidade, estado, cep
    private String rua;
    private String cidade;
    private String estado;
    private String cep;

    // CONSTRUTOR: Inicializa todos os atributos do endereço
    public Endereco(String rua, String cidade, String estado, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    // ENCAPSULAMENTO: Getters e Setters para acesso controlado
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    
    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    // MÉTODO toString(): Representação em string do objeto
    @Override
    public String toString() {
        return rua + ", " + cidade + " - " + estado + ", CEP: " + cep;
    }
}
