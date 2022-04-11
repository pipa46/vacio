package com.capgemini.ccsw.tutorial.clientes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ccsw.tutorial.clientes.model.Clientes;
import com.capgemini.ccsw.tutorial.clientes.model.ClientesDto;

@Service
public class ClientesServicioImpl implements ClientesService
{
  @Autowired
  ClientesRepository cr;
  @Autowired
  private ClientesController c_c;
  @Override
  public List <Clientes> findAll()
  {
	  return (List<Clientes>)this.cr.findAll();
  }
  
  
  @Override
  public void guardar(Long id,ClientesDto dto)
  {
	   List<ClientesDto>clientes=c_c.findAll();
	  Clientes clientess=null;
	  
	  
	 

      if (id==null) 
    	  
         clientess=new Clientes();
      
      else 
        clientess=this.get(id);
      
     
	
      clientess.setNombre(dto.getNombre());
      
      
      //BeanUtils.copyProperties(dto, clientess,"id");
	
      
      if(!clientes.stream().anyMatch(cliente->cliente.getNombre().equals(dto.getNombre())))
         this.cr.save(clientess);
      
     
      
      
  }
  @Override
  public void borrar(Long id)
  {
	  this.cr.deleteById(id);
  }
  @Override
  public  Clientes get(Long id)
  {
	  return this.cr.findById(id).orElse(null);
  }
  

}