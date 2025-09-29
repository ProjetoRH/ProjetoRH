package domain.repository;

import domain.model.Curso;
import domain.model.Funcionario;

import java.util.List;
import java.util.Optional;

public interface CursoRepository {

    void cadastrarCurso(Curso curso);

    void atualizarStatus(Curso curso);

    Optional<Curso> buscarCurso(Curso curso);

    void desativarCurso(int id);

    List<Curso> listarCurso();
}
