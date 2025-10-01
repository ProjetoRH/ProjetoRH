package application.dto;

import domain.model.valueobjects.Email;

public record CadastrarFuncionarioResponse(Email email, int idFuncionario) {
}
