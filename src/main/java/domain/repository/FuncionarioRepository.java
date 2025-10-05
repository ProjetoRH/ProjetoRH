package domain.repository;

import application.dto.curso.ListarTodosCursoResponse;
import application.dto.funcionario.ExcluirFuncionarioRequest;
import application.dto.funcionario.ExcluirFuncionariosResponse;
import application.dto.funcionario.ListarTodosFuncionarioResponse;
import domain.model.Funcionario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository {

    int cadastrarFuncionario(Funcionario funcionario) throws SQLException;

    void cadastrarMultiplosFuncionarios(List<Funcionario> funcionarios, int idCargo, int idUsuario) throws SQLException;

    List<ListarTodosFuncionarioResponse> listarTodosFuncionarios();

    ExcluirFuncionariosResponse excluirFuncionario(ExcluirFuncionarioRequest request);

}
