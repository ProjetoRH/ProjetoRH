package infrastructure.persistence;

import application.dto.funcionario.ExcluirFuncionarioRequest;
import application.dto.funcionario.ExcluirFuncionariosResponse;
import application.dto.funcionario.ListarTodosFuncionarioResponse;
import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 public class FuncionarioRepositoryImpl implements FuncionarioRepository {

     public int cadastrarFuncionario(Funcionario funcionario) throws SQLException {
         String query = """
            INSERT INTO Funcionario (nome_funcionario, email_funcionario, telefone, id_cargo, id_usuario)
            VALUES (?, ?, ?, ?, ?)
        """;

         try (Connection conn = ConexaoFactory.conectar();
              PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

             stmt.setString(1, funcionario.getNome());
             stmt.setString(2, funcionario.getEmail().obterEmail());
             stmt.setString(3, funcionario.getTelefone().obterTelefone());
             stmt.setInt(4, funcionario.getIdCargo());
             stmt.setInt(5, funcionario.getIdUsuario());

             stmt.executeUpdate();

             try (ResultSet rs = stmt.getGeneratedKeys()) {
                 if (rs.next()) {
                     return rs.getInt(1);
                 } else {
                     throw new SQLException("Falha ao obter ID do funcionário inserido.");
                 }
             }

         } catch (SQLException e) {
             throw new SQLException(e);
         }
     }

     @Override
    public void cadastrarMultiplosFuncionarios(List<Funcionario> funcionarios, int idCargo, int idUsuario) throws SQLException {

        String query = """
                INSERT INTO Funcionario (nome_funcionario, email_funcionario, telefone, id_cargo, id_usuario)
                VALUES (?, ?, ?, ?, ?)
            """;
        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            for(Funcionario funcionario : funcionarios) {
                stmt.setString(1, funcionario.getNome());
                stmt.setString(2, funcionario.getEmail().obterEmail());
                stmt.setString(3, funcionario.getTelefone().obterTelefone());
                stmt.setInt(4, funcionario.getIdCargo());
                stmt.setInt(5, funcionario.getIdUsuario());

                stmt.addBatch();
            }
            stmt.executeBatch();


        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }


     @Override
     public List<ListarTodosFuncionarioResponse> listarTodosFuncionarios() {

         String query = """
                 SELECT f.id_funcionario,
                            f.nome_funcionario,
                            c.nome AS cargo
                       FROM Funcionario f
                       JOIN Cargo c ON f.id_cargo = c.id_cargo
                   ORDER BY f.nome_funcionario ASC
                 """;
         List<ListarTodosFuncionarioResponse> funcionarios = new ArrayList<>();

         try (Connection conn = ConexaoFactory.conectar();
              PreparedStatement stmt = conn.prepareStatement(query);
              ResultSet rs = stmt.  executeQuery()) {

             while (rs.next()) {
                 funcionarios.add(new ListarTodosFuncionarioResponse(
                         rs.getInt("id_funcionario"),
                         rs.getString("nome_funcionario"),
                         rs.getString("cargo")
                 ));
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return funcionarios;
     }

     @Override
     public ExcluirFuncionariosResponse excluirFuncionario(ExcluirFuncionarioRequest request) {
         String deleteMatriculasQuery = "DELETE FROM Curso_Funcionario WHERE id_funcionario = ?";
         String deleteFuncionarioQuery = "DELETE FROM Funcionario WHERE id_funcionario = ?";

         try (Connection conn = ConexaoFactory.conectar()) {

             try (PreparedStatement stmtMatriculas = conn.prepareStatement(deleteMatriculasQuery)) {
                 stmtMatriculas.setLong(1, request.id());
                 stmtMatriculas.executeUpdate();
             }

             int linhasAfetadas;
             try (PreparedStatement stmtFuncionario = conn.prepareStatement(deleteFuncionarioQuery)) {
                 stmtFuncionario.setLong(1, request.id());
                 linhasAfetadas = stmtFuncionario.executeUpdate();
             }

             if (linhasAfetadas > 0) {
                 return new ExcluirFuncionariosResponse("Funcionário excluído com sucesso.");
             } else {
                 return new ExcluirFuncionariosResponse("Funcionário com ID " + request.id() + " não foi encontrado.");
             }

         } catch (SQLException e) {
             e.printStackTrace();
             return new ExcluirFuncionariosResponse("Erro de banco de dados ao tentar excluir o funcionário.");
         }
     }

 }
