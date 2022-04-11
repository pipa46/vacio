package com.capgemini.ccsw.tutorial.game;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.game.model.Game;
import com.capgemini.ccsw.tutorial.game.model.GameDto;
import com.capgemini.ccsw.tutorial.autor.AutorService;
import com.capgemini.ccsw.tutorial.category.CategoryService;

/**
* @author ccsw
*/
@Service
@Transactional
public class GameServiceImpl implements GameService {

    @Autowired
    GameRepository gameRepository;
    
    @Autowired
    AutorService authorService;
    
    @Autowired
    CategoryService categoryService;
    
    

    /**
    * {@inheritDoc}
    */
    @Override
    public List<Game> find(String title, Long category) {

        return this.gameRepository.find(title, category);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void save(Long id, GameDto dto) {

        Game game = null;

        if (id == null)
            game = new Game();
        else
            game=this.get(id);

        BeanUtils.copyProperties(dto, game, "id", "author", "category");
        
        game.setAuthor(authorService.get(dto.getAuthor().getId()));
        game.setCategory(categoryService.get(dto.getCategory().getId()));

        this.gameRepository.save(game);
    }
    @Override
    public Game get(Long id)
    {
    	return this.gameRepository.findById(id).orElse(null);
    }
    @Override
    public List<Game>findAll()
    {
    	return (List<Game>) this.gameRepository.findAll();
    }

}

