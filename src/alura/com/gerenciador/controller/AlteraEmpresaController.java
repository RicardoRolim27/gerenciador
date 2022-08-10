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

public class AlteraEmpresaController implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String nomeEmpresa = request.getParameter("nomeEmpresa");
		String paramDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		
		System.out.println(id);
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaPorId(id);
		
		empresa.setName(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);

		return "redirect:controller?executa=ListaEmpresasController";
		
	}
	
	

}
