package domain.model;

import domain.model.enums.TipoUsuario;

public class Sessao {
    private Usuario usuario;
    private boolean sessaoValida;
    private TipoUsuario tipoUsuario;

    public Sessao(Usuario usuario, boolean sessaoValida, TipoUsuario tipoUsuario) {
        this.usuario = usuario;
        this.sessaoValida = sessaoValida;
        this.tipoUsuario = tipoUsuario;
    }

    public Sessao(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isSessaoValida() {
        return sessaoValida;
    }

    public void setSessaoValida(boolean sessaoValida) {
        this.sessaoValida = sessaoValida;
    }

    public boolean invalidaSessao() {
        return sessaoValida = false;
    }

    public boolean validaSessao() {
        return sessaoValida = true;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
