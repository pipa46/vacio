package com.capgemini.ccsw.tutorial.game;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ccsw.tutorial.game.model.Game;

@SpringBootTest
@Transactional
public class GameServiceTest
{
	@Autowired
	private GameService gameService;
	
	@Test
	public void obtener_id_del_juego_devuelve_juegos()
	{
		assertNotNull(gameService);
		
		Long gamessId=1L;
		
		Game games=gameService.get(gamessId);
		
		assertNotNull(games);
		assertEquals(gamessId,games.getId());
	}
	@Test
	public void si_no_existe_el_juego_deberia_devolver_nada()
	{
		assertNotNull(gameService);
		
		Long gamesId=0L;
		
		Game games=gameService.get(gamesId);
		
		assertNull(games);
	}

}
