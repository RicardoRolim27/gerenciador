package alura.com.gerenciador.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.com.gerenciador.acao.Acao;
import alura.com.gerenciador.entities.Banco;
import alura.com.gerenciador.entities.Empresa;

public class NovaEmpresaController implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Empresa empresa = new Empresa();
		
		empresa.setName(request.getParameter("nomeEmpresa"));
		
		String paramDataEmpresa = request.getParameter("data");
		
		Date data = null;
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		empresa.setDataAbertura(data);
		
		Banco banco = new Banco();
		
		banco.adiciona(empresa);
		
		return "redirect:controller?executa=ListaEmpresasController";
		
	}
	
	

}
