package com.capgemini.ccsw.tutorial.autor;

import org.springframework.data.domain.Page;

import com.capgemini.ccsw.tutorial.autor.model.Autor;
import com.capgemini.ccsw.tutorial.autor.model.AutorDto;
import com.capgemini.ccsw.tutorial.autor.model.AutorSearchDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.ccsw.tutorial.config.mapper.BeanMapper;

/**
* @author ccsw
*/
@RequestMapping(value = "/autor")
@RestController
@CrossOrigin(origins = "*")
public class AutorController
{ 
	@Autowired
	AutorService autorServicio;
	
	@Autowired
	BeanMapper beanMapper;

   
	@RequestMapping(path="",method=RequestMethod.POST)
    public Page<AutorDto> findPage(@RequestBody AutorSearchDto dto) 
	{

        return this.beanMapper.mapPage(this.autorServicio.findPage(dto), AutorDto.class);

    }

 
	@RequestMapping(path={"","/{id}"},method=RequestMethod.PUT)
    public void save(@PathVariable (name="id",required=false)Long id,@RequestBody AutorDto data) 
	{
		this.autorServicio.save(id, data);

    }

	@RequestMapping(path={"","/{id}"},method=RequestMethod.DELETE)
    public void delete(@PathVariable ("id")Long id)
	{
      this.autorServicio.delete(id);
    }
	public List<AutorDto> findAll() {

	    List<Autor> authors = this.autorServicio.findAll();

	    return this.beanMapper.mapList(authors, AutorDto.class);
	}
}
