/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.service;

import com.supinfo.supsms.dao.ContactDao;
import com.supinfo.supsms.entity.Contact;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Clement
 */
@Stateless
public class ContactService {
    
    @EJB
    private ContactDao contactDao;
    
    public Contact addContact(Contact contact){
        return contactDao.addContact(contact);
    }
    
    public List<Contact> getAllContact(){
        return contactDao.getAllContact();
    }
    
    public Contact findContactById(Long ContactId){
        return contactDao.findContactById(ContactId);
    }
    
    public Contact updateContact(Contact contact){
        return contactDao.updateContact(contact);
    }
    
    public void removeContact(Contact findContactById){
        contactDao.removeContact(findContactById);
    }
    
    public List<Contact> findContactByFilter(Date update){
        return contactDao.findContactByFilter(update);
    }
    
}
