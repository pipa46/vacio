package com.capgemini.ccsw.tutorial.clientes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.tutorial.clientes.model.Clientes;
import com.capgemini.ccsw.tutorial.clientes.model.ClientesDto;
import com.capgemini.ccsw.tutorial.config.mapper.BeanMapper;

/**
 * @author ccsw
 */
@RequestMapping(value = "/clientes")
@RestController
@CrossOrigin(origins = "*")
public class ClientesController {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    BeanMapper beanMapper;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<ClientesDto> findAll() {
        List<Clientes> clientes = this.clientesService.findAll();

        return this.beanMapper.mapList(clientes, ClientesDto.class);

    }

    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody ClientesDto dto) {

        this.clientesService.save(id, dto);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {

        this.clientesService.delete(id);
    }
}
