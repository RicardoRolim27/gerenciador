package alura.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import alura.com.gerenciador.acao.Acao;
import alura.com.gerenciador.entities.Banco;

public class RemoveEmpresaController implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String paramId = request.getParameter("id");
		
		Integer id =  Integer.valueOf(paramId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		
		banco.removeEmpresa(id);
		
		return "redirect:controller?executa=ListaEmpresasController";
		
	}

}
