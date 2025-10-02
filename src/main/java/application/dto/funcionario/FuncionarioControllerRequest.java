package application.dto.funcionario;

import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;

public record FuncionarioControllerRequest(
        String nome,
        Email email,
        Telefone telefone,
        String cargo,
        String departamento
) {
}
