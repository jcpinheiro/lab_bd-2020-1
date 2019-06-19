package edu.ifma.lbd.estoque.servico;

import edu.ifma.lbd.estoque.modelo.ItemPedido;
import edu.ifma.lbd.estoque.modelo.Pedido;
import edu.ifma.lbd.estoque.repositorio.PedidoRepository;
import edu.ifma.lbd.estoque.util.EMFactory;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class EstoqueService  {

	private final PedidoRepository repositorio;
	private final EntityManager manager;

	public EstoqueService( ) {
		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new PedidoRepository(manager );
	}

	public void baixarItensEstoque(Pedido pedido) throws VendasException {
        manager.getTransaction().begin();
		pedido = this.repositorio.porId(pedido.getId());
		pedido.getItens().forEach(item -> item.baixarEstoque(item.getQuantidade()));
		manager.getTransaction().commit();
	}

	public void retornarItensEstoque(Pedido pedido) {

		manager.getTransaction().begin();
		pedido = repositorio.porId(pedido.getId());
		
		for (ItemPedido item : pedido.getItens()) {
			item.adicionarEstoque(item.getQuantidade() );
		}

		manager.getTransaction().commit();

		// enviar um email para o cliente
	}
	
}