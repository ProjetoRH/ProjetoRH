package application.sessao;


import application.controller.SessaoController;
import domain.model.Sessao;
import domain.model.Usuario;
import domain.model.enums.TipoUsuario;

import java.sql.SQLException;

public class SessaoSistema {

    SessaoController sessaoController = new SessaoController();

    private static final SessaoSistema INSTANCIA = new SessaoSistema();

    private volatile Sessao sessaoAtual;

    private SessaoSistema() {
    }

    public static SessaoSistema obterInstancia() {
        return INSTANCIA;
    }


    public synchronized void iniciarSessao(Sessao sessao) {
        if (sessao == null) throw new IllegalArgumentException("Sessão não pode ser nula ao iniciar.");
        this.sessaoAtual = sessao;
        this.sessaoAtual.validaSessao();
    }


    public synchronized void iniciarSessao(Usuario usuario) throws SQLException {
        if (usuario == null) throw new IllegalArgumentException("Usuário não pode ser nulo ao iniciar sessão.");
        Sessao s = sessaoController.autenticarSessao(usuario);

        iniciarSessao(s);
    }


    public synchronized void encerrarSessao() {
        if (this.sessaoAtual != null) {
            this.sessaoAtual.invalidaSessao();
            this.sessaoAtual = null;
        }
    }


    public Sessao obterSessaoAtual() {
        return sessaoAtual;
    }


    public boolean estaAutenticado() {
        return this.sessaoAtual != null && this.sessaoAtual.isSessaoValida();
    }


    public Usuario obterUsuarioAtual() {
        return estaAutenticado() ? this.sessaoAtual.getUsuario() : null;
    }


    public TipoUsuario obterTipoUsuarioAtual() {
        return estaAutenticado() ? this.sessaoAtual.getTipoUsuario() : null;
    }
}

