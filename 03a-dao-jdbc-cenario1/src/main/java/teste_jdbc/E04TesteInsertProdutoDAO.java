package teste_jdbc;

import ifma.dcomp.lbd.aula_jdbc.dao.ProdutoDAO;
import ifma.dcomp.lbd.aula_jdbc.infra.ConnectionPool;
import ifma.dcomp.lbd.aula_jdbc.modelo.Produto;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class E04TesteInsertProdutoDAO {

    public static void main(String[] args) throws SQLException {

        try (Connection conexao = new ConnectionPool().getConexao()) {

           ProdutoDAO produtoDAO = new ProdutoDAO(conexao );

               Produto produto = new Produto("SmartPhone", "tela de retina");

/*
               Produto produtoSalvo = produtoDAO.salva(produto);
               System.out.println("id : " + produtoSalvo.getId());
*/

 /*          produtoDAO.getProdutos()
                    .forEach(p ->   System.out.println(p ) );
*/

            //produtoDAO.getProdutos().forEach(System.out::println);

            List<Produto> produtoList = produtoDAO.getProdutos()
                    .stream()
                    .filter(p1 -> p1.getId() > 15 )
                    .collect(Collectors.toList());

            produtoList.forEach(System.out::println );


        }

        }

}
