package br.com.fatec.fretenetapi.entity;

public enum Status {
    PROCESSANDO("PROCESSANDO"),
    SAIU_ENTREGA("SAIU PARA ENTREGA"),
    ENTREGUE("ENTREGUE"),
    FALHA("FALHA");

    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}