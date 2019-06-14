package edu.ifma.lbd.estoque.test;

import edu.ifma.lbd.estoque.modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class TesteProduto {

	public static void main(String[] args) {
        // cenário

		// instanciamos e persistimos um produto
		Produto produto = new Produto();
		produto.setNome("Caderno de 10 materias");
		produto.setPrecoAtual(new BigDecimal(12.91) );
		produto.setQuantidaEstoque(100 );

		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("lab05_jpa-test");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction transacao = manager.getTransaction();
		transacao.begin();

		//ação
	    manager.persist(produto);

		transacao.commit();

		manager.close();
		factory.close();

		// Verificação
		System.out.println(produto );
	}
	
}