package domain.model;

import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;

import java.util.Objects;

public class Funcionario {
    String nome;
    Email email;
    Telefone telefone;;

    public Funcionario(String nome, Email email, Telefone telefone) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.email = Objects.requireNonNull(email, "Email não pode ser nulo");
        this.telefone = Objects.requireNonNull(telefone, "Telefone não pode ser nulo");
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


    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
