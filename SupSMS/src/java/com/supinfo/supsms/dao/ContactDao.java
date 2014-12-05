/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.dao;

import com.supinfo.supsms.entity.Contact;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Clement
 */
public interface ContactDao {
    
        
    Contact addContact(Contact contact);
    
    List<Contact> getAllContact();
    
    public Contact findContactById(Long ContactId);
    
    Contact updateContact(Contact contact);
    
    public void removeContact(Contact findContactById);
    
    public List<Contact> findContactByFilter(Date update);
    
}
