package application.controller;

import application.service.SessaoService;
import domain.model.Sessao;
import domain.model.Usuario;
import domain.repository.SessaoRepository;
import infrastructure.persistence.SessaoRepositoryImpl; // importa tua implementação concreta

import java.sql.SQLException;

public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController() {
        SessaoRepository sessaoRepository = new SessaoRepositoryImpl();
        this.sessaoService = new SessaoService(sessaoRepository);
    }

    public Sessao autenticarSessao(Usuario usuario) throws SQLException {
        return sessaoService.autenticarSessao(usuario);
    }
}
