package edu.ifma.lbd.estoque.repositorio;

import edu.ifma.lbd.estoque.modelo.EntidadeBase;

import javax.persistence.EntityManager;
import java.util.Objects;

class DAOGenerico<T extends EntidadeBase> {

    private final EntityManager manager;

    DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }

    T buscaPorId(Class<T> clazz, Integer id) {
        return manager.find(clazz, id);
    }

    T salvaOuAtualiza(T t) {
        if( Objects.isNull(t.getId()) )
             this.manager.persist(t);
        else
            t = this.manager.merge(t);

        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }
}