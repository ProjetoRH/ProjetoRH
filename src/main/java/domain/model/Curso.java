package domain.model;

import domain.model.enums.StatusCurso;

import java.sql.Date;
import java.time.LocalDate;

public class Curso {

    private  String nome;
    private  String descricao;
    private  Date data_inicio;
    private  Date data_fim;
    private  StatusCurso status;

    public Curso(String nome, String descricao, Date data_inicio, Date data_fim, StatusCurso status) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.status = status;
    }

    public Curso(String nome, String descricao, Date data_fim) {
        this.nome = nome;
        this.descricao = descricao;
        this.data_fim = data_fim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_fim() {
        return data_fim;
    }

    public void setData_fim(Date data_fim) {
        this.data_fim = data_fim;
    }

    public StatusCurso getStatus() {
        return status;
    }

    public void setStatus(StatusCurso status) {
        this.status = status;
    }
}
