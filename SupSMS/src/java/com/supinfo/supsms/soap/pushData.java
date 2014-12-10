/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.soap;

import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Sms;
import com.supinfo.supsms.entity.Users;
import com.supinfo.supsms.service.ContactService;
import com.supinfo.supsms.service.SmsService;
import com.supinfo.supsms.service.UsersService;
import java.util.Date;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author valentin
 */
@WebService(serviceName = "pushData")
public class pushData {
    
    @EJB
    private ContactService contactService;
    
    @EJB
    private SmsService smsService;
    
    @EJB
    private UsersService usersService;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "all")
    public boolean sync(String text, Long contactId, Long userId, String first_name
    , String last_name, String email, String phone, Long zip) {
        
        Users users = usersService.findUsersById(userId);
        Contact contact = contactService.findContactById(contactId);
        
        Sms sms = new Sms();
        sms.setText(text);
        sms.setContact(contact);
        sms.setUsers(users);
        Date created = new Date();
        sms.setCreated(created);
        smsService.addSms(sms);
        
        contact.setFirst_name(first_name);
        contact.setLast_name(last_name);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setZip(zip);
        Date updated = new Date();
        contact.setUpdated(updated);
        contactService.addContact(contact);
        return true;
    }
}
