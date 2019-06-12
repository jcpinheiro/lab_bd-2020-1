package edu.ifma.lbd.estoque.repositorio;

import edu.ifma.lbd.estoque.modelo.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteRepository {

    private final EntityManager manager;
    private DAOGenerico<Cliente> daoGenerico;

    public ClienteRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Cliente>(manager);
    }

    public Cliente buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Cliente.class, id);
    }

    public List<Cliente> buscaPor(String nome) {
        return this.manager.createQuery("from Cliente " +
                "where upper(nome) like :nome", Cliente.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public Cliente salvaOuAtualiza(Cliente cliente) {
        return daoGenerico.salvaOuAtualiza(cliente);
    }

    public void remove(Cliente cliente) {
        daoGenerico.remove(cliente );
    }
}