package application.service;

import application.dto.cargo.CadastrarCargoRequest;
import application.dto.funcionario.*;
import application.dto.usuario.CadastrarUsuarioRequest;
import application.mapper.FuncionarioMapper;
import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;
import shared.util.SenhaUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioMapper mapper;
    private final UsuarioService usuarioService;
    private final CargoService cargoService;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, FuncionarioMapper mapper, UsuarioService usuarioService, CargoService cargoService) {
        this.funcionarioRepository = funcionarioRepository;
        this.mapper = mapper;
        this.usuarioService = usuarioService;
        this.cargoService = cargoService;
    }


    public CadastrarFuncionarioResponse cadastrarFuncionario(FuncionarioControllerRequest request) throws SQLException {

        if (request == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }

        // Gerar senha automática para o novo usuário
        String senhaGerada = SenhaUtil.geraSenha();
        CadastrarUsuarioRequest usuarioRequest = new CadastrarUsuarioRequest(request.email(), senhaGerada);
        int idUsuario = usuarioService.cadastrarUsuario(usuarioRequest);
        if (idUsuario <= 0) {
            throw new IllegalStateException("Usuário não foi cadastrado corretamente.");
        }

        CadastrarCargoRequest cargoRequest = new CadastrarCargoRequest(request.cargo(), request.departamento());
        int idCargo = cargoService.buscarOuCadastrarCargo(cargoRequest);
        if (idCargo <= 0) {
            throw new IllegalStateException("Cargo não foi cadastrado corretamente.");
        }

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(request.nome());
        funcionario.setTelefone(request.telefone());
        funcionario.setEmail(request.email());
        funcionario.setIdCargo(idCargo);
        funcionario.setIdUsuario(idUsuario);

        int idFuncionario = funcionarioRepository.cadastrarFuncionario(funcionario);
        if (idFuncionario <= 0) {
            throw new IllegalStateException("Funcionário não foi cadastrado corretamente.");
        }

        return mapper.toResponse(funcionario, idFuncionario);
    }

    public void cadastrarMultiplosFuncionarios(List<FuncionarioControllerRequest> request) throws SQLException {

        if (request == null) {
            throw new IllegalArgumentException("Os Funcionarios Não Podem ser Nulos.");
        }

        for(FuncionarioControllerRequest r : request) {
            cadastrarFuncionario(r);
        }
    }

    public List<ListarTodosFuncionarioResponse> listarTodosFuncionarios() {
        return funcionarioRepository.listarTodosFuncionarios();
    }

    public void editarFuncionarioFuncionario(EditarFuncionarioRequest request) throws SQLException {
        funcionarioRepository.editarFuncionario(request);
    }

    public ExcluirFuncionariosResponse excluirFuncionario(ExcluirFuncionarioRequest request) {
        if(request == null) {
            throw new IllegalArgumentException("O Funcionario Não Pode ser Nulo");
        }

        return funcionarioRepository.excluirFuncionario(request);
    }
}
