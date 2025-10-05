package domain.repository;

import application.dto.inscricao.AtribuirCursoCargoRequest;
import application.dto.inscricao.AtribuirCursoCargoResponse;
import application.dto.inscricao.AtribuirCursoFuncionarioRequest;
import application.dto.inscricao.AtribuirCursoFuncionarioResponse;
import application.dto.curso.CursoStatusDTO;
import application.dto.curso.CursoDetalheDTO;
import application.dto.curso.ListarMeusCursosResponse;
import application.dto.curso.DetalheCursoResponse;

import java.sql.SQLException;
import java.util.List;

public interface InscricaoRepository {

    AtribuirCursoFuncionarioResponse atribuirCursoFuncionario(AtribuirCursoFuncionarioRequest request);

    AtribuirCursoCargoResponse atribuirCursoCargo(AtribuirCursoCargoRequest request);

    // Busca todos os cursos associados ao funcionário, com status pessoal e geral
    List<ListarMeusCursosResponse> buscarCursosPorFuncionario(int idFuncionario) throws SQLException;

    // Busca detalhe de um curso específico para um funcionário
    DetalheCursoResponse buscarDetalheCursoDoFuncionario(int idFuncionario, int idCurso) throws SQLException;
}
