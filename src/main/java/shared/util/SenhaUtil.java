package shared.util;

import org.mindrot.jbcrypt.BCrypt;

import java.security.SecureRandom;

public class SenhaUtil {

    private static final int forcaHash = 12;

    public static final String hashSenha(String senha_texto) {

        String salt = BCrypt.gensalt(forcaHash);

        String senhaHashed = BCrypt.hashpw(senha_texto,salt);

        return senhaHashed;
    }

    public static boolean verificaSenha(String senhaTexto, String senhaHashed) {

        Boolean verificaSenha = false;

        verificaSenha = BCrypt.checkpw(senhaTexto, senhaHashed);

        return verificaSenha;

    }

    public static final String geraSenha() {
        String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMOPQRSTUVWXYZ0123456789";

        final SecureRandom random = new SecureRandom();

        StringBuilder senha = new StringBuilder(5);

        for(int i = 0 ; i <= 5 ; i++) {

            int indice = random.nextInt(caracteres.length());

            char caracterAleatorio = caracteres.charAt(indice);

            senha.append(caracterAleatorio);
        }

        return senha.toString();
    }
}
