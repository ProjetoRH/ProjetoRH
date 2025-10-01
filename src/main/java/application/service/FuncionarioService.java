package application.service;

import application.dto.CadastrarFuncionarioRequest;
import application.dto.CadastrarFuncionarioResponse;
import application.mapper.FuncionarioMapper;
import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper mapper;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper mapper) {
        this.funcionarioRepository = funcionarioRepository;
        this.mapper = mapper;
    }


    public CadastrarFuncionarioResponse cadastrarFuncionario(CadastrarFuncionarioRequest request) throws SQLException {

        if (request == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }

        Funcionario funcionario = mapper.toEntity(request);

        int idFuncionario = funcionarioRepository.cadastrarFuncionario(funcionario, request.idCargo(), request.idUsuario());

        return mapper.toResponse(funcionario, idFuncionario);
    }

    public void cadastrarMultiplosFuncionarios(List<Funcionario> funcionarios) throws SQLException {

        if (funcionarios == null) {
            throw new IllegalArgumentException("Os Funcionarios Não Podem ser Nulos.");
        }
    }
}
