package ifma.dcomp.lbd.aula_jdbc.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

	private Database() {}

	private static Connection conexao = null;

	public static Connection getConnection() {
		if (conexao == null) {
			try {
				Properties propriedades = carregaPropriedades();
				String url = propriedades.getProperty("dburl");
				conexao = DriverManager.getConnection(url, propriedades);
			}
			catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return conexao;
	}

	private static Properties carregaPropriedades() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}

		catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}


	/*public static Connection getConnection() throws SQLException {
		
		return DriverManager
				 .getConnection(
                 "jdbc:mysql://localhost/lojadb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
						         "root", "root");
	}*/

}
