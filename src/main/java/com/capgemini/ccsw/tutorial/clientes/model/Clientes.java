package com.capgemini.ccsw.tutorial.clientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Clientes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

public Long getId() {
	return this.id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return this.name;
}

public void setNombre(String nombre) {
	this.name = nombre;
}
public String toString()
{
	return "Cliente id = " +id+ ","+"con nombre =" +name;
}

}
