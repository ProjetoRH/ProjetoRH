package view.auth;

import view.funcionario.FuncionarioAdmView;
import view.funcionario.FuncionarioView;
import view.cursos.CursoAdmView;
import view.cursos.CursoView;
import view.utils.ConsoleUtils;

import java.io.Console;

public class LoginView {

    private final String usuarioAdmin = "admin";
    private final String senhaAdmin = "12345";

    public void iniciarLogin(){
        Console console = System.console();

        if (console == null){
            System.out.println("╔════════════════════════════╗");
            System.out.println("║ ERRO                       ║");
            System.out.println("╠════════════════════════════╣");
            System.out.println("║ Não foi possível acessar   ║");
            System.out.println("║ o console                  ║");
            System.out.println("╚════════════════════════════╝");
            return;
        }

        ConsoleUtils.limparTela();
        System.out.println("");
        System.out.println("╔════════════════════════════╗");
        System.out.println("║ SYSTEM DE RH               ║");
        System.out.println("╠════════════════════════════╣");
        System.out.println("║ Bem-vindo! Faça seu login  ║");
        System.out.println("╚════════════════════════════╝");

        String usuario = console.readLine("Usuario: ");
        char[] senhaDigitada = console.readPassword("Senha: ");

        if (usuario.equals(usuarioAdmin) && String.valueOf(senhaDigitada).equals(senhaAdmin)) {
            System.out.println("╔════════════════════════════╗");
            System.out.println("║ Login ADM                  ║");
            System.out.println("╠════════════════════════════╣");
            System.out.println("║ Login de ADM efetuado      ║");
            System.out.println("║ com sucesso!               ║");
            System.out.println("╚════════════════════════════╝");
            abrirMenuAdmin();
        } else{
            System.out.println("╔════════════════════════════╗");
            System.out.println("║ Login Funcionário          ║");
            System.out.println("╠════════════════════════════╣");
            System.out.println("║ Login de funcionário       ║");
            System.out.println("║ efetuado com sucesso!      ║");
            System.out.println("╚════════════════════════════╝");
            abrirMenuFuncionario();
        }
    }

    private void abrirMenuAdmin() {
        FuncionarioAdmView funcAdmView = new FuncionarioAdmView();
        CursoAdmView cursoAdmView = new CursoAdmView();

        funcAdmView.menuAdm();
        cursoAdmView.menuAdmn();
    }

    private void abrirMenuFuncionario() {
        FuncionarioView funcView = new FuncionarioView();
        CursoView cursoView = new CursoView();

        funcView.menuFuncionario();
        cursoView.menuFuncionario();
    }
}
