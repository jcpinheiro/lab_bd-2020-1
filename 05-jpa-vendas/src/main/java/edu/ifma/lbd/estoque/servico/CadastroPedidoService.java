package edu.ifma.lbd.estoque.servico;

import edu.ifma.lbd.estoque.modelo.Pedido;
import edu.ifma.lbd.estoque.repositorio.PedidoRepository;
import edu.ifma.lbd.estoque.util.EMFactory;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroPedidoService  {

	private final PedidoRepository repositorio;
	private final EntityManager manager;

	public CadastroPedidoService( ) {
		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new PedidoRepository(manager );
	}


/*	public CadastroPedidoService(EntityManager manager) {
		this.manager = manager;
		this.repositorio = new PedidoRepository(manager );
	}
*/

	public Pedido salva(Pedido pedido) throws VendasException {

		if (pedido.getItens().isEmpty()) {
			throw new VendasException("O pedido deve possuir pelo menos um item.");
		}

		// TODO ainda não funciona, pois o preço é defido apenas quando salvo o item do pedido
		if (pedido.getTotal().compareTo(BigDecimal.ZERO) <= 0 ) {
			throw new VendasException("Valor total do pedido deve ser maior do que zero");
		}

		manager.getTransaction().begin();
		pedido = repositorio.salvaOuAtualiza(pedido );
		manager.getTransaction().commit();

		return pedido;
	}
	
}