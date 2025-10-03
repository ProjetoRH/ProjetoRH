package application.service;

import domain.model.Sessao;
import domain.model.Usuario;
import domain.repository.SessaoRepository;
import shared.exceptions.AutenticacaoException;

import java.sql.SQLException;

public class SessaoService {

    private final SessaoRepository sessaoRepository;

    public SessaoService(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    public Sessao autenticarSessao(Usuario usuario) throws SQLException {

        if(usuario == null || usuario.getEmail() == null) {
            throw new AutenticacaoException("O Usuario Não Pode Ser Nulo.");
        }

        return sessaoRepository.autenticarSessao(usuario);
    }
}
