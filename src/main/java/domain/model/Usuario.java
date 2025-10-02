package domain.model;

import domain.model.valueobjects.Email;

public class Usuario {
    private Email email;
    private String senha;

    public Usuario(Email email, String senha) {
        this.email = email;
        this.senha = senha;
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
}
