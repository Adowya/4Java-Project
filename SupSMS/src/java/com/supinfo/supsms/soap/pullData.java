/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supsms.soap;

import com.mchange.v1.util.ListUtils;
import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Sms;
import com.supinfo.supsms.service.ContactService;
import com.supinfo.supsms.service.SmsService;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author valentin
 */
@WebService(serviceName = "pullData")
public class pullData {
    
    @EJB
    private SmsService smsService;
    
    @EJB
    private ContactService contactService;
    
    @WebMethod(operationName="syncSms")
    public List<Sms> getAllSms() {
        return smsService.getAllSmss();
    }
    
    @WebMethod(operationName="syncContact")
    public List<Contact> getAllContact() {
        return contactService.getAllContact();
    }
}