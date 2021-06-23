/**
 * @author Matthew Werner
 *
 */
 
package com.shad.licenses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shad.licenses.models.Person;
import com.shad.licenses.repos.PersonRepo;


@Service
public class PersonService {
	// instantiate a new repository
	private final PersonRepo personRepo;
	
	// set up a constructor for the service
	public PersonService(PersonRepo personRepo) {
		this.personRepo = personRepo;
	}
	
	/**
	 * returns all entries from the repository
	 **/
    public List<Person> allEntries() {
        return personRepo.findAll();
    }
    
	/**
	 * adds a new entry to the repository
	 **/
    public Person addEntry(Person p) {
        return personRepo.save(p);
    }
    
	/**
	 * finds an existing entry if it exists
	 **/
    public Person findEntry(Long id) {
        Optional<Person> opt = personRepo.findById(id);
        
        if(opt.isPresent()) {
            return opt.get();
        } 

        return null;
    }
    
	/**
	 * updates an entry if it exists
	 **/
    public Person updateEntry(Person p) {
    	Optional<Person> opt = Optional.of(p); 
    	
    	// if the entry is present, update it 
    	if(opt.isPresent()) {
    		return personRepo.save(p);
    	}
    	
    	return null;
    }
    
    
	/**
	 * updates an entry if it exists
	 **/
    public void deleteEntry(Long id) {
    	Optional<Person> opt = personRepo.findById(id);
    	
    	// check to see if the entry exists
        if(opt.isPresent()) {
        	personRepo.deleteById(id);
        }
    }
    
	/**
	 * updates an entry if it exists
	 **/
    public List<Person> findPeopleWithNoLicense() {
        	return personRepo.findByLicenseIsNull();
    }

}
