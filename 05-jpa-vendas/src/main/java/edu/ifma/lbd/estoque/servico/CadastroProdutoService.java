package edu.ifma.lbd.estoque.servico;

import edu.ifma.lbd.estoque.modelo.Produto;
import edu.ifma.lbd.estoque.repositorio.ProdutoRepository;
import edu.ifma.lbd.estoque.util.EMFactory;

import javax.persistence.EntityManager;
import java.util.Objects;

public class CadastroProdutoService {

	private final ProdutoRepository repositorio;
	private final EntityManager manager;

	public CadastroProdutoService( ) {
		this.manager = new EMFactory().getEntityManager();
		this.repositorio = new ProdutoRepository(manager );
	}


	public Produto salva(Produto produto) throws VendasException {

		try {
			manager.getTransaction().begin();

			Produto produtoExistente = repositorio.buscaPorSku(produto.getSku());

			if (Objects.nonNull(produtoExistente) && !Objects.equals(produto, produtoExistente)) {
				throw new VendasException("Já existe um produto com o SKU informado.");
			}
			Produto produtoSalvo = repositorio.salvaOuAtualiza(produto);

			manager.getTransaction().commit();
			return produtoSalvo;

		} catch	(Exception e) {
			throw new RuntimeException(e );
		}

	}
	
}