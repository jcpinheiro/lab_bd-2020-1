package ifma.dcomp.lbd.aula_jdbc.infra;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionPool {
	
	private DataSource dataSource;
	
	
	public ConnectionPool() {
		
		MysqlDataSource mysqlDataSource = new MysqlDataSource();
		//String url = "jdbc:mysql://localhost/lojadb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String url = "jdbc:mysql://localhost/loja?useSSL=false";
		
		mysqlDataSource.setURL(url);
		mysqlDataSource.setUser("root");
		mysqlDataSource.setPassword("root");
		
		this.dataSource = mysqlDataSource;
		
	}
	
	
	public Connection getConexao() throws SQLException {
		System.out.println("Tentando conectar ...");
		
		Connection conexao = dataSource.getConnection();
		
		System.out.println("Conectado com sucesso ...");
		
		return conexao;
	}

}
