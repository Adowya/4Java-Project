/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao.jpa;

import com.supinfo.supsms.dao.SmsDao;
import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Sms;
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
public class JpaSmsDao implements SmsDao {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Sms addSms(Sms Sms) {
        em.persist(Sms);
        return Sms;
    }
    
    @Override
    public List<Sms> getAllSms() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sms> query = cb.createQuery(Sms.class);
        return em.createQuery(query).getResultList();
    }
    
    @Override
    public Sms findSmsById(Long SmsId) {
        return em.find(Sms.class, SmsId);
    }
    
    @Override
    public void removeSms(Sms Sms) {
        em.remove(Sms);
    }
    
    @Override
    public List<Sms> findSmsByUserId(Users users) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sms> query = cb.createQuery(Sms.class);
        Root<Sms> sms = query.from(Sms.class);
        
        List<Predicate> predicates = new ArrayList<>();
        if(users != null) {
            predicates.add(
                    cb.equal(sms.get("user"), users)
            );
        }
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        
        return em.createQuery(query).getResultList();
    }
    
    @Override
    public List<Sms> findSmsByUserandCustomerId(Users users, Contact contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
