package alura.com.gerenciador.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import alura.com.gerenciador.acao.Acao;
import alura.com.gerenciador.entities.Banco;
import alura.com.gerenciador.entities.Usuario;

public class LoginController implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		
		String senha = request.getParameter("senha");
		
		Banco banco = new Banco();
		
		Usuario user = banco.existeUsuario(usuario, senha);
		
		if(user != null) {
			System.out.println("Bem-vindo " + user.getLogin() + "!");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", user);
			return "redirect:controller?executa=ListaEmpresasController";
		}
		
		System.out.println("Usuário não existe!");
		
		return "redirect:controller?executa=LoginFormController";
		
	}

}
