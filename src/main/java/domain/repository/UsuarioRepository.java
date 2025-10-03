package domain.repository;

import application.dto.usuario.LoginUsuarioRequest;
import domain.model.Usuario;
import domain.model.valueobjects.Email;

public interface UsuarioRepository {

    public int cadastrarUsuario(Usuario usuario);

    public Usuario buscarPorEmail(Email email);
}
