import view.LoginView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Iniciando Sistema de Gestão de RH...");

        LoginView loginView = new LoginView();

        loginView.exibir();

        System.out.println("Sistema encerrado.");
    }
}