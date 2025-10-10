package view;

import application.sessao.SessaoSistema;

import java.sql.SQLException;
import java.util.Scanner;

public class FuncionarioMenuView {
    private final Scanner scanner = new Scanner(System.in);

    public void exibir() throws SQLException {
        while (true) {
            System.out.println("\n=== Menu Funcionário ===");
            System.out.println("[1] Ver Meus Cursos");
            System.out.println("[0] Logout");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    new MeusCursosView().exibir();
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

