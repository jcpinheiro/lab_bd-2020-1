package edu.ifma.lbd.estoque.modelo.builder;

import edu.ifma.lbd.estoque.modelo.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class ItemPedidoBuilder {

    private ItemPedido item;

    private ItemPedidoBuilder() { }

    public static ItemPedidoBuilder umItem() {
        ItemPedidoBuilder builder = new ItemPedidoBuilder();
        builder.item = new ItemPedido();

        return builder;
    }

    public ItemPedidoBuilder doProduto(Produto produto ) {
        item.setProduto(produto);
        return this;
    }

    public ItemPedidoBuilder noPedido(Pedido pedido ) {
        item.setPedido(pedido );
        return this;
    }

    public ItemPedidoBuilder adiciona(Integer quantidade ) {
        item.setQuantidade(quantidade );
        return this;
    }

    public ItemPedidoBuilder com(BigDecimal desconto ) {
        item.setDesconto(desconto );
        return this;
    }

    public ItemPedido constroi() {
        return item;
    }


}