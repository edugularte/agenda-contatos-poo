package br.com.agenda.exception;

public class ContatoException extends Exception {
    public ContatoException(String message) {
        super(message);
    }
    
    public ContatoException(String message, Throwable cause) {
        super(message, cause);
    }
}
