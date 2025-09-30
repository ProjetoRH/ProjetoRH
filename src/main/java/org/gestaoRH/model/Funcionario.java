package org.gestaoRH.model;

import java.time.LocalDate;

public class Funcionario {

    private int id;
    private String cracha;
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String telefone;
    private String cargo;
    private double salario;
    private String curso;
    private StatusFuncionario status;
    private LocalDate dataAdmissao;

    public Funcionario() {
        this.status = StatusFuncionario.ATIVO;
        this.dataAdmissao = LocalDate.now();
    }

    public Funcionario(int id, String cracha, String nome, String cpf, String endereco, String email, String telefone, String cargo, double salario, String curso) {
        this();
        this.id = id;
        this.cracha = cracha;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
        this.curso = curso;
    }

    public Funcionario(String cracha, String nome, String cpf, String endereco, String email, String telefone, String cargo, double salario, String curso) {
        this();
        this.cracha = cracha;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.salario = salario;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCracha() {
        return cracha;
    }

    public void setCracha(String cracha) {
        this.cracha = cracha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public StatusFuncionario getStatus() {
        return status;
    }

    public void setStatus(StatusFuncionario status) {
        this.status = status;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

}