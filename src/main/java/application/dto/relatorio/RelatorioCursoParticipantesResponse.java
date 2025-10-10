package application.dto.relatorio;

import domain.model.enums.StatusCurso;

import java.util.List;

public record RelatorioCursoParticipantesResponse(
        String nomeCurso,
        StatusCurso statusCurso,
        List<ParticipanteCursoResponse> participantes
) {
}
