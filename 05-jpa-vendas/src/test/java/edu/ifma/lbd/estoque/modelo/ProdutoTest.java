package edu.ifma.lbd.estoque.modelo;

import edu.ifma.lbd.estoque.modelo.builder.ProdutoBuilder;
import org.junit.*;

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


    @Test(expected = IllegalArgumentException.class)
    public void naoDeveReceberValorNegativoNaBaixaDoEstoque() {
        Produto produto = ProdutoBuilder.umProduto().constroi();
        produto.adicionaNoEstoque(1);
        produto.baixaNoEstoque(-2);
    }
}