package com.capgemini.ccsw.tutorial.category.model;

import javax.persistence.*;


@Entity
@Table(name="Category")
public class Category
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false)
	private Long id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	public Long getId()
	{
		return this.id;
	}
	
	public void setId(Long id)
	{
		this.id=id;
	}
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	

}
