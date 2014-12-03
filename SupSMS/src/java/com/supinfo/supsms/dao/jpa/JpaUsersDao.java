/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao.jpa;

import com.supinfo.supsms.dao.UsersDao;
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
public class JpaUsersDao implements UsersDao {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Users addUsers(Users Users) {
        em.persist(Users);
        return Users;
    }
    
    @Override
    public List<Users> getAllUsers() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> query = cb.createQuery(Users.class);
        return em.createQuery(query).getResultList();
    }
    
    @Override
    public Users findUsersById(Long UsersId) {
        return em.find(Users.class, UsersId);
    }
    
    @Override
    public void removeUsers(Users Users) {
        em.remove(Users);
    }
    
    @Override
    public List<Users> findUsersByFilter(Long phone) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Users> query = cb.createQuery(Users.class);
        Root<Users> users = query.from(Users.class);
        
        List<Predicate> predicates = new ArrayList<>();
        if(phone != null) {
            predicates.add(
                    cb.equal(users.get("phone"), phone)
            );
        }
        query.where(predicates.toArray(new Predicate[predicates.size()]));
        return em.createQuery(query).getResultList();
    }
    
    
}
