package application.mapper;

import application.dto.CadastrarFuncionarioRequest;
import application.dto.CadastrarFuncionarioResponse;
import domain.model.Funcionario;

public class FuncionarioMapper {

    public Funcionario toEntity(CadastrarFuncionarioRequest request) {

        return new Funcionario(
                request.nome(),
                request.email(),
                request.telefone()
        );
    }

    public CadastrarFuncionarioResponse toResponse(Funcionario funcionario, int idFuncionario) {

        return new CadastrarFuncionarioResponse(
                funcionario.getEmail(),
                idFuncionario

        );

    }
}
