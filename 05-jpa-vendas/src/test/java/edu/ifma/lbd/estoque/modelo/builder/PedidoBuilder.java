package edu.ifma.lbd.estoque.modelo.builder;

import edu.ifma.lbd.estoque.modelo.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class PedidoBuilder {

    private Pedido pedido;


    private PedidoBuilder() { }

    public static PedidoBuilder umPedido() {
        PedidoBuilder builder = new PedidoBuilder();

        builder.pedido = new Pedido();
        builder.pedido.setEnderecoEntrega(defineEnderecoPadrao() );

        return builder;
    }

    public PedidoBuilder doCliente(Cliente cliente) {
        pedido.setCliente(cliente);
        return this;
    }

    public PedidoBuilder comItens(ItemPedido ...itens) {
        pedido.setItens( new LinkedHashSet<>(Arrays.asList(itens)) );
        return this;
    }

    public PedidoBuilder cancela() {
        pedido.cancela();
        return this;
    }

    public PedidoBuilder finaliza() {
        pedido.finaliza();

        return this;
    }


    public PedidoBuilder freteDe(BigDecimal valorFrete) {
        pedido.setFrete(valorFrete);
        return this;
    }

    public PedidoBuilder comPagamentoCartao() {

        PagamentoCartao pagamentoCartao = new PagamentoCartao();
        pagamentoCartao.setNumeroDeParcelas((short) 1 );
        pagamentoCartao.setPedido(this.pedido );
        this.pedido.setPagamento(pagamentoCartao );

        this.pedido.finaliza();

        return this;
    }


    public Pedido constroi() {
        return pedido;
    }


    private static EnderecoEntrega defineEnderecoPadrao() {
        EnderecoEntrega enderecoEntrega = new EnderecoEntrega();
        enderecoEntrega.setLogradouro("Rua Existente");
        enderecoEntrega.setNumero("10");
        enderecoEntrega.setCep("65000-000");

        return enderecoEntrega;
    }


}