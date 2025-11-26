package br.com.agenda.model;

public class ContatoPessoal extends Contato {
    private String dataAniversario;
    
    public ContatoPessoal(String nome, String dataAniversario) {
        super(nome);
        this.dataAniversario = dataAniversario;
    }
    
    public String getDataAniversario() { return dataAniversario; }
    public void setDataAniversario(String dataAniversario) { 
        this.dataAniversario = dataAniversario; 
    }
    
    @Override
    public String toString() {
        return super.toString() + "Aniversário: " + dataAniversario + "\n" +
               "Tipo: Contato Pessoal\n";
    }
}
