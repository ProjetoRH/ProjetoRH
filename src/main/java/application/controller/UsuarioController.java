package application.controller;

import application.service.UsuarioService;
import domain.model.Usuario;

public class UsuarioController {

     private UsuarioService usuarioService;

    public void cadastrarUsuario(Usuario usuario) {

        usuarioService.cadastrarUsuario(usuario);
    }
}
