/**
 * @author Matthew Werner
 *
 */

package com.shad.licenses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shad.licenses.models.License;
import com.shad.licenses.repos.LicenseRepo;

@Service
public class LicenseService {
	// instantiate a new repository
	private final LicenseRepo licenseRepo;
	
	// set up a constructor for the service
	public LicenseService(LicenseRepo licenseRepo) {
		this.licenseRepo = licenseRepo;
	}
	
	/**
	 * returns all entries from the repository
	 **/
    public List<License> allEntries() {
        return licenseRepo.findAll();
    }
    
	/**
	 * adds a new entry to the repository
	 **/
    public License addEntry(License l) {
    	License license = licenseRepo.save(l);
    	String s = license.getId().toString();
    	for (int i = 0; s.length() < 6; i++) {
    		s = "0" + s;
    	}
        
    	license.setNumber(s);
    	return licenseRepo.save(license);
    }
    
	/**
	 * finds an existing entry if it exists
	 **/
    public License findEntry(Long id) {
        Optional<License> opt = licenseRepo.findById(id);
        
        if(opt.isPresent()) {
            return opt.get();
        } 

        return null;
    }
    
	/**
	 * updates an entry if it exists
	 **/
    public License updateEntry(License l) {
    	Optional<License> opt = Optional.of(l); 
    	
    	// if the entry is present, update it 
    	if(opt.isPresent()) {
    		return licenseRepo.save(l);
    	}
    	
    	return null;
    }
    
    
	/**
	 * updates an entry if it exists
	 **/
    public void deleteEntry(Long id) {
    	Optional<License> opt = licenseRepo.findById(id);
    	
    	// check to see if the entry exists
        if(opt.isPresent()) {
        	licenseRepo.deleteById(id);
        }
    }
}
