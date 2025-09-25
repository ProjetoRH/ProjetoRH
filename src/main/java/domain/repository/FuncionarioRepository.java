package domain.repository;

import domain.model.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository {

    void cadastrarFuncionario(Funcionario funcionario);

    Optional<Funcionario> buscarFuncionario(int id);

    void desativarFuncionario(int id);

    Optional<Funcionario> listarFuncionario();
}
