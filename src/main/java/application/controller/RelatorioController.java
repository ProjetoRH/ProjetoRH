package application.controller;

import application.dto.relatorio.RelatorioCursoParticipantePendenteResponse;
import application.dto.relatorio.RelatorioCursoParticipantesResponse;
import application.dto.relatorio.RelatorioGeralCursoResponse;
import application.service.RelatorioService;

import java.sql.SQLException;
import java.util.List;

public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    public List<RelatorioGeralCursoResponse> relatorioGeralCurso() throws SQLException {
        return relatorioService.relatorioGeralCurso();
    }

    public RelatorioCursoParticipantesResponse relatorioCursoParticipantes(int idCurso) throws SQLException {
        return relatorioService.relatorioCursoParticipantes(idCurso);
    }

    public RelatorioCursoParticipantePendenteResponse relatorioCursoParticipantePendente(int idCurso) throws SQLException {
        return relatorioService.relatorioCursoParticipantesPendentes(idCurso);
    }
}
