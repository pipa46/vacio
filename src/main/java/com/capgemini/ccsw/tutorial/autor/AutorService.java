package com.capgemini.ccsw.tutorial.autor;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.tutorial.autor.model.Autor;
import com.capgemini.ccsw.tutorial.autor.model.AutorDto;
import com.capgemini.ccsw.tutorial.autor.model.AutorSearchDto;

public interface AutorService
{
	Autor get(Long id);
	
	Page <Autor>findPage(AutorSearchDto dto);
	
	void save(Long id,AutorDto data);
	
	void delete(Long id);

	List<Autor> findAll();

}
