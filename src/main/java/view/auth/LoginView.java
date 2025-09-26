package view.auth;

import view.funcionario.FuncionarioAdmView;
import view.funcionario.FuncionarioView;
import view.cursos.CursoAdmView;
import view.cursos.CursoView;

import java.io.Console;

public class LoginView {

    private final String usuarioAdmin = "admin";
    private final String senhaAdmin = "12345";

    public void iniciarLogin(){
        Console console = System.console();

        if (console == null){
            System.out.print("ERRO! Não foi possível obter acesso ao console");
            return;
        }

        System.out.println("=== SYSTEM DE RH ===");

        String usuario = console.readLine("Usuario: ");
        char[] senhaDigitada = console.readPassword("Senha: ");

        if (usuario.equals(usuarioAdmin) && String.valueOf(senhaDigitada).equals(senhaAdmin)) {
            System.out.println("Login de ADM efetuado com sucesso!");
            abrirMenuAdmin();
        } else{
            System.out.println("Login de funcionario efetuado com sucesso!");
            abrirMenuFuncionario();
        }
        System.out.println("=====================");

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
