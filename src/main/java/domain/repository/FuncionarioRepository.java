package domain.repository;

import domain.model.Funcionario;

import java.sql.SQLException;
import java.util.Optional;

public interface FuncionarioRepository {

    void cadastrarFuncionario(Funcionario funcionario, int idCargo, int idUsuario) throws SQLException;

    Optional<Funcionario> buscarFuncionario(int id);

    void desativarFuncionario(int id);

    Optional<Funcionario> listarFuncionario();
}
