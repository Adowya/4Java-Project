/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Sms;
import com.supinfo.supsms.entity.Users;
import com.supinfo.supsms.service.ContactService;
import com.supinfo.supsms.service.SmsService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Clement
 */
@WebServlet(name = "ConversationServlet", urlPatterns = {"/conversation"})
public class ConversationServlet extends HttpServlet {
    
    @EJB
    private ContactService contactService;
    
    @EJB
    private SmsService smsService;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("id");
        Users user = (Users) req.getSession().getAttribute("user");
        List<Contact> contactList = contactService.findContactByFilter(user);
        
        if(param!=null && !param.isEmpty()){
            Long contactId = Long.valueOf(param);
            Contact contact = contactService.findContactById(contactId);
            List<Sms> smsList = smsService.findSmsByUserandContactId(user, contact);
            req.setAttribute("sms", smsList);
        }
        
        req.setAttribute("contact", contactList);
        req.getRequestDispatcher("/jsp/conversation.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users) req.getSession().getAttribute("user");
        String param = req.getParameter("id");
        if(param!=null && !param.isEmpty()){
            System.out.print("param != null");
            
            Long contactId = Long.valueOf(param);
            Contact contact = contactService.findContactById(contactId);
            
            Sms sms = new Sms();
            sms.setText(req.getParameter("message"));
            sms.setContact(contact);
            sms.setUsers(user);
            
            Date created = new Date();
            sms.setCreated(created);
            
            smsService.addSms(sms);
        }else {
            System.out.print("param == null");
        }
        
        resp.sendRedirect(getServletContext().getContextPath());
//        req.getRequestDispatcher("/jsp/conversation.jsp").forward(req, resp);
    }
    
    
    
}
