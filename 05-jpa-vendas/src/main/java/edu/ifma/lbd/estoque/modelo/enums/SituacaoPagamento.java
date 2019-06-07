package edu.ifma.lbd.estoque.modelo.enums;


public enum SituacaoPagamento {

    ORCAMENTO ("Orcamento"),
    QUITADO ("Quitado"),
    CANCELADO ("Cancelado");

    private String situacao;


    private SituacaoPagamento(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }
}
