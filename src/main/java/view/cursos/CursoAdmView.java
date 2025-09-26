package view.cursos;

import java.util.Scanner;

public class CursoAdmView {
    public void menuAdmn(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n--- Menu ADMIN (Cursos) ---");
            System.out.println("1 - Cadastrar novo curso");
            System.out.println("2 - Atribuir curso a cargo específico");
            System.out.println("3 - Desativar curso");
            System.out.println("4 - Gerenciar lista de presença");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("[FUNCAO AQUI] Cadastro de novo curso...");
                    break;
                case 2:
                    System.out.println("[FUNCAO AQUI] Atribuindo curso a um cargo...");
                    break;
                case 3:
                    System.out.println("[FUNCAO AQUI] Desativação de curso...");
                    break;
                case 4:
                    System.out.println("[FUNCAO AQUI] Gerenciando lista de presença...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
