package application.mapper;

import application.dto.usuario.CadastrarUsuarioRequest;
import application.dto.usuario.LoginUsuarioRequest;
import domain.model.Usuario;

public class UsuarioMapper {

    public Usuario toEntity(CadastrarUsuarioRequest request) {
        // Como não há senha no DTO, passar null (ou gere a senha depois)
        return new Usuario(request.email(), null);
    }

    public Usuario toEntity(LoginUsuarioRequest request) {
        return new Usuario(request.email(), request.senha());
    }
}
