package com.capgemini.ccsw.tutorial.clientes;
import java.util.List;

import com.capgemini.ccsw.tutorial.clientes.model.Clientes;
import com.capgemini.ccsw.tutorial.clientes.model.ClientesDto;

public interface ClientesService
{
	List <Clientes> findAll();
    void guardar(Long id,ClientesDto dto);
    void borrar(Long id);
    Clientes get(Long id);
   
}
