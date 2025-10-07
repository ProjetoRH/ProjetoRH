package domain.model;

import domain.model.enums.TipoUsuario;
import domain.model.valueobjects.Email;

public class Usuario {
    private Email email;
    private String senha;
    private TipoUsuario tipoDoBanco;

    public Usuario(Email email, String senha, TipoUsuario tipoDoBanco) {
        this.email = email;
        this.senha = senha;
        this.tipoDoBanco = tipoDoBanco;
    }

    public Usuario(Email email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {

    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senhaHash) {
        this.senha = senhaHash;
    }

    public TipoUsuario getTipoDoBanco() {
        return tipoDoBanco;
    }

    public void setTipoDoBanco(TipoUsuario tipoDoBanco) {
        this.tipoDoBanco = tipoDoBanco;
    }
}
