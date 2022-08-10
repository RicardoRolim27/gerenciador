package alura.com.gerenciador.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> empresas = new ArrayList<>();

	private static List<Cliente> clientes = new ArrayList<>();
	
	private static List<Usuario> usuarios = new ArrayList<>();

	private static Integer chaveSequencial = 1;

	static {
		Empresa empresa = new Empresa();
		empresa.setName("Google");
		empresa.setId(chaveSequencial++);

		Empresa empresa2 = new Empresa();
		empresa2.setName("Alura");
		empresa2.setId(chaveSequencial++);

		empresas.add(empresa);
		empresas.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("ricardo.o");
		u1.setSenha("1234");
		
		Usuario u2 = new Usuario();
		u2.setLogin("henrique.l");
		u2.setSenha("1234");
		
		usuarios.add(u1);
		usuarios.add(u2);
	}

	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		empresas.add(empresa);

	}

	public List<Empresa> getEmpresas() {
		return Banco.empresas;
	}

	public void gravaCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public List<Cliente> getCliente() {
		return Banco.clientes;
	}

	public void removeEmpresa(Integer id) {

		Iterator<Empresa> it = empresas.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {

				it.remove();
			}

		}

	}

	public  Empresa buscaEmpresaPorId(Integer id) {
		
		for (Empresa empresa : empresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		
		return null;
	}

	public Usuario existeUsuario(String usuario, String senha) {
		
		for (Usuario u : usuarios) {
			if(u.ehIgual(usuario, senha)) {
				return u;
			}
		}
		
		return null;
	}

}
