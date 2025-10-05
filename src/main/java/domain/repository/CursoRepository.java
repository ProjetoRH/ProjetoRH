package domain.repository;

import application.dto.curso.*;
import domain.model.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {

    CadastrarCursoResponse cadastrarCurso(Curso curso);

    ExcluirCursoResponse excluirCurso(ExcluirCursoRequest request);

    List<ListarCursoResponse> listarCurso(ListarCursoRequest request);

    List<ListarTodosCursoResponse> listarTodosCurso();

    EditarStatusCursoResponse editarStatusCurso(EditarStatusCursoRequest request);
}
