package com.capgemini.ccsw.tutorial.autor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.capgemini.ccsw.tutorial.autor.model.Autor;

/**
* @author ccsw
*/
public interface AutorRepository extends CrudRepository<Autor, Long>
{

    Page<Autor> findAll(Pageable pageable);

}
