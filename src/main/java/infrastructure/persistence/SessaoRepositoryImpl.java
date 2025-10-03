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
        String query = "SELECT senha FROM Usuario WHERE email = ?";

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario.getEmail().obterEmail());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashBanco = rs.getString("senha");

                String tipoString = rs.getString("tipo");

                TipoUsuario tipoDoBanco = TipoUsuario.valueOf(tipoString.toUpperCase());

                if (SenhaUtil.verificaSenha(usuario.getSenha(), hashBanco)) {
                    return new Sessao(usuario, true, tipoDoBanco);
                }
            }
        }
        return null;
    }
}
