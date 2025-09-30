package shared.exceptions;

public class EmailInvalidoException extends RuntimeException {
    public EmailInvalidoException(String mensagem) {
        super(mensagem);
    }
}

