/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao.jpa;

import com.supinfo.supsms.dao.CustomerDao;
import com.supinfo.supsms.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Clement
 */
@Stateless
public class JpaCustomerDao implements CustomerDao {
    
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Customer addCustomer(Customer Customer) {
        em.persist(Customer);
        return Customer;
    }
    
    @Override
    public List<Customer> getAllCustomers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        return em.createQuery(query).getResultList();
    }
    
    @Override
    public Customer findCustomerById(Long CustomerId) {
        return em.find(Customer.class, CustomerId);
    }
    
    @Override
    public void removeCustomer(Customer Customer) {
        em.remove(Customer);
    }
    
    @Override
    public List<Customer> findCustomerByFilter(String CustomerPhoneLong) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Customer> query = cb.createQuery(Customer.class);
        Root<Customer> customer = query.from(Customer.class);
        
        List<Predicate> predicates = new ArrayList<>();
        if(CustomerPhoneLong != null) {
            predicates.add(
                    cb.equal(customer.get("phone"), CustomerPhoneLong)
            );
        }
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return em.createQuery(query).getResultList();
    }
    
}
