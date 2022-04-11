package com.capgemini.ccsw.tutorial.prestamos;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.tutorial.prestamos.model.Prestamos;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamosDto;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamosSearchDto;

public interface PrestamosService {

    Page<Prestamos> findPage(PrestamosSearchDto dto);

    void save(Long id, PrestamosDto data);

    void delete(Long id);

    Page<Prestamos> find(Long idCliente, PrestamosSearchDto dto, Long idJuego, String fecha);

    boolean comprobacion(PrestamosDto data, String fecha_fin);

}
