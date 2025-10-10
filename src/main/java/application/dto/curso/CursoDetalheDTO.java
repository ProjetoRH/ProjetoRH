package application.dto.curso;

public record CursoDetalheDTO(
        int idCurso,
        String nomeCurso,
        String descricaoCompleta,
        String statusPessoal,
        String statusGeral
) {}