package application.mapper;

import application.dto.curso.CadastrarCursoRequest;
import application.dto.curso.CadastrarCursoResponse;
import domain.model.Curso;

public class CursoMapper {

    public Curso toEntity(CadastrarCursoRequest request) {
        Curso curso = new Curso(request.nome(), request.descricao(), request.data_termino());

        return curso;
    }
}
