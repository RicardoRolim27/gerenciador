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

public class NovaEmpresaFormController implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		return "forward:cadastroEmpresaForm.jsp";
		
	}
	
	

}
