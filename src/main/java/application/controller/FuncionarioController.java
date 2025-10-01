package application.controller;

import application.dto.*;
import application.service.CargoService;
import application.service.FuncionarioService;
import application.service.UsuarioService;

import java.sql.SQLException;

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

        if (request == null) {
            throw new IllegalArgumentException("O Fúncionario não pode ser nulo");
        }

        CadastrarUsuarioRequest usuarioRequest = new CadastrarUsuarioRequest(
                request.email()
        );

        int idUsuario = usuarioService.cadastrarUsuario(usuarioRequest);

        CadastrarCargoRequest cargoRequest = new CadastrarCargoRequest(
                request.cargo(),
                request.departamento()
        );

        int idCargo = cargoService.buscarOuCadastrarCargo(cargoRequest);

        if (idUsuario <= 0 || idCargo <= 0) {
            throw new IllegalStateException("Usuario ou Cargo não foi Resolvido.");
        }

        CadastrarFuncionarioRequest cadastrarFuncionarioRequest = new CadastrarFuncionarioRequest(
                request.nome(),
                request.email(),
                request.telefone(),
                idCargo,
                idUsuario
        );


        return funcionarioService.cadastrarFuncionario(cadastrarFuncionarioRequest);
    }
}
