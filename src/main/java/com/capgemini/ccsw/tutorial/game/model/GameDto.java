package com.capgemini.ccsw.tutorial.game.model;
import com.capgemini.ccsw.tutorial.autor.model.AutorDto;
import com.capgemini.ccsw.tutorial.category.model.CategoryDto;

public class GameDto 
{
	private Long id;
	
	private String title;
	
	private String age;
	
	private CategoryDto category;
	
	private AutorDto author;

	public Long getId() {
		return id;
	}

	public void setId(Long id) 
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public String getAge()
	{
		return age;
	}

	public void setAge(String age) 
	{
		this.age = age;
	}

	public CategoryDto getCategory()
	{
		return this.category;
	}

	public void setCategory(CategoryDto category)
	{
		this.category = category;
	}

	public AutorDto getAuthor()
	{
		return author;
	}

	public void setAuthor(AutorDto author)
	{
		this.author = author;
	}
	
	public String toString()
	{
		return "Juego" +id+ "con titulo " +title+ "category " +category+ "y autor " +author;
	}

}
