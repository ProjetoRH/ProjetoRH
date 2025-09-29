package view.cursos;

import view.utils.ConsoleUtils;

import java.util.Scanner;

public class CursoView {

    public void menuFuncionario(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            ConsoleUtils.limparTela();
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║ Menu Cursos (Funcionário)            ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║ 1 - Listar meus cursos               ║");
            System.out.println("║ 2 - Ver cursos pendentes             ║");
            System.out.println("║ 3 - Ver minha frequência em um curso ║");
            System.out.println("║ 0 - Voltar                           ║");
            System.out.println("╚══════════════════════════════════════╝");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            ConsoleUtils.limparTela();
            switch (opcao) {
                case 1:
                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║ Listar Cursos                        ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Listando cursos do     ║");
                    System.out.println("║ funcionário...                       ║");
                    System.out.println("╚══════════════════════════════════════╝");
                    break;
                case 2:
                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║ Cursos Pendentes                     ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Mostrando cursos       ║");
                    System.out.println("║ pendentes...                         ║");
                    System.out.println("╚══════════════════════════════════════╝");
                    break;
                case 3:
                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║ Frequência em Curso                  ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.println("║ [FUNCAO AQUI] Consultando frequência ║");
                    System.out.println("║ em curso...                          ║");
                    System.out.println("╚══════════════════════════════════════╝");
                    break;
                case 0:
                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║ Saindo                               ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.println("║ Voltando ao menu anterior...         ║");
                    System.out.println("╚══════════════════════════════════════╝");
                    break;
                default:
                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║ Erro                                 ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.println("║ Opção inválida!                      ║");
                    System.out.println("╚══════════════════════════════════════╝");
            }
        } while (opcao != 0);
    }
}
