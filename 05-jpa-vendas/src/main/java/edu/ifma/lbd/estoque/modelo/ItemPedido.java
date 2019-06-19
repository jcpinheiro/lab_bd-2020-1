package edu.ifma.lbd.estoque.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK id = new ItemPedidoPK();

    private BigDecimal valor;
    private BigDecimal desconto = BigDecimal.ZERO;

    private Integer quantidade = 1;

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

    public Produto getProduto() {
        return id.getProduto();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedido that = (ItemPedido) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void aumentaQuantidade(Integer qtd) {
        this.quantidade = this.quantidade + qtd;
    }

    public void baixarEstoque(Integer quantidade) {
        this.getProduto().baixaNoEstoque(quantidade );
    }

    public void adicionarEstoque(Integer quantidade) {
        this.getProduto().adicionaNoEstoque(quantidade );
    }
}
