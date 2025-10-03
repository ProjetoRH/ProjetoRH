package application.controller;

import application.dto.curso.*;
import application.service.CursoService;
import shared.exceptions.CursoException;

import java.util.List;

public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    public CadastrarCursoResponse cadastrarCurso(CadastrarCursoRequest request) {
        return cursoService.cadastrarCurso(request);
    }

    public ExcluirCursoResponse excluirCurso(ExcluirCursoRequest request) {
        return cursoService.excluirCurso(request);
    }

    public List<ListarCursoResponse> listarCurso(ListarCursoRequest request) {
        return cursoService.listarCurso(request);
    }

    public List<ListarTodosCursoResponse> listarTodosCurso() {
        return cursoService.listarTodosCurso();
    }

}
