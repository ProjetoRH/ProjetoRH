package domain.model.valueobjects;

import shared.exceptions.TelefoneInvalidoException;

public class Telefone {
    private final String telefone;

    public Telefone(String telefone) {
        if (telefone == null) {
            throw new TelefoneInvalidoException("Telefone não pode ser nulo");
        }

        String numeros = telefone.replaceAll("\\D", "");

        if (!validarTelefone(numeros)) {
            throw new TelefoneInvalidoException("Telefone inválido: " + telefone);
        }

        this.telefone = numeros;
    }

    private boolean validarTelefone(String telefone) {
        return telefone.matches("^\\d{10,11}$");
    }

    public String obterTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        if (telefone.length() == 11) {
            return String.format("(%s) %s-%s", telefone.substring(0, 2),
                    telefone.substring(2, 7), telefone.substring(7));
        } else {
            return String.format("(%s) %s-%s", telefone.substring(0, 2),
                    telefone.substring(2, 6), telefone.substring(6));
        }
    }
}
