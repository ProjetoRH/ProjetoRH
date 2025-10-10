package application.controller;

import application.dto.curso.DetalheCursoResponse;
import application.dto.curso.ListarMeusCursosResponse;
import application.dto.inscricao.AtribuirCursoCargoRequest;
import application.dto.inscricao.AtribuirCursoCargoResponse;
import application.dto.inscricao.AtribuirCursoFuncionarioRequest;
import application.dto.inscricao.AtribuirCursoFuncionarioResponse;
import application.service.InscricaoService;

import java.sql.SQLException;
import java.util.List;

public class InscricaoController {

    private final InscricaoService inscricaoService;

    public InscricaoController(InscricaoService inscricaoService) {
        this.inscricaoService = inscricaoService;
    }

    public AtribuirCursoFuncionarioResponse atribuirCursoFuncionario(AtribuirCursoFuncionarioRequest request) {
        return inscricaoService.atribuirCursoFuncionario(request);
    }

    public AtribuirCursoCargoResponse atribuirCursoCargo(AtribuirCursoCargoRequest request) {
        return inscricaoService.atribuirCursoCargo(request);
    }

    public List<ListarMeusCursosResponse> listarMeusCursos(int idFuncionario) throws SQLException {
        return inscricaoService.listarCursosDoFuncionario(idFuncionario);
    }



    public DetalheCursoResponse detalharMeuCurso(int idFuncionario, int idCurso) throws SQLException {
        return inscricaoService.consultarDetalheCurso(idFuncionario, idCurso);
    }
}
