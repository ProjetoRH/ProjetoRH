package application.dto.curso;

import domain.model.enums.StatusCurso;
import domain.model.enums.StatusCursoPessoal;

import java.time.LocalDate;

public record ListarCursoFuncionarioResponse(
        int idCurso,
        String nomeCurso,
        StatusCursoPessoal statusPessoa,
        StatusCurso statusCurso,
        LocalDate dataTermino
) {
}
