/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.service;

import com.supinfo.supsms.dao.SmsDao;
import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Sms;
import com.supinfo.supsms.entity.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Clement
 */
@Stateless
public class SmsService {
    
    @EJB
    private SmsDao smsDao;
    
    
    public Sms addSms(Sms sms) {
        return smsDao.addSms(sms);
    }
    
    public List<Sms> getAllSmss() {
        return smsDao.getAllSms();
    }
    
    public void removeSms(Long smsId) {
        smsDao.removeSms(findSmsById(smsId));
    }
    
    public Sms findSmsById(Long smsId) {
        return smsDao.findSmsById(smsId);
    }
    
    public List<Sms> findSmsByUserId(Users users) {
        return smsDao.findSmsByUserId(users);
    }
    
    public List<Sms> findSmsByUserandCustomerId(Users users, Contact contact){
        return smsDao.findSmsByUserandCustomerId(users, contact);
    }
    
    
}
