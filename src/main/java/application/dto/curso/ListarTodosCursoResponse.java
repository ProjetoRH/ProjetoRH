package application.dto.curso;

import domain.model.enums.StatusCurso;

public record ListarTodosCursoResponse(
        String nome,
        StatusCurso status
) {
}
