package domain.repository;

import domain.model.Curso;
import domain.model.Funcionario;

import java.util.Optional;

public interface CursoRepository {

    void cadastrarCurso(Curso curso);

    Optional<Funcionario> buscarCurso(Curso curso);

    void desativarCurso(int id);

    Optional<Funcionario> listarCurso();
}
