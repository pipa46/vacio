package com.capgemini.ccsw.tutorial.autor.model;

public class AutorDto
{
	private Long id;
	
	private String nombre;
	
	private String nacionalidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String toString()
	{
		return "Autor id = "+id+","+"con nombre ="+nombre+" y nacionalidad"+nacionalidad;
	}

}
