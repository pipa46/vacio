package com.capgemini.ccsw.tutorial.category;


import java.util.*;


import com.capgemini.ccsw.tutorial.category.model.CategoryDto;
import com.capgemini.ccsw.tutorial.category.model.Category;


public  interface CategoryService 
{
	Category get(Long id);
	
	List <Category> findAll();
	
	void save(Long id,CategoryDto dto);

	void detele(Long id);
	
	



	
	

}
