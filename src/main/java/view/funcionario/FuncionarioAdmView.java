package view.funcionario;

import view.utils.ConsoleUtils;

import java.util.Scanner;

public class FuncionarioAdmView {

    public void menuAdm() {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            ConsoleUtils.limparTela();
            System.out.println("╔════════════════════════════════╗");
            System.out.println("║ Menu ADMIN (Funcionários)      ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1 - Cadastrar Funcionário      ║");
            System.out.println("║ 2 - Editar Funcionário         ║");
            System.out.println("║ 3 - Desativar Funcionário      ║");
            System.out.println("║ 0 - Voltar                     ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            ConsoleUtils.limparTela();
            switch (opcao) {
                case 1:
                    System.out.println("╔════════════════════════════╗");
                    System.out.println("║ Cadastro de Funcionário    ║");
                    System.out.println("╠════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Cadastro de  ║");
                    System.out.println("║ funcionário...             ║");
                    System.out.println("╚════════════════════════════╝");
                    break;
                case 2:
                    System.out.println("╔════════════════════════════╗");
                    System.out.println("║ Edição de Funcionário      ║");
                    System.out.println("╠════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Edição de    ║");
                    System.out.println("║ funcionário...             ║");
                    System.out.println("╚════════════════════════════╝");
                    break;
                case 3:
                    System.out.println("╔════════════════════════════╗");
                    System.out.println("║ Desativar Funcionário      ║");
                    System.out.println("╠════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Desativação  ║");
                    System.out.println("║ de funcionário...          ║");
                    System.out.println("╚════════════════════════════╝");
                    break;
                case 0:
                    System.out.println("╔════════════════════════════╗");
                    System.out.println("║ Saindo                     ║");
                    System.out.println("╠════════════════════════════╣");
                    System.out.println("║ Voltando ao menu anterior  ║");
                    System.out.println("╚════════════════════════════╝");
                    break;
                default:
                    System.out.println("╔════════════════════════════╗");
                    System.out.println("║ Erro                       ║");
                    System.out.println("╠════════════════════════════╣");
                    System.out.println("║ Opção inválida!            ║");
                    System.out.println("╚════════════════════════════╝");
            }
        } while (opcao != 0);
    }
}
