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

    public Sessao autenticarSessao(Usuario usuario) throws AutenticacaoException {

        if (usuario == null || usuario.getEmail() == null || usuario.getSenha() == null) {
            throw new AutenticacaoException("Usuário, e-mail e senha não podem ser nulos.");
        }

        try {
            Sessao sessao = sessaoRepository.autenticarSessao(usuario);
            if (sessao == null) {
                throw new AutenticacaoException("Credenciais inválidas.");
            }
            return sessao;
        } catch (SQLException e) {
            throw new AutenticacaoException("Erro interno de banco de dados durante a autenticação: " + e.getMessage());
        }
    }
}