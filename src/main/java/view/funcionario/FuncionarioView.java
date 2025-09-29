package view.funcionario;

import view.utils.ConsoleUtils;

import java.util.Scanner;

public class FuncionarioView {

    public void menuFuncionario(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            ConsoleUtils.limparTela();
            System.out.println("╔══════════════════════════════╗");
            System.out.println("║ Menu Funcionário             ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1 - Ver meus cursos          ║");
            System.out.println("║ 2 - Ver frequência em curso  ║");
            System.out.println("║ 0 - Sair                     ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            ConsoleUtils.limparTela();
            switch (opcao) {
                case 1:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Meus Cursos                  ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ Aplicar lógica de verificar  ║");
                    System.out.println("║ cursos AQUI                  ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                case 2:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Frequência em Curso          ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ Aplica lógica de ver         ║");
                    System.out.println("║ frequência AQUI              ║");
                    System.out.println("╚══════════════════════════════╝");
                    break;
                case 0:
                    System.out.println("╔══════════════════════════════╗");
                    System.out.println("║ Saindo                       ║");
                    System.out.println("╠══════════════════════════════╣");
                    System.out.println("║ Saindo do menu funcionário...║");
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
