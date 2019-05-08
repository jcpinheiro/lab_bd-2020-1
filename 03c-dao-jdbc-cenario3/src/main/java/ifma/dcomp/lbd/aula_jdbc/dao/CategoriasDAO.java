package ifma.dcomp.lbd.aula_jdbc.dao;

import com.mysql.jdbc.Connection;
import ifma.dcomp.lbd.aula_jdbc.modelo.Categoria;
import ifma.dcomp.lbd.aula_jdbc.modelo.Produto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriasDAO {

    private final Connection con;

    public CategoriasDAO(Connection con) {
        this.con = con;
    }

    public List<Categoria> buscaCategoriasSemOsProdutos() throws SQLException {
    	
    	 List<Categoria> categorias = new ArrayList<>();

         String sql = "select * from Categoria";
         try(PreparedStatement stmt = con.prepareStatement(sql)) {
             stmt.execute();
             
             try(ResultSet rs = stmt.getResultSet()) {
                 while(rs.next()) {
                     Categoria categoria = montaCategoria(rs);
                     categorias.add(categoria);
                 }
             }
         }
         return categorias;
    }

    public List<Produto> buscaProdutosDa(Categoria categoria) {
    	
    	return null;
    }
    
    public List<Categoria> buscaCategoriasComProdutos() throws SQLException {
    	
       	List<Categoria> categorias = new ArrayList<>();
        Categoria ultima = null;

        String sql = "select c.id as c_id, c.nome as c_nome, p.id as p_id, p.nome as p_nome, p.descricao as p_descricao "
        		+ "from categorias as c join produtos as p on p.categoria_id = c.id";
       
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.execute();
           
            try(ResultSet rs = stmt.getResultSet()) {
            	 
            	while(rs.next()) {
                     int idCategoria = rs.getInt("c_id");
                     String nomeCategoria = rs.getString("c_nome");
                
                     // cria a categoria apenas uma vez
                     if(ultima==null || !ultima.getNome().equals(nomeCategoria)) {
                         Categoria categoria = new Categoria(idCategoria, nomeCategoria);
                         categorias.add(categoria);
                         ultima = categoria;
                     }
                     
                     int idDoProduto = rs.getInt("p_id");
                     String nomeDoProduto =rs.getString("p_nome");
                     String descricaoDoProduto = rs.getString("p_descricao");
                     Produto p = new Produto(nomeDoProduto, descricaoDoProduto);
                     p.setId(idDoProduto);
                     ultima.adiciona(p);
                 }
            }
        }
        return categorias;    
    }
    
	private Categoria montaCategoria(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		 String nome = rs.getString("nome");
		 Categoria categoria = new Categoria(id, nome);
		 
		return categoria;
	}
}