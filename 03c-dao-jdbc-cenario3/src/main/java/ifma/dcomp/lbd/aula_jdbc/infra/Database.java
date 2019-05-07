package ifma.dcomp.lbd.aula_jdbc.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static Connection getConnection() throws SQLException {
		
		return DriverManager
				 .getConnection(
                 "jdbc:mysql://localhost/lojadb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
						         "root", "root");
	}

}
