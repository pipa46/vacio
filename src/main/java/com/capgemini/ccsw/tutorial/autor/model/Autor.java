package com.capgemini.ccsw.tutorial.autor.model;

import javax.persistence.*;


@Entity
@Table(name="Autor")
public class Autor
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private long id;
	
    @Column(name="nombre",nullable=false)
    private String nombre;
  
    @Column(name="nacionalidad")
    private String nacionalidad;
  
  
  public String getNombre()
  {
	   return this.nombre;
  }
  public long getId()
  {
	  return this.id;
  }
  public String getNacionalidad()
  {
	  return this.nacionalidad;
  }
  public void setNombre(String n)
  {
	  this.nombre=n;
  }
  public void setId(long id)
   {
		this.id=id;
   }
   public void setNacionalidad(String naci)
   {
	   this.nacionalidad=naci;
   }
   public String toString()
	{
		return "Autor id = "+id+","+"con nombre ="+nombre+" y nacionalidad"+nacionalidad;
	}
	
}
