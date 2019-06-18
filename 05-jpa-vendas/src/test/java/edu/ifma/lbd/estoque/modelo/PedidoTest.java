package edu.ifma.lbd.estoque.modelo;

import edu.ifma.lbd.estoque.modelo.builder.ItemPedidoBuilder;
import edu.ifma.lbd.estoque.modelo.builder.PedidoBuilder;
import edu.ifma.lbd.estoque.modelo.builder.ProdutoBuilder;
import org.junit.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PedidoTest {



    @Test
    public void deveSomarDoisItensIguais() {

        Produto produto1 = ProdutoBuilder.umProduto().deID(1).constroi();
        Produto produto2 = ProdutoBuilder.umProduto().deID(2).constroi();

        Pedido pedido = PedidoBuilder.umPedido().deID(1).constroi();

        ItemPedido item01 = ItemPedidoBuilder.umItem().noPedido(pedido).doProduto(produto1).constroi();
        ItemPedido item02 = ItemPedidoBuilder.umItem().noPedido(pedido).doProduto(produto2).constroi();

        ItemPedido item03 = ItemPedidoBuilder.umItem().noPedido(pedido).doProduto(produto1).constroi();

        pedido.adiciona(item01 );
        pedido.adiciona(item02 );
        pedido.adiciona(item03 );

        assertThat(pedido.getItens().size(), equalTo(2));
        assertTrue(pedido.getItens().contains(item01));
        assertTrue(pedido.getItens().contains(item02));

        assertThat(item02.getQuantidade(), equalTo(1));
        assertThat(item03.getQuantidade(), equalTo(2));



    }

}