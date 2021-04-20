package com.lti.repository;

import com.lti.entity.Property;

public interface PropertyDao {
	Property updateProperty(Property property);
	Property findPropertyById(int propertyId);

}
