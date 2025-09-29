package application.dto;

import domain.model.valueobjects.Email;

public record LoginUsuarioRequest(
        Email email,
        String senha
) { }
