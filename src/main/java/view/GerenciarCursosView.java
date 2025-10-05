package view;

import java.util.Scanner;

public class GerenciarCursosView {
    private final Scanner scanner = new Scanner(System.in);

    public void exibir() {
        while (true) {
            System.out.println("\n=== Gerenciar Cursos ===");
            System.out.println("[1] Listar Cursos");
            System.out.println("[2] Cadastrar Novo Curso");
            System.out.println("[3] Vincular Funcionário a Curso");
            System.out.println("[4] Atualizar Status de Curso");
            System.out.println("[5] Configurar Automação de Curso por Cargo");
            System.out.println("[0] Voltar");
            System.out.print("Escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    // Chamar método para listar cursos
                    break;
                case "2":
                    // Chamar método para cadastrar novo curso
                    break;
                case "3":
                    // Chamar método para vincular funcionário
                    break;
                case "4":
                    // Chamar método para atualizar status
                    break;
                case "5":
                    // Chamar método para configurar automação
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

