package br.com.agenda.model;

/**
 * HERANÇA: ContatoProfissional herda de Contato (é-um Contato)
 * Adiciona atributos específicos de contatos profissionais
 */
public class ContatoProfissional extends Contato {  // HERANÇA: extends Contato
    // ATRIBUTOS ESPECÍFICOS: empresa, cargo (específicos de contatos profissionais)
    private String empresa;
    private String cargo;

    // CONSTRUTOR: Chama construtor da classe pai e inicializa atributos específicos
    public ContatoProfissional(String nome, String empresa, String cargo) {
        super(nome); // Chama construtor da classe pai
        this.empresa = empresa;
        this.cargo = cargo;
    }

    // ENCAPSULAMENTO: Getters e Setters específicos
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    /**
     * POLIMORFISMO: Sobrescrita do método toString()
     * Reutiliza o comportamento da classe pai e adiciona comportamento específico
     */
    @Override
    public String toString() {
        return super.toString() + "Empresa: " + empresa + "\n" +
               "Cargo: " + cargo + "\n" +
               "Tipo: Contato Profissional\n";
    }
}
