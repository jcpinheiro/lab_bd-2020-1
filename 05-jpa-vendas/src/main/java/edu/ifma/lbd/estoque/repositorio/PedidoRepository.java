package edu.ifma.lbd.estoque.repositorio;

import edu.ifma.lbd.estoque.modelo.Pagamento;
import edu.ifma.lbd.estoque.modelo.PagamentoBoleto;
import edu.ifma.lbd.estoque.modelo.PagamentoCartao;
import edu.ifma.lbd.estoque.modelo.Pedido;
import edu.ifma.lbd.estoque.modelo.enums.EstadoPedido;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

public class PedidoRepository {

    private final EntityManager manager;
    private final DAOGenerico<Pedido> daoGenerico;

    public PedidoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Pedido porId(Integer id) {
        return daoGenerico.buscaPorId(Pedido.class, id);
    }

    public Pedido salvaOuAtualiza(Pedido pedido) {
       return daoGenerico.salvaOuAtualiza(pedido );
    }

    public List<Pedido> finalizados() {
        return manager
                .createQuery("from Pedido p where p.estadoPedido = :status", Pedido.class)
                .setParameter("status", EstadoPedido.FINALIZADO)
                .getResultList();
    }

    public List<Pedido> comPagamentoCartao() {
        return manager
                .createQuery("Select p From Pedido p where TYPE(p.pagamento) IN (:tipoPagamento)",
                        Pedido.class)
                .setParameter("tipoPagamento", Arrays.asList(PagamentoCartao.class) )
                .getResultList();
    }

    public List<Pedido> comPagamentoBoleto() {
        return comPagametosDoTipo(PagamentoBoleto.class );
    }

    private List<Pedido> comPagametosDoTipo(Class<PagamentoBoleto> clazz) {
        return manager
                .createQuery("Select p From Pedido p where TYPE(p.pagamento) IN (:tipoPagamento)",
                        Pedido.class)
                .setParameter("tipoPagamento", Arrays.asList(clazz) )
                .getResultList();
    }


}