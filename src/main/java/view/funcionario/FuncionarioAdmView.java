package view.funcionario;

import java.util.Scanner;

public class FuncionarioAdmView {
    public void menuAdm() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ADMIN (Funcionários) ---");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Editar Funcionário");
            System.out.println("3 - Desativar Funcionário");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("[FUNCAO AQUI] Cadastro de funcionário...");
                    break;
                case 2:
                    System.out.println("[FUNCAO AQUI] Edição de funcionário...");
                    break;
                case 3:
                    System.out.println("[FUNCAO AQUI] Desativação de funcionário...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
