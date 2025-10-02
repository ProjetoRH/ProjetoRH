package application.dto.funcionario;

import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;

public record CadastrarFuncionarioExcelRequest(
        String nome,
        Email email,
        Telefone telefone,
        String cargo,
        String departamento
) {
}
