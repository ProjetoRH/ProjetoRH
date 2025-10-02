package application.mapper;

import application.dto.usuario.CadastrarUsuarioRequest;
import domain.model.Usuario;

public class UsuarioMapper {

    public Usuario toEntity(CadastrarUsuarioRequest request) {
        return new Usuario(request.email(), request.senha());
    }
}
