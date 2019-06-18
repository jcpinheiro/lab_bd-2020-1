package edu.ifma.lbd.estoque.modelo;

import edu.ifma.lbd.estoque.modelo.builder.ProdutoBuilder;
import edu.ifma.lbd.estoque.repositorio.ProdutoRepository;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ProdutoTest {

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAdicionarQuantidadeNegativaNoEstoque() {
        Produto produto = ProdutoBuilder.umProduto().constroi();
        produto.adicionaNoEstoque(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoDeveAdicionarQuantidadeZeroNoEstoque() {
        Produto produto = ProdutoBuilder.umProduto().constroi();
        produto.adicionaNoEstoque(0);
    }

    @Test
    public void deveAdicionarQuantidadePositivaNoEstoque() {
        Produto produto = ProdutoBuilder.umProduto().constroi();
        produto.adicionaNoEstoque(1);

        assertThat(produto.getQuantidaEstoque(), equalTo(1) );
    }

    @Test(expected = IllegalArgumentException.class)
    public void deveGarantirEstoqueMinimo() {
        Produto produto = ProdutoBuilder.umProduto().constroi();
        produto.adicionaNoEstoque(1);
        produto.baixaNoEstoque(2);
    }

}