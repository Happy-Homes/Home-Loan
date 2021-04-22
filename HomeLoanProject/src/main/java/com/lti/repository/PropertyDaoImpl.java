package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Property;


@Repository
public class PropertyDaoImpl implements PropertyDao{
	@PersistenceContext
	EntityManager em;
    
   @Override
    public Property findPropertyById(int propertyId){
    	return em.find(Property.class, propertyId);
    }

   @Transactional
	public Property updateProperty(Property property) {
		return em.merge(property);
		
	}
}
