package org.gestaoRH.utils;

import java.util.Scanner;

public class LerVariaveis {

    public static int lerInteiro(Scanner input, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            String texto = input.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("\u001B[31mErro: Este campo não pode estar vazio.\u001B[0m");
                continue;
            }

            try {
                int valor = Integer.parseInt(texto);
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mErro: Digite um número inteiro válido.\u001B[0m");
            }
        }
    } //fecha lerInteiro()

    public static String lerTexto(Scanner input, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = input.nextLine().trim();
            if (texto.isEmpty() || texto.equalsIgnoreCase(null)) {
                System.out.println("\u001B[31mErro: Este campo não pode estar vazio.\u001B[0m");
                continue;
            }
            return texto;
        }
    } //fecha lerTexto()

    public static double lerDouble(Scanner input, String mensagem) {
        while (true) {
            System.out.print(mensagem);

            String texto = input.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("\u001B[31mErro: Este campo não pode estar vazio.\u001B[0m");
                continue;
            }

            try {
                double valor = Double.parseDouble(texto);
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("\u001B[31mErro: Digite um número válido (ex: 2500.50).\u001B[0m");
            }
        }
    } //fecha lerDouble()

}