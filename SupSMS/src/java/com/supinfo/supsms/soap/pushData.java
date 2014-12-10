/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.soap;

import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Sms;
import com.supinfo.supsms.service.ContactService;
import com.supinfo.supsms.service.SmsService;
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
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "all")
    public boolean sync(Sms sms, Contact contact) {
        
        smsService.addSms(sms);
        contactService.addContact(contact);
        return true;
    }
}
