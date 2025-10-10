import shared.util.SenhaUtil;
import view.GerenciarCursosView;
import view.GerenciarFuncionariosView;
import view.LoginView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

            while (true) {
                new GerenciarFuncionariosView().exibir();
            }

        }
}