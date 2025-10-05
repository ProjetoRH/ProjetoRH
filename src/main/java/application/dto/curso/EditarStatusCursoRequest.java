package application.dto.curso;

import domain.model.enums.StatusCurso;

public record EditarStatusCursoRequest(
        int idCurso,
        StatusCurso status
) {
}
