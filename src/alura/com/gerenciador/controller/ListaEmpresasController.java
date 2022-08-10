package alura.com.gerenciador.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alura.com.gerenciador.acao.Acao;
import alura.com.gerenciador.entities.Banco;
import alura.com.gerenciador.entities.Empresa;

public class ListaEmpresasController implements Acao {
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		
		return "forward:listaDeEmpresas.jsp";
		
	}

}
