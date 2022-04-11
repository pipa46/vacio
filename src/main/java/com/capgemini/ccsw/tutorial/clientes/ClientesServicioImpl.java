package com.capgemini.ccsw.tutorial.clientes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.clientes.model.Clientes;
import com.capgemini.ccsw.tutorial.clientes.model.ClientesDto;

@Service
public class ClientesServicioImpl implements ClientesService {
    @Autowired
    ClientesRepository clientesRepository;

    @Override
    public List<Clientes> findAll() {
        return (List<Clientes>) this.clientesRepository.findAll();
    }

    @Override
    public void save(Long id, ClientesDto dto) {

        List<Clientes> clientes = findAll();

        Clientes clientess = null;

        if (id == null)
            clientess = new Clientes();

        else
            clientess = this.get(id);

        clientess.setNombre(dto.getNombre());

        if (!clientes.stream().anyMatch(cliente -> cliente.getNombre().equals(dto.getNombre())))
            this.clientesRepository.save(clientess);

    }

    @Override
    public void delete(Long id) {
        this.clientesRepository.deleteById(id);
    }

    @Override
    public Clientes get(Long id) {
        return this.clientesRepository.findById(id).orElse(null);
    }

}
