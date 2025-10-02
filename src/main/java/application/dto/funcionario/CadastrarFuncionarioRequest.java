package application.dto.funcionario;

import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;

public record CadastrarFuncionarioRequest(
        String nome,
        Email email,
        Telefone telefone,
        int idCargo,
        int idUsuario
) {
}
