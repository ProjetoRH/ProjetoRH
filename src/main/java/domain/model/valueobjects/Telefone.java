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
        return telefone != null && (
            telefone.matches("\\(\\d{2}\\)\\d{4,5}-\\d{4}") || // (11)99999-9999
            telefone.matches("\\d{11}") // 11999999999
        );
    }

    public String obterTelefone() {
        return telefone;
    }
}
