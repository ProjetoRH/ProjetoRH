package application.mapper;

import application.dto.LoginUsuarioRequest;
import domain.model.Usuario;

public class UsuarioMapper {

    public Usuario toEntity(LoginUsuarioRequest loginUsuarioRequestDTO) {
        return new Usuario(loginUsuarioRequestDTO.email(), loginUsuarioRequestDTO.senha());
    }
}
