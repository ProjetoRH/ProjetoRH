package application.controller;

import application.dto.funcionario.CadastrarFuncionarioResponse;
import application.dto.funcionario.FuncionarioControllerRequest;
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



        return funcionarioService.cadastrarFuncionario(request);
    }
}
