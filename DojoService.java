package com.caroline.dojosninjas.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caroline.dojosninjas.models.Dojo;
import com.caroline.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepository; //injecting the dojoRepository
	
	
	// this method allows the service to create a new dojo and send to repository to save 
	public Dojo createDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
			
	}

	public List<Dojo> findAllDojo() {
		return dojoRepository.findAll();
	}
	
	 
	public Dojo findDojoById(Long id) {
		return dojoRepository.findById(id).orElse(null);
	}


}
