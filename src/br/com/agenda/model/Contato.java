package br.com.agenda.model;

import java.util.ArrayList;
import java.util.List;

/**
 * CLASSE BASE: Define a estrutura comum para todos os contatos
 * ENCAPSULAMENTO: Atributos privados com métodos de acesso
 */
public class Contato {
    // ATRIBUTOS: nome, lista de telefones, lista de emails, endereço
    private String nome;
    private final List<String> telefones;
    private final List<String> emails;
    private Endereco endereco;

    // CONSTRUTOR: Inicializa o contato com nome e listas vazias
    public Contato(String nome) {
        this.nome = nome;
        this.telefones = new ArrayList<>();
        this.emails = new ArrayList<>();
    }
    
    // ENCAPSULAMENTO: Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public List<String> getTelefones() { return telefones; }
    public List<String> getEmails() { return emails; }
    
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    
    // MÉTODO adicionarTelefone(): Adiciona um telefone à lista
    public void adicionarTelefone(String telefone) {
        if (telefone != null && !telefone.trim().isEmpty()) {
            telefones.add(telefone);
        }
    }

    // MÉTODO adicionarEmail(): Adiciona um email à lista
    public void adicionarEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            emails.add(email);
        }
    }

    // MÉTODO toString(): Implementação base para representação do contato
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        
        if (!telefones.isEmpty()) {
            sb.append("Telefones: ").append(String.join(", ", telefones)).append("\n");
        }
        
        if (!emails.isEmpty()) {
            sb.append("Emails: ").append(String.join(", ", emails)).append("\n");
        }
        
        if (endereco != null) {
            sb.append("Endereço: ").append(endereco.toString()).append("\n");
        }
        
        return sb.toString();
    }
}
