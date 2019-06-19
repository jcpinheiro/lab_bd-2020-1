package edu.ifma.lbd.estoque.servico;

import edu.ifma.lbd.estoque.modelo.Pedido;
import edu.ifma.lbd.estoque.repositorio.PedidoRepository;
import edu.ifma.lbd.estoque.util.EMFactory;

import javax.persistence.EntityManager;

public class EmissaoPedidoService {

	private final PedidoRepository repositorio;
	private final EntityManager manager;


	public EmissaoPedidoService( ) {
		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new PedidoRepository(manager );
	}


	//@Transactional
	public Pedido emitir(Pedido pedido) throws VendasException {

		manager.getTransaction().begin();

		repositorio.salvaOuAtualiza(pedido );

		//this.estoqueService.baixarItensEstoque(pedido);
		//pedido.setStatus(StatusPedido.FINALIZADO);

		pedido.finaliza();

		manager.getTransaction().commit();
		
		return pedido;
	}
	
}