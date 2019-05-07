package ifma.dcomp.lbd.aula_jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private final Integer id;
    private final String nome;
    
    private final List<Produto> produtos = new ArrayList<>();

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    public Integer getId() {
		return id;
	}
    
    public String getNome() {
		return nome;
	}

	public void adiciona(Produto produto) {
		produtos.add(produto);
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

	
}