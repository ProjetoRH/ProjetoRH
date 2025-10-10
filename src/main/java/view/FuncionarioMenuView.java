package view;

import application.sessao.SessaoSistema;
import java.util.Scanner;

public class FuncionarioMenuView {
    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {
        while (true) {
            System.out.println("\n=== Menu Funcionário ===");
            System.out.println("[1] Ver Meus Cursos");
            System.out.println("[0] Logout");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    new MeusCursosView().exibir();
                    break;
                case 0:
                    SessaoSistema.obterInstancia().encerrarSessao();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

