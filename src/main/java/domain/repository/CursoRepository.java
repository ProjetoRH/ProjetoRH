package domain.repository;

import domain.model.Curso;
import domain.model.Funcionario;

import java.util.Optional;

public interface CursoRepository {

    void cadastrarCurso(Curso curso);

    Optional<Curso> buscarCurso(Curso curso);

    void desativarCurso(int id);

    Optional<Curso> listarCurso();
}
