package edu.ifma.lbd.estoque.modelo.builder;

import edu.ifma.lbd.estoque.modelo.Categoria;
import edu.ifma.lbd.estoque.modelo.Produto;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class ProdutoBuilder {

	private Produto produto;

	private ProdutoBuilder() {}
	
	public static ProdutoBuilder umProduto() {
		
		ProdutoBuilder builder = new ProdutoBuilder();
		builder.produto = new Produto();
		builder.produto.setNome("Produto  01");
		builder.produto.setPrecoAtual(new BigDecimal(10.0));
		builder.produto.setSku("AS1234");
		return builder;
	}
	
	public ProdutoBuilder comNome(String nome) {
		produto.setNome(nome);
		return this;
	}

	public ProdutoBuilder sku(String sku) {
		produto.setSku(sku );
		return this;
	}

	public ProdutoBuilder deID(Integer id) {
		produto.setId(id );
		return this;
	}

	public ProdutoBuilder adicionaEstoqueDe(Integer quantidade) {
		produto.adicionaNoEstoque(quantidade);
		return this;
	}


	public ProdutoBuilder possui(Categoria...categorias) {
		produto.setCategorias( new LinkedHashSet<>(Arrays.asList(categorias)) );
	    /*
        //No Java 9+
        Set<String> setTelefones = Set.of(telefones);

        //No Java 10+, o tipo genêrico é inferido pelo parâmetro
        var setTelefones = Set.of(telefones);
	    */
		return this;
	}

	public ProdutoBuilder preco(BigDecimal preco) {
		produto.setPrecoAtual(preco );
		return this;
	}


	public Produto constroi(){
		return this.produto;
	}



}