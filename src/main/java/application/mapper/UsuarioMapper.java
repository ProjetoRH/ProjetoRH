package application.mapper;

import application.dto.LoginUsuarioRequestDTO;
import domain.model.Usuario;

public class UsuarioMapper {

    public Usuario toEntity(LoginUsuarioRequestDTO loginUsuarioRequestDTO) {
        return new Usuario(loginUsuarioRequestDTO.email(), loginUsuarioRequestDTO.senha());
    }
}
