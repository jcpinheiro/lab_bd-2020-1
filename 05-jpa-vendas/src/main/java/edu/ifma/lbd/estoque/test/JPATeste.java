package edu.ifma.lbd.estoque.test;


import edu.ifma.lbd.estoque.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Objects;

public class JPATeste {

    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("lab05_jpa");
        EntityManager manager = factory.createEntityManager();

        //insereProduto(manager, "Notebook Samsung", new BigDecimal(2200.59));
        //atualizaProdutoDeId2(manager);
        /*
        manager.getTransaction().begin();

        manager.merge(computador );

        manager.getTransaction().commit();*/
        manager.close();
        factory.close();


    }

    private static void atualizaProdutoDeId2(EntityManager manager) {

        manager.getTransaction().begin();

        final Produto produto = manager.find(Produto.class, 2);

        if (Objects.nonNull(produto)) {
            produto.setNome("Notebook HP");
            //produto.setPrecoAtual(new BigDecimal(1499.90));
        }

        manager.getTransaction().commit();

    }




    private static void insereProduto(EntityManager manager, String nome, BigDecimal preco) {
        EntityTransaction transacao = manager.getTransaction();

        transacao.begin();

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setPrecoAtual(preco);

        manager.persist(produto);

        transacao.commit();
    }
}
