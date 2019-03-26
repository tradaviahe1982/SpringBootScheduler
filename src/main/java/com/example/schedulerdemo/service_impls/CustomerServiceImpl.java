package com.example.schedulerdemo.service_impls;

import org.springframework.stereotype.Service;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;
import com.example.schedulerdemo.model.CustomerCustom;
import com.example.schedulerdemo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@PersistenceContext
	EntityManager em;
	@Override
	public void InsertCustomer() 
	{
		// TODO Auto-generated method stub
		StoredProcedureQuery sp = em.createNamedStoredProcedureQuery("insertCustomer");
        sp.execute();
        
	}

}
