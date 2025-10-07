package application.controller;

import application.dto.funcionario.*;
import application.dto.curso.ListarMeusCursosResponse;
import application.dto.curso.DetalheCursoResponse;
import application.service.CargoService;
import application.service.FuncionarioService;
import application.service.UsuarioService;
import application.service.InscricaoService;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FuncionarioController {

    private final UsuarioService usuarioService;
    private final CargoService cargoService;
    private final FuncionarioService funcionarioService;
    private final InscricaoService inscricaoService;

    public FuncionarioController(UsuarioService usuarioService,
                                 CargoService cargoService,
                                 FuncionarioService funcionarioService,
                                 InscricaoService inscricaoService) {

        this.usuarioService = usuarioService;
        this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.inscricaoService = inscricaoService;
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

    // Lista os cursos do funcionário (retorna DTOs de resposta)
    public List<ListarMeusCursosResponse> listarMeusCursos(int idFuncionario) throws SQLException {
        return inscricaoService.listarCursosDoFuncionario(idFuncionario);
    }

    // Retorna detalhe de um curso para o funcionário
    public DetalheCursoResponse detalharCurso(int idFuncionario, int idCurso) throws SQLException {
        return inscricaoService.consultarDetalheCurso(idFuncionario, idCurso);
    }

}
