package ifma.dcomp.lbd.aula_jdbc.modelo;

public class Produto {
	
	private int id;
	private String nome;
	private String descricao;
	
	private Categoria categoria;


	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		
	}
	
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

}
