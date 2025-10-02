package domain.model;

import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;

import java.util.Objects;

public class Funcionario {
    String nome;
    Email email;
    Telefone telefone;
    int idCargo;
    int idUsuario;

    public Funcionario(String nome, Email email, Telefone telefone, int idCargo, int idUsuario) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idCargo = idCargo;
        this.idUsuario = idUsuario;
    }

    public Funcionario() {}

    public Funcionario(String nome, Email email, Telefone telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", email=" + email +
                ", telefone=" + telefone +
                ", idCargo=" + idCargo +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
