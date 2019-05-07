package teste_jdbc;

import ifma.dcomp.lbd.aula_jdbc.dao.ProdutoDAO;
import ifma.dcomp.lbd.aula_jdbc.infra.ConnectionPool;
import ifma.dcomp.lbd.aula_jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;

public class E04TesteInsertProdutoDAO {

    public static void main(String[] args) throws SQLException {

        try (Connection conexao = new ConnectionPool().getConexao()) {

            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);

            Produto produto = new Produto("SmartPhone", "tela de retina");

            Produto produtoSalvo = produtoDAO.salva(produto );

            System.out.println("id : " + produtoSalvo.getId());


        }
    }
}
