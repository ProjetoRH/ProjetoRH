package application.controller;

import application.service.UsuarioService;
import domain.model.Funcionario;
import domain.model.Usuario;

public class UsuarioController {

     private UsuarioService usuarioService;

    public void cadastrarUsuario(Funcionario funcionario) {

        usuarioService.cadastrarUsuario(funcionario);
    }
}
