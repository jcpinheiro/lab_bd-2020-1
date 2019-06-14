package edu.ifma.lbd.estoque.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private BigDecimal valor;
    private BigDecimal desconto = BigDecimal.ZERO;

    private Integer quantidade;


    @PrePersist
    private void prePersit() {
        this.valor = id.getProduto().getPrecoAtual();
    }


    public BigDecimal getValor() {
        return valor;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Transient
    public BigDecimal getSubTotal() {
        return valor
               .multiply(new BigDecimal(quantidade))
               .subtract(desconto );
    }

    public void setPedido(Pedido pedido) {
        id.setPedido(pedido);
    }

    public void setProduto(Produto produto) {
        id.setProduto(produto);
    }
}
