package edu.ifma.lbd.estoque.servico;

import edu.ifma.lbd.estoque.modelo.Pedido;
import edu.ifma.lbd.estoque.repositorio.PedidoRepository;
import edu.ifma.lbd.estoque.util.EMFactory;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class CancelamentoPedidoService  {

	private final PedidoRepository repositorio;
	private final EntityManager manager;

	public CancelamentoPedidoService( ) {

		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new PedidoRepository(manager );
	}


	public Pedido cancela(Pedido pedido) {

		manager.getTransaction().begin();

		pedido = repositorio.porId(pedido.getId());
		pedido.cancela();

		manager.getTransaction().commit();

		// envia email para o cliente
		//mailService.enviaMensagemDeCancelamentoPara(pedido.getCliente() );

		return pedido;
	}

}