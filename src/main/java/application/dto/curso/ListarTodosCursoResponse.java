package application.dto.curso;

import domain.model.enums.StatusCurso;

public record ListarTodosCursoResponse(
        int idCurso,
		String nome,
        StatusCurso status
) {
}
