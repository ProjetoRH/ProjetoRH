package infrastructure.persistence;

import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.*;
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
    public Optional<Funcionario> buscarFuncionario(int id) {
        return Optional.empty();
    }

    @Override
    public void desativarFuncionario(int id) {

    }

    @Override
    public Optional<Funcionario> listarFuncionario() {
        return Optional.empty();
    }
}
