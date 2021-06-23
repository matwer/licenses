package com.shad.licenses.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shad.licenses.models.License;


public interface LicenseRepo extends CrudRepository<License, Long> {
	/**
	 * return all Licenses 
	 */
	List<License> findAll();
	
}
