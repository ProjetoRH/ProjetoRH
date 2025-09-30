package domain.model.valueobjects;

import shared.exceptions.EmailInvalidoException;

public class Email {
    private final String email;

    public Email(String email) {
        if (!validarEmail(email)) {
            throw new EmailInvalidoException("Email inválido: " + email);
        }
        this.email = email;
    }

    private boolean validarEmail(String email) {

        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$" );
    }

    public String obterEmail() {
        return email;
    }
}