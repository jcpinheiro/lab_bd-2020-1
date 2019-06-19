package edu.ifma.lbd.estoque.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


@Entity
public class Produto implements EntidadeBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String nome;

    @Column(unique = true)
    private String sku;

    @Column(name = "preco_atual")
    private BigDecimal precoAtual;

    @Column(name = "quantidade_estoque")
    private Integer quantidaEstoque = 0;

    @ManyToMany
    @JoinTable(
            name = "produto_categoria",
            joinColumns = @JoinColumn(name = "produto_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private Set<Categoria> categorias = new LinkedHashSet<>();

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(BigDecimal precoAtual) {
        this.precoAtual = precoAtual;
    }

    public Integer getQuantidaEstoque() {
        return quantidaEstoque;
    }

/*
    public void setQuantidaEstoque(Integer quantidaEstoque) {
        this.quantidaEstoque = quantidaEstoque;
    }
*/

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }


    /* Foi adicionado os métodos para manipular a quantidade em estoque */

    public void adicionaNoEstoque(Integer quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser um Valor Positivo");
        }
        this.quantidaEstoque = this.getQuantidaEstoque() + quantidade;
    }


    public void baixaNoEstoque(Integer quantidade) {

        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser um Valor Positivo");
        }
        Integer novaQuantidade = this.getQuantidaEstoque() - quantidade;

        if (novaQuantidade < 0) {
            throw new IllegalArgumentException("Não há disponibilidade no estoque de "
                    + quantidade + " itens do produto " + this.getSku() + ".");
        }

        this.quantidaEstoque = novaQuantidade;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sku='" + sku + '\'' +
                ", precoAtual=" + precoAtual +
                ", quantidaEstoque=" + quantidaEstoque +
                ", categorias=" + categorias +
                '}';
    }
}


