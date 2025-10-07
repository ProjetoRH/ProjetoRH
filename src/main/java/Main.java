import shared.util.SenhaUtil;
import view.GerenciarFuncionariosView;
import view.LoginView;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        while (true) {
            new GerenciarFuncionariosView().exibir();
        }


       // String senha_texto = SenhaUtil.geraSenha();

     //   System.out.println(senha_texto);

       // String senha_texto2 = SenhaUtil.hashSenha( senha_texto );

        //System.out.println(senha_texto2);

       /* while (true) {
            new LoginView().exibir();
        }

        */
    }
}