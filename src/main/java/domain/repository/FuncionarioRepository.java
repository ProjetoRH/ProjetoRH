package domain.repository;

import domain.model.Funcionario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {

    int cadastrarFuncionario(Funcionario funcionario) throws SQLException;

    void cadastrarMultiplosFuncionarios(List<Funcionario> funcionarios, int idCargo, int idUsuario) throws SQLException;

    Optional<Funcionario> buscarFuncionario(int id);

    void desativarFuncionario(int id);

    Optional<Funcionario> listarFuncionario();
}
