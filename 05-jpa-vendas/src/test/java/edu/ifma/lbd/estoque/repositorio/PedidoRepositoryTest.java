package edu.ifma.lbd.estoque.repositorio;

import edu.ifma.lbd.estoque.modelo.Cliente;
import edu.ifma.lbd.estoque.modelo.ItemPedido;
import edu.ifma.lbd.estoque.modelo.Pedido;
import edu.ifma.lbd.estoque.modelo.Produto;
import edu.ifma.lbd.estoque.modelo.builder.ClienteBuilder;
import edu.ifma.lbd.estoque.modelo.builder.ItemPedidoBuilder;
import edu.ifma.lbd.estoque.modelo.builder.PedidoBuilder;
import edu.ifma.lbd.estoque.modelo.builder.ProdutoBuilder;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PedidoRepositoryTest {
	
	
	private EntityManager manager;
	private static EntityManagerFactory emf;
	private PedidoRepository pedidoRepository;
	private ClienteRepository clienteRepository;

	@BeforeClass
	public static void inicio() {
	    emf = Persistence.createEntityManagerFactory("lab05_jpa-test");
	}
	
	@Before
	public void antes() {
		manager = emf.createEntityManager();

		pedidoRepository = new PedidoRepository(manager );
		clienteRepository = new ClienteRepository(manager );

		manager.getTransaction().begin();
	}
	
	@After
	public void depois() {
		manager.getTransaction().rollback();
	}
	
	@AfterClass
	public static void fim() {
		emf.close();
	}

	
	@Test
	public void testSalva() { 	}


	@Test
	public void deveCalcularTotalSemDescontoEFrete() {

		Cliente joao = ClienteBuilder.umCliente().comNome("Joao da Silva").constroi();
		ClienteRepository clienteRepository = new ClienteRepository(manager );
		clienteRepository.salvaOuAtualiza(joao );

		Pedido pedido = PedidoBuilder.umPedido().doCliente(joao).constroi();
		pedidoRepository.salvaOuAtualiza(pedido );

		Produto produto1 = ProdutoBuilder.umProduto().comNome("Prod01").sku("ab1234").preco(new BigDecimal(9.99)).constroi();
		Produto produto2 = ProdutoBuilder.umProduto().comNome("Prod02").sku("ac4321").preco(new BigDecimal(5.49)).constroi();

		ProdutoRepository produtoRepository = new ProdutoRepository(manager );
		produtoRepository.salvaOuAtualiza(produto1 );
		produtoRepository.salvaOuAtualiza(produto2 );

		ItemPedido item01 = ItemPedidoBuilder.umItem().noPedido(pedido).doProduto(produto1).constroi();
		ItemPedido item02 = ItemPedidoBuilder.umItem().noPedido(pedido).doProduto(produto2).constroi();

		pedido.adiciona(item01 );
		pedido.adiciona(item02 );

		pedidoRepository.salvaOuAtualiza(pedido );

		assertThat(pedido.getItens().size(), equalTo(2));
		assertEquals(new BigDecimal(15.48).doubleValue(), pedido.getTotal().doubleValue(), 0.00001 );
	}


	@Test
    public void deveTrazerSomentePedidosFinalizados() {
		ClienteRepository clienteRepository = new ClienteRepository(this.manager);

		Cliente joao = ClienteBuilder.umCliente().comNome("Joao da Silva").constroi();
		Cliente jose = ClienteBuilder.umCliente().comNome("José da Silva").constroi();

    	clienteRepository.salvaOuAtualiza(joao );
    	clienteRepository.salvaOuAtualiza(jose );
    	manager.flush();

		// criando os pedidos, cada um com um status
		Pedido finalizado1 = PedidoBuilder.umPedido().doCliente(joao).finaliza().constroi();
		Pedido cancelado = PedidoBuilder.umPedido().doCliente(joao).cancela().constroi();
		Pedido finalizado2 = PedidoBuilder.umPedido().doCliente(jose).finaliza().constroi();


		pedidoRepository.salvaOuAtualiza(finalizado1 );
		pedidoRepository.salvaOuAtualiza(cancelado );
		pedidoRepository.salvaOuAtualiza(finalizado2 );

		// chamando o método para testar
        List<Pedido> pedidosFinalizados = pedidoRepository.finalizados();

        // garantindo que a query funcionou
        Assert.assertEquals(2, pedidosFinalizados.size());

        //verificação
        Assert.assertEquals("Joao da Silva", pedidosFinalizados.get(0).getCliente().getNome() );
		Assert.assertEquals("José da Silva", pedidosFinalizados.get(1).getCliente().getNome() );
    }
	
	
    @Test
    public void deveTrazerPedidosPagosComCartao() {

		ClienteRepository clienteRepository = new ClienteRepository(this.manager);

		Cliente joao = ClienteBuilder.umCliente().comNome("Joao da Silva").constroi();
		Cliente jose = ClienteBuilder.umCliente().comNome("José da Silva").constroi();

		clienteRepository.salvaOuAtualiza(joao );
		clienteRepository.salvaOuAtualiza(jose );
		manager.flush();

		// criando os pedidos, cada um com um status
		Pedido pedido1 = PedidoBuilder.umPedido().doCliente(joao).comPagamentoCartao().constroi();
		Pedido pedido2 = PedidoBuilder.umPedido().doCliente(joao).cancela().constroi();
		Pedido pedido3 = PedidoBuilder.umPedido().doCliente(jose).comPagamentoCartao().constroi();


		pedidoRepository.salvaOuAtualiza(pedido1 );
		pedidoRepository.salvaOuAtualiza(pedido2 );
		pedidoRepository.salvaOuAtualiza(pedido3 );

		// chamando o método para testar
		List<Pedido> pedidosPagosComCartao = pedidoRepository.comPagamentoCartao();

		// garantindo que a query funcionou
		Assert.assertEquals(2, pedidosPagosComCartao.size() );


		//verificação
		Assert.assertEquals("Joao da Silva", pedidosPagosComCartao.get(0).getCliente().getNome() );
		Assert.assertEquals("José da Silva", pedidosPagosComCartao.get(1).getCliente().getNome() );
    }
}