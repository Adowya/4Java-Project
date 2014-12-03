/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao;

import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Sms;
import com.supinfo.supsms.entity.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Clement
 */
@Local

public interface SmsDao {
    
    Sms addSms(Sms Sms);
    
    List<Sms> getAllSms();
    
    public Sms findSmsById(Long SmsId);
    
    public void removeSms(Sms findSmsById);
    
    public List<Sms> findSmsByUserId(Users users);
    
    public List<Sms> findSmsByUserandCustomerId(Users users, Contact contact);  
    
}
