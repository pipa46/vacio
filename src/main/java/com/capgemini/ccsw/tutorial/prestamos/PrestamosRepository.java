package com.capgemini.ccsw.tutorial.prestamos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.capgemini.ccsw.tutorial.prestamos.model.Prestamos;

public interface PrestamosRepository extends CrudRepository<Prestamos,Long> 
{
	Page<Prestamos>findAll(Pageable pageable);
	
	@Query("select p from Prestamos p where(:nombreCliente is null or p.nombreCliente.id=:nombreCliente)and (:nombreJuego is null or p.nombreJuego.id=:nombreJuego)and(:fecha is null or :fecha Between p.fechaInicio And p.fechaFin )")
	Page<Prestamos>find(@Param("nombreCliente")Long idCliente,Pageable pageable,@Param("nombreJuego")Long idJuego,@Param("fecha")String fecha);
	
	
    
	
}
