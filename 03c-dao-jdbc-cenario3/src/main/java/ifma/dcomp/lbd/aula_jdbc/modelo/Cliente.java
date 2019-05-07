package ifma.dcomp.lbd.aula_jdbc.modelo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente")
public class Cliente {

    public Cliente() {  }


    public Cliente(Endereco endereco) {
        this.enderecos.add(endereco );
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(name = "doc_receita_federal", nullable = false, length = 14)
    private String documentoReceitaFederal;

    @Enumerated(EnumType.STRING)
    @Column(length=20)
    private TipoPessoa tipo;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Endereco> enderecos = new ArrayList<>();


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumentoReceitaFederal() {
        return documentoReceitaFederal;
    }

    public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
        this.documentoReceitaFederal = documentoReceitaFederal;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public List<Endereco> getEnderecos() {
        return Collections.unmodifiableList(enderecos );
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }


    public void adicionaUmEndereco(Endereco endereco) {
        this.enderecos.add(endereco );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getId(), cliente.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}