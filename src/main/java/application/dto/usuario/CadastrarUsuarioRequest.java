package application.dto.usuario;

import domain.model.valueobjects.Email;

public record CadastrarUsuarioRequest(Email email) {
}
