package domain.repository;

import domain.model.Sessao;

import java.sql.SQLException;

public interface SessaoRepository {

    public boolean validarSessao(Sessao sessao) throws SQLException;
}
