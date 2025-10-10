package infrastructure.persistence;

import domain.model.Sessao;
import domain.model.Usuario;
import domain.model.enums.TipoUsuario;
import domain.repository.SessaoRepository;
import infrastructure.database.ConexaoFactory;
import shared.util.SenhaUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static shared.util.SenhaUtil.verificaSenha;

public class SessaoRepositoryImpl implements SessaoRepository {

    @Override
    public Sessao autenticarSessao(Usuario usuario) throws SQLException {
        String query = """
            SELECT 
                u.id AS id_usuario,
                u.senha,
                u.tipo,
                f.id_funcionario
            FROM Usuario u
            JOIN Funcionario f ON u.id = f.id_usuario
            WHERE u.email = ?
        """;

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getEmail().obterEmail());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashBanco = rs.getString("senha");

                if (SenhaUtil.verificaSenha(usuario.getSenha(), hashBanco)) {

                    int idUsuario = rs.getInt("id_usuario");
                    int idFuncionario = rs.getInt("id_funcionario");

                    String tipoString = rs.getString("tipo");
                    TipoUsuario tipoDoBanco = TipoUsuario.valueOf(tipoString.toUpperCase());

                    return new Sessao(idUsuario, idFuncionario,usuario,true, tipoDoBanco);
                }
            }
        }
        return null;
    }
}
