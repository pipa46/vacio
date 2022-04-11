package com.capgemini.ccsw.tutorial.clientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.tutorial.clientes.model.Clientes;

@SpringBootTest
@Transactional
public class ClienteServiceTest 
{
	@Autowired
	private ClientesService clienteService;
	
	
	@Test
	public void obtener_clientes_id_devuelve_clientes()
	{
		assertNotNull(clienteService);
		Long clientesId=1L;
		Clientes clientes=clienteService.get(clientesId);
		assertNotNull(clientes);
		assertEquals(clientesId,clientes.getId());
		
		
	}
	@Test
	public void si_no_existe_clientes_devuelve_nada()
	{
		assertNotNull(clienteService);
		Long clientesId=0L;
		Clientes clientes=clienteService.get(clientesId);
		assertNull(clientes);
		
	}

}
