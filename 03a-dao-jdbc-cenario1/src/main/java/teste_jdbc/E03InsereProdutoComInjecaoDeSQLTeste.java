package teste_jdbc;

import java.sql.*;

public class E03InsereProdutoComInjecaoDeSQLTeste {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost/estoque?useSSL=false";

        try (Connection connection = DriverManager.getConnection(url, "root", "root")) {

            //executaComStatement(connection );
            executaComPreparedStatment(connection );

        }

    }

    private static void executaComStatement(Connection connection) throws SQLException {

        try (Statement statement = connection.createStatement() ) {

            String nome = "Computador OctaCore";
            String descricao = "Computador com 8 GB de RAM, tela 15'pol";

			String sql = "INSERT INTO produtos (nome, descricao) VALUES ('"+ nome + "', '" + descricao  + "')";

            System.out.println("### " + sql);

            statement.execute(sql, Statement.RETURN_GENERATED_KEYS);

            ResultSet keys = statement.getGeneratedKeys();

            if (keys.next()) {
                System.out.println(keys.getInt(1));
            }


        }

    }


    private static void executaComPreparedStatment(Connection connection) throws SQLException {

        String sql = "Insert INTO produtos (nome, descricao) VALUES (?, ?)";

        try (PreparedStatement pStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            String nome = "Computador Core i7";
            String descricao = "Computador Core i7 com 8 GB de RAM, tela 10'pol";


            pStatement.setString(1, nome);
            pStatement.setString(2, descricao);

            pStatement.execute();

            ResultSet keys = pStatement.getGeneratedKeys();

            if (keys.next()) {
                System.out.println(keys.getInt(1));
            }


        }

    }
}
