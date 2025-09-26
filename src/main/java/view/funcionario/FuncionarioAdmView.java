package view.funcionario;

import view.utils.ConsoleUtils;

import java.util.Scanner;

public class FuncionarioAdmView {
    public void menuAdm() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            ConsoleUtils.limparTela();
            System.out.println("\n--- Menu ADMIN (Funcionários) ---");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Editar Funcionário");
            System.out.println("3 - Desativar Funcionário");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    ConsoleUtils.limparTela();
                    System.out.println("[FUNCAO AQUI] Cadastro de funcionário...");
                    break;
                case 2:
                    ConsoleUtils.limparTela();
                    System.out.println("[FUNCAO AQUI] Edição de funcionário...");
                    break;
                case 3:
                    ConsoleUtils.limparTela();
                    System.out.println("[FUNCAO AQUI] Desativação de funcionário...");
                    break;

                default:
                    ConsoleUtils.limparTela();
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
