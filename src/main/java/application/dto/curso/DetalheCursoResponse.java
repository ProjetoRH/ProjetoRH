package application.dto.curso;

public record DetalheCursoResponse(
        int idCurso,
        String nomeCurso,
        String descricao,
        String statusPessoal,
        String statusGeral
) {}