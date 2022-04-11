package com.capgemini.ccsw.tutorial.game;

import java.util.List;

import com.capgemini.ccsw.tutorial.game.model.Game;
import com.capgemini.ccsw.tutorial.game.model.GameDto;

public interface GameService
{
	List<Game>find(String title,Long idCategory);
	
	void save(Long id,GameDto dto);
	
	Game get(Long id);
	
	List<Game>findAll();
}