package infrastructure.persistence;

import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

 public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    @Override
    public void cadastrarFuncionario(Funcionario funcionario, int idCargo, int idUsuario) throws SQLException {
        String query = """
                INSERT INTO Funcionario (nome_funcionario, email_funcionario, telefone, id_cargo, id_usuario)
                VALUES (?, ?, ?, ?, ?)
            """;
        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getEmail().obterEmail());
            stmt.setString(3, funcionario.getTelefone().obterTelefone());
            stmt.setInt(4, idCargo);
            stmt.setInt(5, idUsuario);
            stmt.executeUpdate();


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
