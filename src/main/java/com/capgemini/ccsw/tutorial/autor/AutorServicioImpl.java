package com.capgemini.ccsw.tutorial.autor;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.autor.model.Autor;
import com.capgemini.ccsw.tutorial.autor.model.AutorDto;
import com.capgemini.ccsw.tutorial.autor.model.AutorSearchDto;

/**
* @author ccsw
*/
@Service
@Transactional
public class AutorServicioImpl implements AutorService {

    @Autowired
    AutorRepository autorRepository;
    
    
    @Override
    public Autor get(Long id)
    {
    	return this.autorRepository.findById(id).orElse(null);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public Page<Autor> findPage(AutorSearchDto dto) {

        return this.autorRepository.findAll(dto.getPageable());
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void save(Long id, AutorDto data) {

        Autor author = null;
        if (id != null)
            //author = this.get(id);
        	author=this.autorRepository.findById(id).orElse(null);
        else
            author = new Autor();

        BeanUtils.copyProperties(data, author, "id");

        this.autorRepository.save(author);
    }

    /**
    * {@inheritDoc}
    */
    @Override
    public void delete(Long id) {

        this.autorRepository.deleteById(id);

    }
    public List<Autor> findAll()
    {
    	return (List<Autor>) this.autorRepository.findAll();
    }

}
