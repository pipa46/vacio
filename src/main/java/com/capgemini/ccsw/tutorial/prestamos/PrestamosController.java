package com.capgemini.ccsw.tutorial.prestamos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ccsw.tutorial.config.mapper.BeanMapper;
import com.capgemini.ccsw.tutorial.prestamos.model.Prestamos;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamosDto;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamosSearchDto;

@RequestMapping(value = "/prestamos")
@RestController
@CrossOrigin(origins = "*")
public class PrestamosController {
    @Autowired
    PrestamosService prestamosService;

    @Autowired
    BeanMapper beanMapper;

    public Page<PrestamosDto> findPage(@RequestBody PrestamosSearchDto dto) {

        return this.beanMapper.mapPage(this.prestamosService.findPage(dto), PrestamosDto.class);
    }

    @RequestMapping(path = { "", "/{id}" }, method = RequestMethod.PUT)
    public void save(@PathVariable(name = "id", required = false) Long id, @RequestBody PrestamosDto data) {
        this.prestamosService.save(id, data);

    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        this.prestamosService.delete(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Page<PrestamosDto> find(@RequestParam(value = "idCliente", required = false) Long idCliente,
            @RequestBody PrestamosSearchDto dto, @RequestParam(value = "idJueg", required = false) Long idJuego,
            @RequestParam(value = "fecha", required = false) String fecha) {

        Page<Prestamos> prestamos = prestamosService.find(idCliente, dto, idJuego, fecha);

        return this.beanMapper.mapPage(prestamos, PrestamosDto.class);
    }

}