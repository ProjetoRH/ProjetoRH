package org.gestaoRH.app;


import org.gestaoRH.controller.Controller;
import org.gestaoRH.service.Service;
import org.gestaoRH.view.InteracaoUsuario;
import org.gestaoRH.view.MensagensSistema;
import org.gestaoRH.view.MenuOpcoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

       /* ----------------------------------------------- TESTE DE CONEXÃO COM O BANCO

       try (Connection conn = Conexao.conectar()) {
           if (conn != null) {
               System.out.println("\u001b[34mConexão realizada com sucesso!\u001b[0m");
           } else {
               System.out.println("\u001b[31mFalha na conexão.\u001b[0m");
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

        */

        try {

            Scanner input = new Scanner(System.in);
            MenuOpcoes menuView = new MenuOpcoes(input);
            InteracaoUsuario interacaoView = new InteracaoUsuario(input);
            MensagensSistema mensagensView = new MensagensSistema();
            Service service = new Service();
            Controller control = new Controller(menuView, interacaoView, mensagensView, service);
            control.iniciar();
            input.close();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }
}