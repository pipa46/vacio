package com.capgemini.ccsw.tutorial.prestamos.model;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.capgemini.ccsw.tutorial.clientes.model.Clientes;
import com.capgemini.ccsw.tutorial.game.model.Game;

@Entity
@Table(name="Prestamos")
public class Prestamos
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
	
    @ManyToOne
    @JoinColumn(name = "juego_id", nullable = false)
    private Game nombreJuego;
    
    @ManyToOne
    @JoinColumn(name = "cliente_id",nullable = false)
    private Clientes nombreCliente;
    
	@Column(name = "fecha_Inicio",nullable = false)
    private String fechaInicio;
    
    @Column(name = "fecha_Fin",nullable = false)
    private String fechaFin;
    
    
    public Game getnombreJuego() {
		return this.nombreJuego;
	}

	public void setnombreJuego(Game nombreJuego) {
		this.nombreJuego = nombreJuego;
	}
 
	public Clientes getnombreCliente() {
		return this.nombreCliente;
	}

	public void setnombreCliente(Clientes nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
}