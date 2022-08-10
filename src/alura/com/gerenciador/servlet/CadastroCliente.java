package alura.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.com.gerenciador.entities.Banco;
import alura.com.gerenciador.entities.Cliente;


//@WebServlet("/cadastroCliente")
public class CadastroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		String name = request.getParameter("nome");
		cliente.setName(name);
		
		Banco banco = new Banco();
		
		banco.gravaCliente(cliente);
		
		request.setAttribute("name", cliente.getName());
		
		RequestDispatcher rd = request.getRequestDispatcher("/novoCliente.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
