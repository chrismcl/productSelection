package com.mcl.service;

//import com.mcl.entity.Location;
import com.mcl.exceptions.FailureException;
//import com.mcl.respository.LocationRepository;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerLocationService {
    private static final Logger LOGGER = LogManager.getLogger(CustomerLocationService.class);
    //TODO hardcoded to london until this is implemented
	private String location = "London";

	public String findLocationIdByCustomerId(String customerId) throws FailureException {
		//@Autowired
        //LocationRepository locationRepository;
        
		if (StringUtils.isBlank(customerId)) {
            throw new FailureException("There was a problem retrieving the customer information");
		}

		return location;
	}
}