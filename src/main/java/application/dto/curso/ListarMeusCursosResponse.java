package application.dto.curso;

public record ListarMeusCursosResponse(
        int idCurso,
        String nomeCurso,
        String statusPessoal,
        String statusGeral

) {}