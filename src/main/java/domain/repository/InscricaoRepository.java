package domain.repository;

import application.dto.curso_funcionario.AtribuirCursoFuncionarioRequest;
import application.dto.curso_funcionario.AtribuirCursoFuncionarioResponse;

public interface InscricaoRepository {

    AtribuirCursoFuncionarioResponse atribuirCursoFuncionario(AtribuirCursoFuncionarioRequest request);
}
