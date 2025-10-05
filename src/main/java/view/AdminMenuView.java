package view;

import application.sessao.SessaoSistema;
import domain.model.enums.TipoUsuario;
import java.util.Scanner;

public class AdminMenuView {
    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {
        while (true) {
            System.out.println("\n=== Menu Administrador ===");
            System.out.println("[1] Gerenciar Funcionários");
            System.out.println("[2] Gerenciar Cursos");
            System.out.println("[0] Logout");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    new GerenciarFuncionariosView().exibir();
                    break;
                case "2":
                    new GerenciarCursosView().exibir();
                    break;
                case "0":
                    SessaoSistema.obterInstancia().encerrarSessao();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

