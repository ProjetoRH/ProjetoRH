package application.dto.relatorio;

import domain.model.enums.StatusCursoPessoal;

public record ParticipanteCursoPendenteResponse(
        String nomeFuncionario,
        String nomeCargo,
        StatusCursoPessoal statusCursoPessoal
) {
}
