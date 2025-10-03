package domain.repository;

import domain.model.Sessao;
import domain.model.Usuario;

import java.sql.SQLException;

public interface SessaoRepository {

    public Sessao autenticarSessao(Usuario usuario) throws SQLException;
}
