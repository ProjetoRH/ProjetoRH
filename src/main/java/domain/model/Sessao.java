package domain.model;

public class Sessao {
    private Usuario usuario;
    private boolean sessaoValida;

    public Sessao(Usuario usuario, boolean sessaoValida) {
        this.usuario = usuario;
        this.sessaoValida = sessaoValida;
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
}
