package shared.util;

import shared.exceptions.ValidacaoException;

public class ValidacaoUtil {

    public static void checarObrigatoriedade(String valor, String nomeDoCampo) {
        if (valor == null || valor.isEmpty()) {
            throw new ValidacaoException("O " + nomeDoCampo + " não pode ser nulo ou vazio.");
        }
    }

    public static void checarObrigatoriedade(Integer numero, String nomeDoCampo) {
        if (numero == null) {
            throw new ValidacaoException("O " + nomeDoCampo + " não pode ser nulo.");
        }
    }
}
