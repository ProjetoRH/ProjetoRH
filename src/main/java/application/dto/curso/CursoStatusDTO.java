package application.dto.curso;

public record CursoStatusDTO(
        int idCurso,
        String nomeCurso,
        String statusPessoal,
        String statusGeral
) {}