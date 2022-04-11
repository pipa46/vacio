package com.capgemini.ccsw.tutorial.game.model;

import javax.persistence.*;

import com.capgemini.ccsw.tutorial.autor.model.Autor;
import com.capgemini.ccsw.tutorial.category.model.Category;



@Entity
@Table(name="Game")
public class Game
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private Long id;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="age",nullable=false)
	private String age;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable =false)
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="author_id",nullable =false)
	private Autor author;

	public Long getId() 
	{
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

	public Category getCategory()
	{
		return category;
	}

	public void setCategory(Category category)
	{
		this.category = category;
	}

	public Autor getAuthor()
	{
		return author;
	}

	public void setAuthor(Autor author)
	{
		this.author = author;
	}
	
	
	
	
}