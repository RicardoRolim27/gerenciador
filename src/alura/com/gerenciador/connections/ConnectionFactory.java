package alura.com.gerenciador.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection criaConexao() throws SQLException {
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
		
		return DriverManager
				.getConnection("jdbc:mysql://localhost/gerenciador?useTimezone=true&serverTimezone=UTC", 
						"ricardo_rolim", "Desenv@123");
	}

}
