package application.dto.curso;

import domain.model.enums.StatusCurso;

public record ListarCursoResponse(
        String nome,
        StatusCurso status
) {
}
