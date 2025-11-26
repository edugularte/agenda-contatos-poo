package br.com.agenda.exception;

/**
 * TRATAMENTO DE EXCEÇÕES: Exceção personalizada para erros específicos da agenda
 * Herda de Exception para criar uma exceção verificada
 */
public class ContatoException extends Exception { // HERANÇA para exceções
    
    // CONSTRUTOR: Inicializa a exceção com mensagem de erro
    public ContatoException(String message) {
        super(message); // Chama construtor da classe pai (Exception)
    }

    // CONSTRUTOR: Inicializa com mensagem e causa
    public ContatoException(String message, Throwable cause) {
        super(message, cause); // Chama construtor da classe pai
    }
}
