package application.service;

import application.dto.usuario.CadastrarUsuarioRequest;
import application.mapper.UsuarioMapper;
import domain.model.Usuario;
import domain.repository.UsuarioRepository;
import infrastructure.persistence.UsuarioRepositoryImpl;
import shared.util.SenhaUtil;

public class UsuarioService {

    private final UsuarioMapper mapper = new UsuarioMapper();
    private final UsuarioRepository usuarioRepository = new UsuarioRepositoryImpl();


    public int cadastrarUsuario(CadastrarUsuarioRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }

        Usuario usuario = mapper.toEntity(request);

        System.out.println("DEBUG senha: " + usuario.getSenha());

        String senhaHash = SenhaUtil.hashSenha(usuario.getSenha());
        usuario.setSenha(senhaHash);

        return usuarioRepository.cadastrarUsuario(usuario);
    }

    public boolean validarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Úsuario não pode ser nulo.");
        }

        return true;
    }
}
