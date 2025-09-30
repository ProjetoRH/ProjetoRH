package domain.model;

import domain.model.valueobjects.Email;
import domain.model.valueobjects.Telefone;

import java.util.Objects;

public class Funcionario {
    String nome;
    Email email;
    Telefone telefone;
    String cargo;
    String departamento;

    public Funcionario(String nome, Email email, Telefone telefone, String cargo, String departamento) {
        this.nome = Objects.requireNonNull(nome, "Nome não pode ser nulo");
        this.email = Objects.requireNonNull(email, "Email não pode ser nulo");
        this.telefone = Objects.requireNonNull(telefone, "Telefone não pode ser nulo");
        this.cargo = Objects.requireNonNull(cargo, "Cargo não pode ser nulo");
        this.departamento = Objects.requireNonNull(departamento, "Departamento não pode ser nulo");
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cargo='" + cargo + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}
