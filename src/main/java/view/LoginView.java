package view;

import application.sessao.SessaoSistema;
import domain.model.Usuario;
import java.util.Scanner;

public class LoginView {
    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {
        System.out.println("=== Login ===");
        while (true) {
            System.out.print("E-mail: ");
            String email = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            // Exemplo de chamada ao controller de autenticação (ajuste conforme seu projeto)
            Usuario usuario = null;
            // usuario = application.controller.UsuarioController.autenticar(email, senha);

            if (usuario != null) {
                SessaoSistema.obterInstancia().iniciarSessao(usuario, usuario.getTipoDoBanco());
                break;
            } else {
                System.out.println("Credenciais inválidas. Tente novamente.");
            }
        }
    }
}
