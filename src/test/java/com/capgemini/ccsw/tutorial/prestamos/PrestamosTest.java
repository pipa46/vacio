package com.capgemini.ccsw.tutorial.prestamos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamosDto;
import com.capgemini.ccsw.tutorial.prestamos.model.PrestamosSearchDto;

@SpringBootTest
@Transactional
public class PrestamosTest
{
	private static final int total_prestamos=5;
	
	@Autowired
	private PrestamosController prestamosController;
	
	private final Long cliente_existente=1L;
	
	private final Long juego_existente=1L;
	
	
	@Test
	public void encuentraLasPrimeras5PaginasDeberiaDevolver5Resultados()
	{
		int pageSize = 5;
        assertNotNull(prestamosController);
        PrestamosSearchDto dto = new PrestamosSearchDto();
        dto.setPageable(PageRequest.of(0, pageSize));
        Page<PrestamosDto> resultPage = prestamosController.findPage(dto);
   
        assertNotNull(resultPage);
        assertEquals(total_prestamos, resultPage.getTotalElements());
        assertEquals(pageSize, resultPage.getContent().size());
	}
	
	@Test
	public void filtrar_clientes_devuelve_clientes_filtrados()
	{
		assertNotNull(prestamosController);
		int pageSize = 5;
		int prestamos_con_filtro=3;
		PrestamosSearchDto dto = new PrestamosSearchDto();
        dto.setPageable(PageRequest.of(0, pageSize));
		Page<PrestamosDto>prestamos=prestamosController.find(cliente_existente,dto,null,null);
		assertNotNull(prestamos);
		assertEquals(prestamos_con_filtro,prestamos.getContent().size());
	}
	@Test
	public void filtrar_juegos_devuelve_juegos_filtrados()
	{
		assertNotNull(prestamosController);
		int pageSize = 5;
		int prestamos_con_filtro=2;
		PrestamosSearchDto dto = new PrestamosSearchDto();
        dto.setPageable(PageRequest.of(0, pageSize));
		Page<PrestamosDto>prestamos=prestamosController.find(cliente_existente,dto,juego_existente,null);
		assertNotNull(prestamos);
		assertEquals(prestamos_con_filtro,prestamos.getContent().size());
		
	}
	
	@Test
	public void sin_filtrar_devuelve_la_BD()
	{
		assertNotNull(prestamosController);
		int pageSize = 5;
		PrestamosSearchDto dto = new PrestamosSearchDto();
        dto.setPageable(PageRequest.of(0, pageSize));
		Page<PrestamosDto>prestamos=prestamosController.find(null,dto,null,null);
		assertNotNull(prestamos);
		assertEquals(total_prestamos,prestamos.getContent().size());
		
	}
	
	
	
	
}