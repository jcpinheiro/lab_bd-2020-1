package teste_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ifma.dcomp.lbd.aula_jdbc.dao.ProdutoDAO;
import ifma.dcomp.lbd.aula_jdbc.infra.ConnectionPool;
import ifma.dcomp.lbd.aula_jdbc.modelo.Produto;

public class TesteInsertProdutoDAO {

	public static void main(String[] args) throws SQLException {
		

		try (Connection conexao = new ConnectionPool().getConexao() ) {
			
			ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

			Produto produto = new Produto("SmartPhone", "tela de retina" );
			
			Produto salva = produtoDAO.salva(produto);
			
			System.out.println("id : " + produto.getId() );

			
		}
	}
}
