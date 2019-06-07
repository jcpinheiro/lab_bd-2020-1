package edu.ifma.lbd.estoque.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "pagamento_cartao")
public final class PagamentoCartao extends Pagamento {

    @Column(name = "numero_parcelas")
    private Short numeroDeParcelas;

    public Short getNumeroDeParcelas() {
        return numeroDeParcelas;
    }

    public void setNumeroDeParcelas(Short numeroDeParcelas) {
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
