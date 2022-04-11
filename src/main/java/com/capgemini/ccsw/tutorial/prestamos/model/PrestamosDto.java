package com.capgemini.ccsw.tutorial.prestamos.model;

import com.capgemini.ccsw.tutorial.clientes.model.ClientesDto;
import com.capgemini.ccsw.tutorial.game.model.GameDto;

public class PrestamosDto
{
	private Long id;
	
	 private GameDto nombreJuego;
	 
	 private ClientesDto nombreCliente;
	 
	 private String fechaInicio;
	
	 private String fechaFin;
	 
	 

	

	public GameDto getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(GameDto nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	public ClientesDto getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(ClientesDto nombreCliente) {
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
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public String toString()
	{
		return "Prestamo id = "+id+ " Juego " +nombreJuego + "cliente id " +nombreCliente+ " fecha de inicio" +fechaInicio+ "fecha de fin" +fechaFin;
	}
}
