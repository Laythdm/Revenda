package com.ativ.atividade2.data;

public enum StatusCarro {
    DISPONIVEL("Disponível"),
    INDISPONIVEL("Indisponível"),
    VENDIDO("Vendido");

    private final String descricao;

    StatusCarro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
