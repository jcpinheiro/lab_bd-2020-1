package teste_jdbc;

import java.sql.*;

public class E01ListagemProdutosTeste {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost/estoque?useSSL=false";

        Connection connection = DriverManager.getConnection(url, "root", "root");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from produtos");

        while (resultSet.next() ) {
            int id = resultSet.getInt("id");
            String nome = resultSet.getString("nome");
            String descricao = resultSet.getString("descricao");


            String registro = String.format("ID %d \t Nome: %s \tDescrição: %s", id, nome, descricao );

            System.out.println(registro);
        }

        resultSet.close();
        statement.close();
        connection.close();

    }

}
