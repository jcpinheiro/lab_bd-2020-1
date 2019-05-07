package ifma.dcom.lbd.financas.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnectionMySQL() {
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/contas?useTimezone=true&serverTimezone=UTC",
				   "root",
			    "root");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}

	public Connection getConnectionH2() {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			return DriverManager.getConnection("jdbc:hsqldb:contas", "sa", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

	}

}
