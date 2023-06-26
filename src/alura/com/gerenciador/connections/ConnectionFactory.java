package alura.com.gerenciador.connections;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	
	public DataSource dataSource;
	
	public ConnectionFactory() {
		
		ComboPooledDataSource pool =  new ComboPooledDataSource();
		
		pool.setJdbcUrl("jdbc:mysql://localhost/gerenciador?useTimezone=true&serverTimezone=UTC");
		pool.setUser("ricardo_rolim");
		pool.setPassword("Desenv@123");
		
		pool.setMaxPoolSize(15);
		
		this.dataSource = pool;
		
	}
	
	public Connection criaConexao() throws SQLException {
		
		return this.dataSource.getConnection();
	}

}
