package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.lti.entity.EmiDetails;

public class EmiDaoImpl {
	EntityManager em;
    EntityManagerFactory emf;
    EntityTransaction tx;
    
    public EmiDaoImpl(){
    	emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
        
        tx = em.getTransaction();
    }
public EmiDetails addOrUpdateEmi(EmiDetails emiDetails){
        
        tx.begin();
        
        em.merge(emiDetails);
        
        tx.commit();
        
        return emiDetails;
    }

}
