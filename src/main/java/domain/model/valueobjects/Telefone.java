package domain.model.valueobjects;

import shared.exceptions.TelefoneInvalidoException;

public class Telefone {
    private final String telefone;

    public Telefone(String telefone) {
        if (!validarTelefone(telefone)) {
            throw new TelefoneInvalidoException("Telefone inválido: " + telefone);
        }
        this.telefone = telefone;
    }

    private boolean validarTelefone(String telefone) {
        if (telefone == null) {
            return false;
        }

        boolean formatoComParenteses = telefone.matches("^\\(\\d{2}\\)\\s?\\d{4,5}-\\d{4}$");

        boolean formatoApenasNumeros = telefone.matches("^\\d{11}$");

        return formatoComParenteses || formatoApenasNumeros;
    }

    public String obterTelefone() {
        return telefone;
    }
}
