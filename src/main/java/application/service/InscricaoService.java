package application.service;

import application.dto.inscricao.AtribuirCursoCargoRequest;
import application.dto.inscricao.AtribuirCursoCargoResponse;
import application.dto.inscricao.AtribuirCursoFuncionarioRequest;
import application.dto.inscricao.AtribuirCursoFuncionarioResponse;
import application.dto.curso.ListarMeusCursosResponse;
import application.dto.curso.DetalheCursoResponse;
import domain.repository.InscricaoRepository;
import shared.exceptions.InscricaoInvalidaException;
import shared.util.ValidacaoUtil;

import java.sql.SQLException;
import java.util.List;

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

    public AtribuirCursoCargoResponse atribuirCursoCargo(AtribuirCursoCargoRequest request) {
        if(request == null) {
            throw new InscricaoInvalidaException("A Inscrição Não Pode Ser Nula.");
        }

        ValidacaoUtil.checarObrigatoriedade(request.idCurso(), "Identificador do Curso");
        ValidacaoUtil.checarObrigatoriedade(request.nomeCargo(),  "Nome do Cargo");

        return inscricaoRepository.atribuirCursoCargo(request);
    }

    // Lista os cursos do funcionário com status pessoal e geral
    public List<ListarMeusCursosResponse> listarCursosDoFuncionario(int idFuncionario) throws SQLException {
        ValidacaoUtil.checarObrigatoriedade(idFuncionario, "Identificador do Funcionário");
        return inscricaoRepository.buscarCursosPorFuncionario(idFuncionario);
    }

    // Consulta detalhe de um curso para o funcionário
    public DetalheCursoResponse consultarDetalheCurso(int idFuncionario, int idCurso) throws SQLException {
        ValidacaoUtil.checarObrigatoriedade(idFuncionario, "Identificador do Funcionário");
        ValidacaoUtil.checarObrigatoriedade(idCurso, "Identificador do Curso");
        return inscricaoRepository.buscarDetalheCursoDoFuncionario(idFuncionario, idCurso);
    }
}
