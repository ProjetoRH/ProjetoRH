package application.dto.curso_funcionario;

import java.util.List;

public record AtribuirCursoFuncionarioRequest(
        int idCurso,
        List<Integer> idFuncionarios
) { }
