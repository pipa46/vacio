package com.capgemini.ccsw.tutorial.clientes;

import java.util.List;

import com.capgemini.ccsw.tutorial.clientes.model.Clientes;
import com.capgemini.ccsw.tutorial.clientes.model.ClientesDto;

public interface ClientesService {
    List<Clientes> findAll();

    void save(Long id, ClientesDto dto);

    void delete(Long id);

    Clientes get(Long id);

}
