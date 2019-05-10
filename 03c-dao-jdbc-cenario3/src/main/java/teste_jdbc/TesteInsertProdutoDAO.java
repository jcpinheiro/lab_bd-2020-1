package teste_jdbc;

import ifma.dcomp.lbd.aula_jdbc.dao.ProdutoDAO;
import ifma.dcomp.lbd.aula_jdbc.infra.Database;
import ifma.dcomp.lbd.aula_jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteInsertProdutoDAO {

	public static void main(String[] args) throws SQLException {
		

		try (Connection conexao = Database.getConnection() ) {
			
			ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

			Produto produto = new Produto("SmartPhone", "tela de retina" );
			
			Produto salva = produtoDAO.salva(produto);
			
			System.out.println("id : " + produto.getId() );

			
		}
	}
}
