package alura.com.gerenciador.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import alura.com.gerenciador.entities.Banco;
import alura.com.gerenciador.entities.Cliente;
import alura.com.gerenciador.entities.Empresa;


@WebServlet("/cadastraCliente")
public class CadastraClienteService extends HttpServlet {
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
		
		Cliente cliente = new Cliente();
		
		cliente = gson.fromJson(json2, Cliente.class);
		
		Banco banco = new Banco();
		
		banco.gravaCliente(cliente);
		
		System.out.println(cliente.getId());
		System.out.println(cliente.getName());
		

	}
	
	
}
