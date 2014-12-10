/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao.jpa;

import com.supinfo.supsms.dao.ContactDao;
import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Users;
import java.util.ArrayList;
import java.util.Date;
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
public class JpaContactDao implements ContactDao{
    
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Contact addContact(Contact contact) {
        em.persist(contact);
        return contact;
    }
    
    @Override
    public List<Contact> getAllContact() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> query = cb.createQuery(Contact.class);
        return em.createQuery(query).getResultList();
    }
    
    @Override
    public Contact findContactById(Long ContactId) {
        return em.find(Contact.class, ContactId);
    }
    
    @Override
    public Contact updateContact(Contact contact) {
        return em.merge(contact);
    }
    
    @Override
    public void removeContact(Contact contact) {
        em.remove(contact);
    }
    
    @Override
    public List<Contact> findContactByFilter(Users users) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Contact> query = cb.createQuery(Contact.class);
        Root<Contact> contact = query.from(Contact.class);
        
        List<Predicate> predicates = new ArrayList<>();
        if(users != null) {
            predicates.add(
                    cb.equal(contact.get("_users"), users)
            );
        }
        
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return em.createQuery(query).getResultList();
    }
    
}
