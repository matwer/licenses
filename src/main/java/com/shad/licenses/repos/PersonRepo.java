package com.shad.licenses.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shad.licenses.models.Person;


public interface PersonRepo extends CrudRepository<Person,Long>{

	/**
	 * return all Persons 
	 */
	List<Person> findAll();
	
	List<Person> findByLicenseIsNull();
}