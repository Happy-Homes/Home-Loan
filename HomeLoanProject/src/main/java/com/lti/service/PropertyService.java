package com.lti.service;

import com.lti.entity.IncomeDetails;
import com.lti.entity.Property;

public interface PropertyService {
	Property updateProperty(Property property);
	Property findPropertyById(int propertyId);
}
