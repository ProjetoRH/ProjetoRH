package application.sessao;


import domain.model.Sessao;
import domain.model.Usuario;
import domain.model.enums.TipoUsuario;
public class SessaoSistema {

    private static final SessaoSistema INSTANCIA = new SessaoSistema();

    // sessão atual (pode ser nula quando ninguém estiver autenticado)
    private volatile Sessao sessaoAtual;

    private SessaoSistema() {
    }

    public static SessaoSistema obterInstancia() {
        return INSTANCIA;
    }

    /**
     * Inicia a sessão com uma instância de Sessao já construída.
     */
    public synchronized void iniciarSessao(Sessao sessao) {
        if (sessao == null) throw new IllegalArgumentException("Sessão não pode ser nula ao iniciar.");
        this.sessaoAtual = sessao;
        this.sessaoAtual.validaSessao();
    }

    /**
     * Inicia a sessão a partir de um usuário e seu tipo.
     */
    public synchronized void iniciarSessao(Usuario usuario, TipoUsuario tipo) {
        if (usuario == null) throw new IllegalArgumentException("Usuário não pode ser nulo ao iniciar sessão.");
        Sessao s = new Sessao(usuario, true, tipo);
        iniciarSessao(s);
    }

    /**
     * Encerra (invalida) a sessão atual.
     */
    public synchronized void encerrarSessao() {
        if (this.sessaoAtual != null) {
            this.sessaoAtual.invalidaSessao();
            this.sessaoAtual = null;
        }
    }

    /**
     * Retorna a sessão atual ou null se não houver sessão.
     */
    public Sessao obterSessaoAtual() {
        return sessaoAtual;
    }

    /**
     * Indica se existe uma sessão ativa.
     */
    public boolean estaAutenticado() {
        return this.sessaoAtual != null && this.sessaoAtual.isSessaoValida();
    }

    /**
     * Retorna o usuário atual ou null.
     */
    public Usuario obterUsuarioAtual() {
        return estaAutenticado() ? this.sessaoAtual.getUsuario() : null;
    }

    /**
     * Retorna o tipo do usuário atual (por ex: ADMIN, USUARIO) ou null.
     */
    public TipoUsuario obterTipoUsuarioAtual() {
        return estaAutenticado() ? this.sessaoAtual.getTipoUsuario() : null;
    }
}

