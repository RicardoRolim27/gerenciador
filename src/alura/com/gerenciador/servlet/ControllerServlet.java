package alura.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alura.com.gerenciador.acao.Acao;


//@WebServlet("/controller")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramExecuta = request.getParameter("executa");
		
		System.out.println(paramExecuta);
		
		/*
		 * HttpSession sessao = request.getSession();
		 * 
		 * boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") ==
		 * null); boolean ehUmaAcaoProtegida = !(paramExecuta.equals("LoginController")
		 * || paramExecuta.equals("LoginFormController"));
		 * 
		 * if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
		 * response.sendRedirect("controller?executa=LoginFormController"); return; }
		 */
		
		String retornoExcuta = null;
		
		String nomeDaClasse = "alura.com.gerenciador.controller." + paramExecuta;
		
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			retornoExcuta = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = retornoExcuta.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
		/*switch (paramExecuta) {
		case "ListaEmpresasController":
			ListaEmpresasController empresas = new ListaEmpresasController();
			retornoExcuta = empresas.executa(request, response);
			break;
		case "RemoveEmpresa":
			RemoveEmpresaController deletaEmpresa = new RemoveEmpresaController();
			retornoExcuta = deletaEmpresa.executa(request, response);
			break;
		case "MostraEmpresa":
			MostraEmpresaController mostraEmpresa = new MostraEmpresaController();
			retornoExcuta = mostraEmpresa.executa(request, response);
			break;
		case "AlteraEmpresa":
			AlteraEmpresaController alteraEmpresa = new AlteraEmpresaController();
			retornoExcuta = alteraEmpresa.executa(request, response);
			break;	
		case "NovaEmpresa":
			NovaEmpresaController novaEmpresa = new NovaEmpresaController();
			retornoExcuta= novaEmpresa.executa(request, response);
			break;
		case "NovaEmpresaForm":
			NovaEmpresaFormController novaEmpresaForm = new NovaEmpresaFormController();
			retornoExcuta= novaEmpresaForm.executa(request, response);
			break;
		default:
			throw new IllegalArgumentException("Valor do parametro 'executa' inesperado " + paramExecuta);
		}*/
		
	}	
}
