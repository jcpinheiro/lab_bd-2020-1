package edu.ifma.lbd.estoque.repositorio;

import edu.ifma.lbd.estoque.modelo.Cliente;
import edu.ifma.lbd.estoque.modelo.builder.ClienteBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class ClienteRepositorioTest {

    private EntityManager manager;
    private static EntityManagerFactory factory;
    private ClienteRepository clienteRepository;

    @BeforeClass
    public static void inicio() {
        factory = Persistence.createEntityManagerFactory("lab05_jpa-test");
    }

    @Before
    public void antes() {
        manager = factory.createEntityManager();
        clienteRepository = new ClienteRepository(manager);
        manager.getTransaction().begin();
    }

    @After
    public void depois() {
        manager.getTransaction().rollback();
    }

    @AfterClass
    public static void fim() {
        factory.close();
    }

    @Test
    public void deveEncontrarClientePeloNome() {

        Cliente cliente = ClienteBuilder.umCliente().comNome("João da Silva").constroi();

        clienteRepository.salvaOuAtualiza(cliente );
        manager.flush();
        manager.clear();

        Cliente clienteDoBanco = clienteRepository.buscaPor("João da Silva").get(0);

        assertEquals("João da Silva", cliente.getNome() );

        Assert.assertThat(clienteDoBanco.getNome(), is(equalTo("João da Silva") ) );
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void naoDeveEncontrarClientePeloNome() {
        Cliente clienteDoBanco = clienteRepository.buscaPor("Pedro Jose").get(0);
    }

    @Test
    public void deveExcluirUmCliente() {
        Cliente cliente = ClienteBuilder.umCliente().comNome("João Carlos").constroi();

        clienteRepository.salvaOuAtualiza(cliente);
        clienteRepository.remove(cliente);
        manager.flush();
        manager.clear();

        List<Cliente> clientes = clienteRepository.buscaPor("João Carlos");

        Assert.assertTrue(clientes.isEmpty() );
    }

    @Test
    public void deveAlterarUmCliente() {
        Cliente cliente = ClienteBuilder.umCliente().comNome("João Carlos").constroi();

        clienteRepository.salvaOuAtualiza(cliente);

        cliente.setNome("João da Silva");

        clienteRepository.salvaOuAtualiza(cliente );
        manager.flush();

        List<Cliente> clientes = clienteRepository.buscaPor("João da Silva");

        Assert.assertThat(clientes.size(), is(1));
        Assert.assertThat(clientes.get(0).getNome(), is("João da Silva") );

        clientes = clienteRepository.buscaPor("João Carlos");
        Assert.assertTrue(clientes.isEmpty() );
    }

}