package org.gestaoRH.model;

public enum StatusFuncionario {
    ATIVO("Ativo"),
    FERIAS("Férias"),
    LICENCA_MEDICA("Licença Médica"),
    ATESTADO("Atestado"),
    LICENCA_MATERNIDADE("Licença Maternidade"),
    SUSPENSO("Suspenso"),
    DEMITIDO("Demitido");

    private final String descricao;

    StatusFuncionario(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}