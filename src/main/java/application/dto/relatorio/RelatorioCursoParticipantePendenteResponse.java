package application.dto.relatorio;

import domain.model.enums.StatusCurso;

import java.util.List;

public record RelatorioCursoParticipantePendenteResponse(
        String nomeCurso,
        StatusCurso statusCurso,
        List<ParticipanteCursoPendenteResponse> participantes
) {
}
