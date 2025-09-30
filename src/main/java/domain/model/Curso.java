package domain.model;

import domain.model.enums.StatusCurso;

import java.time.LocalDate;

public class Curso {
    private final String nome;
    private final LocalDate data_inicio;
    private final LocalDate data_fim;
    private final StatusCurso status;

    public Curso(String nome, LocalDate data_inicio, LocalDate data_fim, StatusCurso status) {
        this.nome = nome;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public StatusCurso getStatus() {
        return status;
    }
}
