package application.service;

import domain.model.Funcionario;
import domain.repository.CargoRepository;
import domain.repository.FuncionarioRepository;
import infrastructure.persistence.CargoRepositoryImpl;
import shared.util.SenhaUtil;
import domain.model.Usuario;
import application.mapper.FuncionarioParaUsuarioMapper;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final CargoRepository cargoRepository;
    private final UsuarioService usuarioService;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, CargoRepository cargoRepository, UsuarioService usuarioService) {
        this.funcionarioRepository = funcionarioRepository;
        this.cargoRepository = new CargoRepositoryImpl();
        this.usuarioService = usuarioService;
    }

    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException {

        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo.");
        }

        int idCargo = cargoRepository.buscarIdCargo(funcionario.getCargo(), funcionario.getDepartamento());

        if (idCargo <= 0) {
            idCargo = cargoRepository.cadastrarCargo(funcionario.getCargo(), funcionario.getDepartamento());
        }

        FuncionarioParaUsuarioMapper mapper = new FuncionarioParaUsuarioMapper();
        Usuario usuario = mapper.convert(funcionario);

        int idUsuario = usuarioService.cadastrarUsuario(funcionario);

        funcionarioRepository.cadastrarFuncionario(funcionario, idCargo, idUsuario);
    }

    public void cadastrarMultiplosFuncionarios(List<Funcionario> funcionarios) throws SQLException {

        if(funcionarios == null) {
            throw new IllegalArgumentException("Os Funcionarios Não Podem ser Nulos.");
        }

        for(Funcionario f : funcionarios) {
            cadastrarFuncionario(f);
        }
    }
}
