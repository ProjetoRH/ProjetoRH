package view;

import application.sessao.SessaoSistema;
import domain.model.Usuario;
import domain.model.enums.TipoUsuario;
import domain.model.valueobjects.Email;
import view.AdminMenuView;
import view.FuncionarioMenuView;

import java.sql.SQLException;
import java.util.Scanner;
import shared.exceptions.EmailInvalidoException; // 🔹 Import necessário

public class LoginView {
    private final Scanner sc = new Scanner(System.in);

    public void exibir() throws SQLException {
        System.out.println("=== Login ===");

        try {
            System.out.print("E-mail: ");
            String emailString = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();

            Email email = new Email(emailString);

            Usuario usuarioTentativa = new Usuario();
            usuarioTentativa.setEmail(email);
            usuarioTentativa.setSenha(senha);

            try {
                SessaoSistema.obterInstancia().iniciarSessao(usuarioTentativa);
                System.out.println("Login efetuado com sucesso!");

                TipoUsuario tipo = SessaoSistema.obterInstancia().obterTipoUsuarioAtual();

                if (tipo == TipoUsuario.ADMIN) {
                    new AdminMenuView().exibir();
                    return;
                } else if (tipo == TipoUsuario.FUNCIONARIO) {
                    new FuncionarioMenuView().exibir();
                    return;
                }

            } catch (SecurityException e) {
                System.out.println("Credenciais inválidas. Tente novamente.");
            } catch (SQLException e) {
                System.out.println("Erro interno ao autenticar. Tente novamente ou contate o suporte.");
            }

        } catch (EmailInvalidoException e) {
            System.out.println(e.getMessage());
            System.out.println("Tente novamente.\n");
            exibir();
        }
    }
}
