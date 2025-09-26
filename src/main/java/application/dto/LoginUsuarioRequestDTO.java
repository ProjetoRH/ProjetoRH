package application.dto;

import domain.model.valueobjects.Email;

public record LoginUsuarioRequestDTO(
        Email email,
        String senha
) { }
