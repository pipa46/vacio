package com.capgemini.ccsw.tutorial.autor.model;

import org.springframework.data.domain.Pageable;

public class AutorSearchDto
{

	private Pageable pageable;
	
	

	public Pageable getPageable() {
		return pageable;
	}

	public void setPageable(Pageable pageable)
	{
		this.pageable = pageable;
	}
	
	
}