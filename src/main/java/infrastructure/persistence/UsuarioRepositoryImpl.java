package infrastructure.persistence;

import application.dto.usuario.LoginUsuarioRequest;
import domain.model.Usuario;
import domain.model.enums.TipoUsuario;
import domain.model.valueobjects.Email;
import domain.repository.UsuarioRepository;
import infrastructure.database.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public int cadastrarUsuario(Usuario usuario) {

        String query = """
                INSERT INTO Usuario (email, senha)
                VALUES (?, ?)
                """;

        try(Connection conn = ConexaoFactory.conectar();
            PreparedStatement stmt = conn.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getEmail().obterEmail());
            stmt.setString(2, usuario.getSenha());

            int linhasAfetadas = stmt.executeUpdate();

            if(linhasAfetadas == 0) {
                throw new SQLException("Erro ao cadastrar usuario");
            }

            try(var rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                } else {
                    throw new SQLException("Falha ao obter o id do usuário.");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Usuario buscarPorEmail(Email email) {
        String query = "SELECT email, senha, tipo FROM Usuario WHERE email = ?";

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email.obterEmail());

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Email emailDoBanco = new Email(rs.getString("email"));
                    String senhaDoBanco = rs.getString("senha");
                    String tipoComoString = rs.getString("tipo");


                    TipoUsuario tipoDoBanco = TipoUsuario.valueOf(tipoComoString.toUpperCase());

                    return new Usuario(emailDoBanco, senhaDoBanco, tipoDoBanco);
                }
            }

            return null;

        } catch (SQLException e) {
            throw new RuntimeException("Erro de banco de dados ao buscar usuário por email", e);
        }
    }


}
