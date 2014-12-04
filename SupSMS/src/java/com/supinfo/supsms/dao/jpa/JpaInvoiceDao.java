/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao.jpa;

import com.supinfo.supsms.dao.InvoiceDao;
import com.supinfo.supsms.entity.Invoice;
import com.supinfo.supsms.entity.Users;
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
public class JpaInvoiceDao implements InvoiceDao{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Invoice addInvoice(Invoice Invoice) {
        em.persist(Invoice);
        return Invoice;
    }
    
    @Override
    public List<Invoice> getAllInvoice() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Invoice> query = cb.createQuery(Invoice.class);
        return em.createQuery(query).getResultList();
    }
    
    @Override
    public Invoice findInvoiceById(Long InvoiceId) {
        return em.find(Invoice.class, InvoiceId);
    }
    
    @Override
    public Invoice updateInvoice(Invoice Invoice) {
        return em.merge(Invoice);
    }
    
    @Override
    public void removeInvoice(Invoice Invoice) {
        em.remove(Invoice);
    }
    
    @Override
    public List<Invoice> findInvoiceByUserId(Users user) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Invoice> query = cb.createQuery(Invoice.class);
        Root<Invoice> invoice = query.from(Invoice.class);
        
        List<Predicate> predicates = new ArrayList<>();
        if(user != null) {
            predicates.add(
                    cb.equal(invoice.get("_users"), user)
            );
        }
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        return em.createQuery(query).getResultList();
    }
    
}
