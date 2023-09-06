package com.caroline.dojosninjas.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caroline.dojosninjas.models.Ninja;
import com.caroline.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepository; //injecting the ninjaRepository

	
	
	// this method allows the service to create a new ninja and send to repository to save 
	public Ninja createNinja(Ninja ninjas) {
		return ninjaRepository.save(ninjas);
			
	}
		
	public List<Ninja> findAllNinja() {
		return ninjaRepository.findAll();
	}
		   
	public Ninja create(Ninja ninja) {
		return ninjaRepository.save(ninja);
	}
		    
		    
	public Ninja find(Long id) {
		Optional<Ninja> result = ninjaRepository.findById(id);
		 
		if(result.isPresent()) {
		  
			return result.get();
		} 
		else {
		    return null;
		}
	}
}
