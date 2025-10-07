package view;// view/LoginView.java

// ... imports ...
import application.sessao.SessaoSistema;
import domain.model.Usuario;
import domain.model.enums.TipoUsuario; // Novo import necessário
import domain.model.valueobjects.Email;
import view.AdminMenuView;

import java.sql.SQLException;
import java.util.Scanner;

public class LoginView {
    private final Scanner sc = new Scanner(System.in);

    // Mantenha o SessaoController apenas se for usá-lo, 
    // mas o SessaoSistema já faz o trabalho de orquestração.
    // SessaoController sessaoController = new SessaoController(); 

    public void exibir() throws SQLException {

        System.out.println("=== Login ===");
        while (true) {
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
                    return;
                }

                return;

            } catch (SecurityException e) {
                System.out.println("Credenciais inválidas. Tente novamente.");
            } catch (SQLException e) {
                System.out.println("Erro interno ao autenticar. Tente novamente ou contate o suporte.");
            }
        }
    }
}