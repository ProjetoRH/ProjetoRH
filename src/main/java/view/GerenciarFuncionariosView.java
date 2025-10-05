package view;

import java.util.Scanner;

public class GerenciarFuncionariosView {
    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {
        while (true) {
            System.out.println("\n=== Gerenciar Funcionários ===");
            System.out.println("[1] Listar Funcionários");
            System.out.println("[2] Cadastrar Novo Funcionário");
            System.out.println("[3] Cadastrar Múltiplos (via Excel)");
            System.out.println("[4] Editar Funcionário");
            System.out.println("[5] Deletar Funcionário");
            System.out.println("[0] Voltar");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    // Chamar método para listar funcionários
                    break;
                case "2":
                    // Chamar método para cadastrar novo funcionário
                    break;
                case "3":
                    // Chamar método para cadastrar múltiplos via Excel
                    break;
                case "4":
                    // Chamar método para editar funcionário
                    break;
                case "5":
                    // Chamar método para deletar funcionário
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

