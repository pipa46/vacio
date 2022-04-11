package com.capgemini.ccsw.tutorial.clientes;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import com.capgemini.ccsw.tutorial.clientes.model.ClientesDto;

/**
* @author ccsw
*/
@SpringBootTest
@Transactional
public class ClientesTest
{
	@Autowired
	private ClientesController c_c;
	@Test
	public void devolver_todas_los_clientes()
	{
		assertNotNull(c_c);
		int clientest=5;
		List<ClientesDto> clientes=c_c.findAll();
		assertNotNull(clientes);
		assertEquals(clientest,clientes.size());
		
		
	}
	
	@Test
	public void si_existe_el_mismo_nombre_no_se_guarda()
	{
		assertNotNull(c_c);
		String nuevo="Xavi";
		long id=1;
		ClientesDto dto=new ClientesDto();
		dto.setNombre(nuevo);
		c_c.save(null, dto);
		List<ClientesDto>clientes=c_c.findAll();
		assertNotNull(clientes);
		assertEquals(id,clientes.size());
	}
	

}