package application.dto.relatorio;

import domain.model.enums.StatusCursoPessoal;

public record ParticipanteCursoResponse(
        String nomeFuncionario,
        String nomeCargo,
        StatusCursoPessoal statusCursoPessoal
) {
}
