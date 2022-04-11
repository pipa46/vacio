package com.capgemini.ccsw.tutorial.clientes.model;


public class ClientesDto
{
	private Long id;
	
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String nombre) {
		this.name = nombre;
	}
	public String toString()
	{
		return "Cliente id = "+id+","+"con nombre ="+name;
	}
}