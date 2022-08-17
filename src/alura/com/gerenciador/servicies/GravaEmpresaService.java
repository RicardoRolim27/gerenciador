package alura.com.gerenciador.servicies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

import alura.com.gerenciador.connections.ConnectionFactory;
import alura.com.gerenciador.entities.Empresa;

public class GravaEmpresaService {
	
	public void gravar(Empresa empresa) throws SQLException, ServletException {
		
		System.out.println("entrou no gravarEmpresaService");
		
		ConnectionFactory connection = new ConnectionFactory();
		
		Connection con = connection.criaConexao();
		
		Statement stm = con.createStatement();
		
		String nome = empresa.getName();
		
		String cnpj = empresa.getCnpj();
		
		Date dataAbertura = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataAbertura = empresa.getDataAbertura();
		
		String data = sdf.format(dataAbertura);
		
		
		String sql = "INSERT INTO EMPRESA (nome, cnpj, dataAbertura) VALUES (" + "'" + nome + "'" + ","
		   + "'" + cnpj + "'" + "," + "'" + data + "'" + ")";
		
		stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = stm.getGeneratedKeys();
		
		while(rs.next()) {
			Integer id = rs.getInt(1);
			
			System.out.println(id);
		}
		
	}

}
