package application.controller;

import application.dto.inscricao.AtribuirCursoCargoRequest;
import application.dto.inscricao.AtribuirCursoCargoResponse;
import application.dto.inscricao.AtribuirCursoFuncionarioRequest;
import application.dto.inscricao.AtribuirCursoFuncionarioResponse;
import application.service.InscricaoService;

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
}
