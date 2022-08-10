package alura.com.gerenciador.entities;

import java.util.Date;

public class Empresa {
	
	private Integer id;
	private String 	name;
	private Date 	dataAbertura = new Date();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataAbertura() {
		return dataAbertura;
	}
	
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	

}
