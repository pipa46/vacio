package com.capgemini.ccsw.tutorial.category;

import org.springframework.boot.test.context.SpringBootTest;


import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.ccsw.tutorial.category.model.CategoryDto;

/**
* @author ccsw
*/
@SpringBootTest
@Transactional
public class CategoryTest 
{
	@Autowired
	private CategoryController categoryController;
	
	
	
	@Test
	public void findAllShouldReturnAllCategoriesInDB()
	{
		assertNotNull(categoryController);
		
		long categoriesSize=3;
		
		List<CategoryDto> categories=categoryController.findAll();
		
		assertNotNull(categories);
		assertEquals(categoriesSize,categories.size());
		
		
	}
	@Test
	public void saveWithoutidShouldCreateNewCategory()
	{
		assertNotNull(categoryController);
		String newCategoryName="Nueva Categoria";
		
		long newCategoryId=4;
		long newCategoriesSize=newCategoryId;
		
		CategoryDto dto=new CategoryDto();
		dto.setName(newCategoryName);
		
		categoryController.save(null, dto);
		
		List<CategoryDto> categories=categoryController.findAll();
		assertNotNull(categories);
		assertEquals(newCategoriesSize,categories.size());
		
		CategoryDto categorySearch=categories.stream().filter(item->item.getId().equals(newCategoryId)).findFirst().orElse(null);
		assertNotNull(categorySearch);
		assertEquals(newCategoryName,categorySearch.getName());
	}
	
	@Test
	public void modifyWithExistsIdShouldModifyCategory() {

	    assertNotNull(categoryController);

	    String newCategoryName = "Nueva Categoria";
	    long categoryId = 3;
	    long categoriesSize = 3;

	    CategoryDto dto = new CategoryDto();
	    dto.setName(newCategoryName);

	    categoryController.save(categoryId, dto);

	    List<CategoryDto> categories = categoryController.findAll();
	    assertNotNull(categories);
	    assertEquals(categoriesSize, categories.size());

	    CategoryDto categorySearch = categories.stream().filter(item -> item.getId().equals(categoryId)).findFirst().orElse(null);
	    assertNotNull(categorySearch);
	    assertEquals(newCategoryName, categorySearch.getName());

	}
	
	@Test
	public void modifyWithNotExistsIdShouldThrowException() {

	    assertNotNull(categoryController);

	    String newCategoryName = "Nueva Categoria";
	    long categoryId = 4;

	    CategoryDto dto = new CategoryDto();
	    dto.setName(newCategoryName);

	    assertThrows(NullPointerException.class, () -> categoryController.save(categoryId, dto));
	}
	
	@Test
	public void deleteWithExistsIdShouldDeleteCategory() {

	    assertNotNull(categoryController);

	    long newCategoriesSize = 2;
	    long deleteCategoryId = 2;

	    categoryController.detele(deleteCategoryId);

	    List<CategoryDto> categories = categoryController.findAll();

	    assertNotNull(categories);
	    assertEquals(newCategoriesSize, categories.size());

	}

	@Test
	public void deleteWithNotExistsIdShouldThrowException() {

	    assertNotNull(categoryController);

	    long deleteCategoryId = 4;

	    assertThrows(Exception.class, () -> categoryController.detele(deleteCategoryId));

	}




}
