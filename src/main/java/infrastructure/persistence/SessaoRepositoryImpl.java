package infrastructure.persistence;

import domain.model.Sessao;
import domain.repository.SessaoRepository;
import infrastructure.database.ConexaoFactory;
import shared.util.SenhaUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SessaoRepositoryImpl implements SessaoRepository {

    @Override
    public boolean validarSessao(Sessao sessao) throws SQLException {
        String query = "SELECT senha FROM Usuario WHERE email = ?";

        try (Connection conn = ConexaoFactory.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, sessao.getUsuario().getEmail().obterEmail());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String hashBanco = rs.getString("senha");
                boolean senhaValida = SenhaUtil.verificaSenha(sessao.getUsuario().getSenha(),hashBanco);
                if(senhaValida) {
                    return sessao.validaSessao();
                }else {
                    return sessao.invalidaSessao();
                }
            } else {
                return sessao.invalidaSessao();
            }
        }
    }
}
