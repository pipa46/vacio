package com.capgemini.ccsw.tutorial.prestamos;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.clientes.ClientesService;
import com.capgemini.ccsw.tutorial.game.GameService;
import com.capgemini.ccsw.tutorial.prestamos.model.Prestamos;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamosDto;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamosSearchDto;

@Service
@Transactional
public class PrestamosServiceImp implements PrestamosService {
    @Autowired
    PrestamosRepository prestamosRepository;

    @Autowired
    ClientesService clienteService;

    @Autowired
    GameService gameService;

    private int numero_veces = 0;

    @Override
    public Page<Prestamos> findPage(PrestamosSearchDto dto) {

        return this.prestamosRepository.findAll(dto.getPageable());

    }

    @Override
    public void save(Long id, PrestamosDto data) {

        Prestamos prestamos = new Prestamos();

        BeanUtils.copyProperties(data, prestamos);

        prestamos.setnombreCliente(clienteService.get(data.getNombreCliente().getId()));

        prestamos.setnombreJuego(gameService.get(data.getNombreJuego().getId()));

        int pageSize = 20;
        PrestamosSearchDto dto = new PrestamosSearchDto();
        dto.setPageable(PageRequest.of(0, pageSize));

        Page<Prestamos> prestamo = findPage(dto);
        boolean guardar = false;

        if (prestamo.stream()
                .anyMatch(k -> k.getnombreCliente().getNombre().equals(data.getNombreCliente().getNombre()))) {
            String t = "";
            int indice = 0;
            for (int j = 0; j < prestamo.getContent().size(); j++) {
                t = prestamo.getContent().get(j).getnombreJuego().getTitle();
                if (t.equals(data.getNombreJuego().getTitle()))
                    indice = j;
            }
            String fecha_fin = "";
            fecha_fin = prestamo.getContent().get(indice).getFechaFin();

            guardar = comprobacion(data, fecha_fin);

        }

        boolean guardar_2 = false;
        boolean guardar_3 = false;

        if (prestamo.stream()
                .anyMatch(k -> k.getnombreCliente().getNombre().equals(data.getNombreCliente().getNombre()))) {

            numero_veces = 0;
            String cliente, titulo = "";
            for (int i = 0; i < prestamo.getContent().size(); i++) {

                cliente = prestamo.getContent().get(i).getnombreCliente().getNombre();
                if (data.getNombreCliente().getNombre().equals(cliente))
                    numero_veces++;
            }

            int indice = 0;
            for (int j = 0; j < prestamo.getContent().size(); j++) {
                titulo = prestamo.getContent().get(j).getnombreJuego().getTitle();
                if (titulo.equals(data.getNombreJuego().getTitle()))
                    indice = j;
            }

            String fecha_fin = "";
            fecha_fin = prestamo.getContent().get(indice).getFechaFin();
            guardar_3 = comprobacion(data, fecha_fin);

        }

        if (numero_veces < 2)
            guardar_2 = true;

        if ((guardar_3 == true && guardar_2 == true && guardar == true)
                || (guardar_3 == false && guardar_2 == false && guardar == false))
            this.prestamosRepository.save(prestamos);

    }

    @Override
    public void delete(Long id) {
        this.prestamosRepository.deleteById(id);
    }

    @Override
    public Page<Prestamos> find(Long idCliente, PrestamosSearchDto dto, Long idJuego, String fecha) {

        return this.prestamosRepository.find(idCliente, dto.getPageable(), idJuego, fecha);

    }

    @Override
    public boolean comprobacion(PrestamosDto data, String fecha_fin) {

        String fecha_final = fecha_fin;
        String fecha_inicial = data.getFechaInicio();

        Calendar fecha_i = Calendar.getInstance();

        int inicio = 0;
        int f = fecha_inicial.indexOf("/");
        fecha_i.set(Calendar.YEAR, Integer.valueOf(fecha_inicial.substring(inicio, f)));
        inicio = f;
        f = fecha_inicial.indexOf("/", ++inicio);
        fecha_i.set(Calendar.MONTH, Integer.valueOf(fecha_inicial.substring(inicio, f)));
        inicio = f;
        fecha_i.set(Calendar.DAY_OF_MONTH, Integer.valueOf(fecha_inicial.substring(++inicio)));
        fecha_i.getTime();

        Calendar fecha_f = Calendar.getInstance();
        inicio = 0;
        f = fecha_final.indexOf("/");
        fecha_f.set(Calendar.YEAR, Integer.valueOf(fecha_final.substring(inicio, f)));
        inicio = f;
        f = fecha_final.indexOf("/", ++inicio);
        fecha_f.set(Calendar.MONTH, Integer.valueOf(fecha_final.substring(inicio, f)));
        inicio = f;
        fecha_f.set(Calendar.DAY_OF_MONTH, Integer.valueOf(fecha_final.substring(++inicio)));
        fecha_f.getTime();

        boolean k = false;

        if (fecha_i.after(fecha_f))
            k = true;

        return k;
    }

}
