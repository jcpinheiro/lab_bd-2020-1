package edu.ifma.lbd.estoque.modelo;


import edu.ifma.lbd.estoque.modelo.enums.EstadoPedido;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime instanteCriacao;

    private BigDecimal frete = BigDecimal.ZERO;

    private BigDecimal desconto = BigDecimal.ZERO;

    @Column(columnDefinition = "text")
    private String observacoes;


    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new LinkedHashSet<>();

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido = EstadoPedido.ORCAMENTO;

    @ManyToOne
    private Cliente cliente;


    @OneToOne(mappedBy = "pedido")
    private Pagamento pagamento;

    @Embedded
    private EnderecoEntrega enderecoEntrega;

    @PrePersist
    private void prePersit() {
        this.instanteCriacao = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }

    public BigDecimal getFrete() {
        return frete;
    }

    public void setFrete(BigDecimal frete) {
        this.frete = frete;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }


    @Transient
    public String getEstadoPedido() {
        return estadoPedido.name();
    }

    public EstadoPedido finaliza() {
        return estadoPedido.finaliza();
    }

    public EstadoPedido cancela() {
        return estadoPedido.cancela();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    @Transient
    public BigDecimal getTotal() {
       return null;

    }
}
