package application.dto.curso;

import java.sql.Date;

public record CadastrarCursoRequest(
        String nome,
        String descricao,
        Date data_termino
) { }
