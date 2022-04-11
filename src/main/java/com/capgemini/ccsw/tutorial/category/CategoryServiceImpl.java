package com.capgemini.ccsw.tutorial.category;

import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;



import com.capgemini.ccsw.tutorial.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial.category.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService
{
	@Autowired
	CategoryRepository categoryRepository;
	
	/**
	   * {@inheritDoc}
	   */
	
 @Override
 public Category get(Long id)
 {
	 return this.categoryRepository.findById(id).orElse(null);
 }

	

  @Override
  public List<Category> findAll()
  {
	  return (List<Category>) this.categoryRepository.findAll();
  }
  
  /**
   * {@inheritDoc}
   */
  
  @Override
  public void save(Long id, CategoryDto dto)
  {
	 Category categoria=null;
	  
	  if(id==null)
	  
		  categoria=new Category();
	  
	  else
		  categoria=this.get(id);
	 
	  
	  categoria.setName(dto.getName());
	  
	  this.categoryRepository.save(categoria);
  }
  /**
   * {@inheritDoc}
   */
  
  @Override
  public void detele(Long id)
  	{
	  	this.categoryRepository.deleteById(id);
  	}
	
	

}
