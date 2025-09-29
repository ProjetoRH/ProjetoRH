package view.cursos;

import java.util.Scanner;
import view.utils.ConsoleUtils;

public class CursoAdmView {

    public void menuAdmn(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            ConsoleUtils.limparTela();
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║ Menu ADMIN (Cursos)              ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║ 1 - Cadastrar novo curso         ║");
            System.out.println("║ 2 - Atribuir curso a cargo       ║");
            System.out.println("║ 3 - Desativar curso              ║");
            System.out.println("║ 4 - Gerenciar lista de presença  ║");
            System.out.println("║ 0 - Sair                         ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            ConsoleUtils.limparTela();
            switch (opcao) {
                case 1:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Cadastro de Curso            ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Cadastro de    ║");
                    System.out.println("║ novo curso...                ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                case 2:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Atribuir Curso               ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Atribuindo     ║");
                    System.out.println("║ curso a um cargo...          ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                case 3:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Desativar Curso              ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Desativação    ║");
                    System.out.println("║ de curso...                  ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                case 4:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Lista de Presença            ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Gerenciando    ║");
                    System.out.println("║ lista de presença...         ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                case 0:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Saindo                       ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ Voltando ao menu anterior... ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                default:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Erro                         ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ Opção inválida!              ║");
                    System.out.println("╚══════════════════════════════╝");
            }
        } while (opcao != 0);
    }
}
