package view;

import java.util.Scanner;

public class MeusCursosView {
    private final Scanner scanner = new Scanner(System.in);

     public void exibir() {
        // Chamar método pa45ra listar cursos do funcionário
        System.out.println("\n=== Meus Cursos ===");
        // Exibir lista de cursos e status
        // Solicitar número do curso para ver detalhes
        System.out.print("Digite o número do curso para ver a descrição (ou 0 para voltar): ");
        int opcao = scanner.nextInt();
        if (0 != opcao) {
            // Chamar método para exibir detalhes do curso
        }
    }
}
