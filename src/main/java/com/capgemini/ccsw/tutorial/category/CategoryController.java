package com.capgemini.ccsw.tutorial.category;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.capgemini.ccsw.tutorial.category.model.CategoryDto;
import com.devonfw.module.beanmapping.common.api.BeanMapper;


/**
* @author ccsw
*/
@RequestMapping(value = "/category")
@RestController
@CrossOrigin(origins="*")
public class CategoryController
{
	@Autowired
	CategoryService categoryService;
	@Autowired
	BeanMapper beanMapper;
	
  
  /**
  * Método para recuperar todas las Category
  * @return
  */
  @RequestMapping(path = "", method = RequestMethod.GET)
  public List<CategoryDto> findAll()
  {
	  return this.beanMapper.mapList(this.categoryService.findAll(), CategoryDto.class);
  }
  
  @RequestMapping(path = {"","/{id}"}, method = RequestMethod.PUT)
  public void save(@PathVariable(name="id",required=false)Long id,@RequestBody CategoryDto dto)
  {
	
     this.categoryService.save(id,dto);
	  
  }
  @RequestMapping(path="/{id}",method=RequestMethod.DELETE)
  public void detele(@PathVariable("id")Long id)
  {
	  this.categoryService.detele(id);
  }


	
}

