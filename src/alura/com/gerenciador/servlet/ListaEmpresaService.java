package alura.com.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import alura.com.gerenciador.entities.Banco;
import alura.com.gerenciador.entities.Empresa;

@WebServlet(name = "EmpresasService", urlPatterns = { "/empresas" })
public class ListaEmpresaService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Empresa> empresas = new Banco().getEmpresas();
		
		String valorHead = request.getHeader("Accept");
		
		System.out.println(valorHead);
		
		if(valorHead.contains("xml")) {
			XStream xstream = new XStream();
			String xml = xstream.toXML(empresas);
			xstream.alias("empresa", Empresa.class);		
			response.setContentType("application/json");
			response.getWriter().print(xml);
		}else if(valorHead.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			response.setContentType("application/json");
			response.getWriter().print(json);
		}else {
			response.setContentType("application/json");
			response.getWriter().print("{'message':'no content'}");
		}
		
				
		  		 
	
	}

}
