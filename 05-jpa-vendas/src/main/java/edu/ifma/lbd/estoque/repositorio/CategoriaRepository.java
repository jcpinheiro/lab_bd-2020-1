package edu.ifma.lbd.estoque.repositorio;

import edu.ifma.lbd.estoque.modelo.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaRepository {

	private final EntityManager manager;
	private final DAOGenerico<Categoria> daoGenerico;

	public CategoriaRepository(EntityManager manager) {
		this.manager = manager;
		this.daoGenerico = new DAOGenerico<>(manager);
	}

	public Categoria buscaPor(Integer id) {
		return daoGenerico.buscaPorId(Categoria.class, id);
	}


	public List<Categoria> categoriasPai() {
		return manager.createQuery("Select c from Categoria c where categoriaPai is null", Categoria.class)
				      .getResultList();
	}


	public List<Categoria> subcategoriasDe(Categoria categoriaPai) {
		return manager.createQuery("from Categoria where categoriaPai = :categoria", Categoria.class)
				.setParameter("categoria", categoriaPai)
				.getResultList();
	}
	
}