package alura.com.gerenciador.testes;

import java.sql.Connection;
import java.sql.SQLException;

import alura.com.gerenciador.connections.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connection = new ConnectionFactory();
		
		Connection con = connection.criaConexao();
		
		System.out.println("fechando conexao");
		
		con.close();

	}

}
