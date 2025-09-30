package org.gestaoRH.view;

import java.util.Scanner;

public class MenuOpcoes {
    private Scanner input;

    public MenuOpcoes(Scanner input) {
        this.input = input;
    }

    public int menuPrincipal(int opcaoMenu) {

        System.out.print("\n\u001B[35m-------------------------- Sistema RH - Gestão de Funcionários --------------------------\u001B[0m\n" +
                "\n1. Cadastrar Funcionário\n" +
                "2. Listar Funcionários\n" +
                "3. Buscar Funcionário\n" +
                "4. Remover Funcionário\n" +
                "5. Atualizar Informações\n" +
                "6. Gerenciar Status\n" +
                "7. Voltar\n" +
                "\nDigite a opção desejada: ");

        String escolha = input.nextLine();

        try {
            opcaoMenu = Integer.parseInt(escolha);
        } catch (NumberFormatException e){
            System.out.println("\n\u001B[31mOpção inválida! Digite apenas números de 0 a 7.\u001B[0m\n");
        }

        return opcaoMenu;
    }

}