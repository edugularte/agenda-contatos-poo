package br.com.agenda.service;

import br.com.agenda.exception.ContatoException;
import br.com.agenda.model.Contato;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private final List<Contato> contatos;
    
    public Agenda() {
        this.contatos = new ArrayList<>();
    }
    
    // Adicionar contato
    public void adicionarContato(Contato contato) throws ContatoException {
        if (contato == null) {
            throw new ContatoException("Contato não pode ser nulo");
        }
        
        if (!buscarPorNome(contato.getNome()).isEmpty()) {
            throw new ContatoException("Já existe um contato com este nome");
        }
        
        contatos.add(contato);
    }
    
    // Remover contato
    public boolean removerContato(String nome) {
        return contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
    }
    
    // Buscar por nome
    public List<Contato> buscarPorNome(String nome) {
        List<Contato> resultados = new ArrayList<>();
        for (Contato contato : contatos) {
            if (contato.getNome().toLowerCase().contains(nome.toLowerCase())) {
                resultados.add(contato);
            }
        }
        return resultados;
    }
    
    // Buscar por email
    public List<Contato> buscarPorEmail(String email) {
        List<Contato> resultados = new ArrayList<>();
        for (Contato contato : contatos) {
            for (String contatoEmail : contato.getEmails()) {
                if (contatoEmail.toLowerCase().contains(email.toLowerCase())) {
                    resultados.add(contato);
                    break;
                }
            }
        }
        return resultados;
    }
    
    // Listar todos
    public List<Contato> listarTodos() {
        return new ArrayList<>(contatos);
    }
    
    // Editar contato
    public boolean editarContato(String nomeAntigo, Contato novoContato) {
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().equalsIgnoreCase(nomeAntigo)) {
                contatos.set(i, novoContato);
                return true;
            }
        }
        return false;
    }
}
