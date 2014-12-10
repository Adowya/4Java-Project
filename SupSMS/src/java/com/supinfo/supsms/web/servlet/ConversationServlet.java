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
        String error = req.getParameter("error");
        String param = req.getParameter("id");
        
        Users user = (Users) req.getSession().getAttribute("user");
        List<Contact> contactList = contactService.findContactByFilter(user);
        
        req.setAttribute("contact", contactList);
        req.setAttribute("contactId", param);
        
        if(error == null){
            
            if(param!=null && !param.isEmpty()){
                Long contactId = Long.valueOf(param);
                Contact contact = contactService.findContactById(contactId);
                List<Sms> smsList = smsService.findSmsByUserandContactId(user, contact);
                req.setAttribute("sms", smsList);
                
                req.getRequestDispatcher("/jsp/conversation.jsp").forward(req, resp);
            }else {
                resp.sendRedirect("./conversation?error="+true);
            }
            
        }else {
            req.setAttribute("errorMsg", "You don't have select contact");
            req.getRequestDispatcher("/jsp/conversation.jsp").forward(req, resp);
        }
        
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users) req.getSession().getAttribute("user");
        String param = req.getParameter("param");
        
        if(param!=null && !param.isEmpty() && user.getFirst_name() != null){
            Long contactId = Long.valueOf(param);
            Contact contact = contactService.findContactById(contactId);
            
            if(req.getParameter("message") != null){
                Sms sms = new Sms();
                sms.setText(req.getParameter("message"));
                sms.setContact(contact);
                sms.setUsers(user);
                
                Date created = new Date();
                sms.setCreated(created);
                
                smsService.addSms(sms);
                resp.sendRedirect("./conversation?id=" + contactId);
            }else {
                System.out.print("message == null");
            }
            
        }else {
            resp.sendRedirect("./conversation?error="+true);
//            resp.sendRedirect(getServletContext().getContextPath());
        }
//        resp.sendRedirect(getServletContext().getContextPath());
//                resp.sendRedirect("../conversation?id=" + contactId);
//        req.getRequestDispatcher("/jsp/conversation.jsp").forward(req, resp);
    }
    
    
    
}
