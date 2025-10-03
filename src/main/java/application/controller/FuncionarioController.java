package application.controller;

import application.dto.funcionario.*;
import application.service.CargoService;
import application.service.FuncionarioService;
import application.service.UsuarioService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FuncionarioController {

    private final UsuarioService usuarioService;
    private final CargoService cargoService;
    private final FuncionarioService funcionarioService;

    public FuncionarioController(UsuarioService usuarioService,
                                 CargoService cargoService,
                                 FuncionarioService funcionarioService) {

        this.usuarioService = usuarioService;
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
    }


    public CadastrarFuncionarioResponse cadastrarFuncionario(FuncionarioControllerRequest request) throws SQLException {

        return funcionarioService.cadastrarFuncionario(request);
    }

    public List<ListarTodosFuncionarioResponse> listarTodosFuncionarios() {
        return funcionarioService.listarTodosFuncionarios();
    }

    public ExcluirFuncionariosResponse excluirFuncionario(ExcluirFuncionarioRequest request) {
        return funcionarioService.excluirFuncionario(request);
    }
}
