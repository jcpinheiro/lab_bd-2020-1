package ifma.dcom.lbd.financas;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ifma.dcom.lbd.financas.dao.ContaDAO;
import ifma.dcom.lbd.financas.infra.ConnectionFactory;
import ifma.dcom.lbd.financas.modelo.Conta;

public class TesteJDBCMySQL {

	public static void main(String[] args) throws SQLException {

		Conta conta = new Conta();
		conta.setTitular("Maria Ferreira");
		conta.setBanco("Itau");
		conta.setAgencia("0063");
		conta.setNumero("432561");

		try (Connection con = new ConnectionFactory().getConnectionMySQL()) {

			con.setAutoCommit(false);

			ContaDAO dao = new ContaDAO(con);
			dao.adiciona(conta);

			List<Conta> lista = dao.lista();

			for (Conta c : lista) {
				System.out.println(c.getTitular());
			}

            con.commit();
		}
	}

}
