package alura.com.gerenciador.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import alura.com.gerenciador.entities.Banco;
import alura.com.gerenciador.entities.Empresa;
import alura.com.gerenciador.servicies.GravaEmpresaService;


@WebServlet("/cadastraEmpresa")
public class CadastraEmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder json = new StringBuilder();
		BufferedReader reader = request.getReader();
		String linha;
		
		while( (linha = reader.readLine()) != null ){
		    json.append(linha);
		}
		
		System.out.println(json);
		
		Gson gson = new Gson();
		
		String json2 = json.toString();
		
		Empresa empresa = new Empresa();
		
		empresa = gson.fromJson(json2, Empresa.class);
		
		Banco banco = new Banco();
		
		banco.adiciona(empresa);
		
		GravaEmpresaService gravaEmpresa = new GravaEmpresaService();
		
		try {
			gravaEmpresa.gravar(empresa);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println(empresa.getId());
		System.out.println(empresa.getName());
		System.out.println(empresa.getDataAbertura());
		

	}
	
	
}
