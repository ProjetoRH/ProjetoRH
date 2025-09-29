package shared.exceptions;

public class TelefoneInvalidoException extends RuntimeException {
    public TelefoneInvalidoException(String mensagem) {
        super(mensagem);
    }
}

