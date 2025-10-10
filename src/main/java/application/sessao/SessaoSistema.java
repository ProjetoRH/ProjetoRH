package application.sessao;

import application.controller.SessaoController;
import domain.model.Sessao;
import domain.model.Usuario;
import domain.model.enums.TipoUsuario;

import java.sql.SQLException;

public class SessaoSistema {

    SessaoController sessaoController = new SessaoController();

    private static final SessaoSistema INSTANCIA = new SessaoSistema();

    private Sessao sessaoAtual;

    private SessaoSistema() {
    }

    public static SessaoSistema obterInstancia() {
        return INSTANCIA;
    }

    public void iniciarSessao(Sessao sessao) {
        if (sessao == null) throw new IllegalArgumentException("Sessão não pode ser nula ao iniciar.");
        this.sessaoAtual = sessao;
        this.sessaoAtual.validaSessao();
    }

    public void iniciarSessao(Usuario usuario) throws SQLException {
        if (usuario == null) throw new IllegalArgumentException("Usuário não pode ser nulo ao iniciar sessão.");

        Sessao s = sessaoController.autenticarSessao(usuario);

        if (s == null) {
            throw new SecurityException("Autenticação de sessão falhou: Credenciais inválidas ou usuário inativo.");
        }

        iniciarSessao(s);
    }

    public void encerrarSessao() {
        if (this.sessaoAtual != null) {
            this.sessaoAtual.invalidaSessao();
            this.sessaoAtual = null;
        }
    }

    public Sessao obterSessaoAtual() {
        return sessaoAtual;
    }

    public int obterSessaoId() {
        if (sessaoAtual == null) throw new IllegalStateException("Nenhuma sessão ativa.");
        return sessaoAtual.getIdFuncionario();
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