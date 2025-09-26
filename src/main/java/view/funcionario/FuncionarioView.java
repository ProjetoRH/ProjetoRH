package view.funcionario;

import java.util.Scanner;

public class FuncionarioView {
    public void menuFuncionario(){
        Scanner sc = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\n--- Menu Funcionário ---");
            System.out.println("1 - Ver meus cursos");
            System.out.println("2 - Ver frequência em curso");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Aplicar logica de verificar cursos AQUI");
                    break;
                case 2:
                    System.out.println("Aplica logica de ver frequencia AQUI");
                    break;
                case 0:
                    System.out.println("Saindo do menu funcionário...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}