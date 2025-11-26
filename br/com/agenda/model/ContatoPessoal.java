package br.com.agenda.model;

/**
 * HERANÇA: ContatoPessoal herda de Contato (é-um Contato)
 * Adiciona atributos específicos de contatos pessoais
 */
public class ContatoPessoal extends Contato { // HERANÇA: extends Contato
    // ATRIBUTO ESPECÍFICO: dataAniversario (específico de contatos pessoais)
    private String dataAniversario;

    // CONSTRUTOR: Chama construtor da classe pai e inicializa atributo específico
    public ContatoPessoal(String nome, String dataAniversario) {
        super(nome);
        this.dataAniversario = dataAniversario;
    }

    // ENCAPSULAMENTO: Getter e Setter específico
    public String getDataAniversario() { return dataAniversario; }
    public void setDataAniversario(String dataAniversario) { 
        this.dataAniversario = dataAniversario; 
    }

    /**
     * POLIMORFISMO: Sobrescrita do método toString()
     * Reutiliza o comportamento da classe pai e adiciona comportamento específico
     */
    @Override
    public String toString() {
        return super.toString() + "Aniversário: " + dataAniversario + "\n" +
               "Tipo: Contato Pessoal\n";
    }
}
