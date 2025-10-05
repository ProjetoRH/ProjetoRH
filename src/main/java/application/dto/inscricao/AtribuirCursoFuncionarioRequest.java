package application.dto.inscricao;

import java.util.List;

public record AtribuirCursoFuncionarioRequest(
        int idCurso,
        List<Integer> idFuncionarios
) { }
