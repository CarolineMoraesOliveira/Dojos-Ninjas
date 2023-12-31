package com.caroline.dojosninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caroline.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long>{

	List <Ninja> findAll();

	
}
