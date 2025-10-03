package application.service;

import application.dto.curso_funcionario.AtribuirCursoFuncionarioRequest;
import application.dto.curso_funcionario.AtribuirCursoFuncionarioResponse;
import domain.repository.InscricaoRepository;
import shared.exceptions.InscricaoInvalidaException;

public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;

    public InscricaoService(InscricaoRepository inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    public AtribuirCursoFuncionarioResponse atribuirCursoFuncionario(AtribuirCursoFuncionarioRequest request) {
    if(request == null) {
        throw new InscricaoInvalidaException("A Inscrição Não Pode Ser Nula.");
    }

    return inscricaoRepository.atribuirCursoFuncionario(request);
    }
}

