package application.service;

import application.dto.relatorio.RelatorioCursoParticipantePendenteResponse;
import application.dto.relatorio.RelatorioCursoParticipantesResponse;
import application.dto.relatorio.RelatorioGeralCursoResponse;
import domain.repository.RelatorioRepository;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class RelatorioService {

    private final RelatorioRepository relatorioRepository;

    public RelatorioService(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public List<RelatorioGeralCursoResponse> relatorioGeralCurso() {
        try {
            return relatorioRepository.relatorioGeralCurso();
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório geral de cursos: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public RelatorioCursoParticipantesResponse relatorioCursoParticipantes(int idCurso) {
        if (idCurso == 0) {
            throw new IllegalArgumentException("O Identificador do Curso não Pode ser Nulo.");
        }
        try {
            return relatorioRepository.relatorioCursoParticipantes(idCurso);
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório de participantes do curso: " + e.getMessage());
            return null;
        }
    }

    public RelatorioCursoParticipantePendenteResponse relatorioCursoParticipantesPendentes(int idCurso) {
        if (idCurso == 0) {
            throw new IllegalArgumentException("O Identificador do Curso não Pode ser Nulo.");
        }
        try {
            return relatorioRepository.relatorioCursoParticipantesPendentes(idCurso);
        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório de pendentes do curso: " + e.getMessage());
            return null;
        }
    }
}