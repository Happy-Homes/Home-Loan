package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Property;
import com.lti.repository.PropertyDao;
@Service
public class PropertyServiceImpl implements PropertyService {
	
	@Autowired
	PropertyDao propertyDao;

	@Override
	public Property updateProperty(Property property) {
		
		Property property2= propertyDao.updateProperty(property);
		return property2;
	}

	@Override
	public Property findPropertyById(int propertyId) {
		
		return propertyDao.findPropertyById(propertyId);
	}

}
