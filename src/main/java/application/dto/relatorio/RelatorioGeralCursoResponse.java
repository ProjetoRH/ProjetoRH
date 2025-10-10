package application.dto.relatorio;

import domain.model.enums.StatusCurso;

public record RelatorioGeralCursoResponse(
        String nomeCurso,
        StatusCurso statusCurso,
        int totalInscritos,
        int totalConcluidos,
        int totalPendentes
) {
}
