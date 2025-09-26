package view.cursos;

import java.util.Scanner;

public class CursoView {
    public void menuFuncionario(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu Cursos (Funcionário) ---");
            System.out.println("1 - Listar meus cursos");
            System.out.println("2 - Ver cursos pendentes");
            System.out.println("3 - Ver minha frequência em um curso");
            System.out.println("0 - Voltar");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("[FUNCAO AQUI] Listando cursos do funcionário...");
                    break;
                case 2:
                    System.out.println("[FUNCAO AQUI] Mostrando cursos pendentes...");
                    break;
                case 3:
                    System.out.println("[FUNCAO AQUI] Consultando frequência em curso...");
                    break;
                case 0:
                    System.out.println("Voltando ao menu anterior...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
