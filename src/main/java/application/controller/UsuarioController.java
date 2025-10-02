package application.controller;

import application.dto.usuario.CadastrarUsuarioRequest;
import application.service.UsuarioService;

public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public int cadastrarUsuario(CadastrarUsuarioRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("O Usuario não pode ser nulo");
        } else {
            return usuarioService.cadastrarUsuario(request);
        }
    }
}
