package application.dto;

import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;

public record CadastrarFuncionarioRequest(
        String nome,
        Email email,
        Telefone telefone,
        String cargo,
        String setor
) { }
