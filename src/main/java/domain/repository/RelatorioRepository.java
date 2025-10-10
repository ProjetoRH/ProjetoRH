package domain.repository;

import application.dto.relatorio.RelatorioCursoParticipantePendenteResponse;
import application.dto.relatorio.RelatorioCursoParticipantesResponse;
import application.dto.relatorio.RelatorioGeralCursoResponse;

import java.sql.SQLException;
import java.util.List;

public interface RelatorioRepository {

    List<RelatorioGeralCursoResponse> relatorioGeralCurso() throws SQLException;

    RelatorioCursoParticipantesResponse relatorioCursoParticipantes(int idCurso) throws SQLException;

    RelatorioCursoParticipantePendenteResponse relatorioCursoParticipantesPendentes(int idCurso) throws SQLException;
}
