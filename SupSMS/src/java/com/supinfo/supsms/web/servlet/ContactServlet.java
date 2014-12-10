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
@WebServlet(name = "ContactServlet", urlPatterns = {"/contact"})
public class ContactServlet extends HttpServlet {
    
    @EJB
    private ContactService contactService;
    
    @EJB
    private SmsService smsService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_param = req.getParameter("id");
        String delete_param = req.getParameter("delete");
        
        if(id_param != null && !id_param.isEmpty()){
            Long id = null;
            if(!id_param.trim().isEmpty()) {
                try {
                    id = new Long(id_param);
                } catch (NumberFormatException e) {
                    
                }
            }
            if(id != null){
                Contact contact = contactService.findContactById(id);
                req.setAttribute("contact", contact);
                req.getRequestDispatcher("/jsp/contact.jsp").forward(req, resp);
            }
        }
        
        if(delete_param != null && !delete_param.isEmpty()){
            Long id_delete = null;
            if(!delete_param.trim().isEmpty()) {
                try {
                    id_delete = new Long(delete_param);
                } catch (NumberFormatException e) {
                    
                }
            }
            if(id_delete != null){
//                If a contact is deleted, his conversation is deleted.
                Contact contact = contactService.findContactById(id_delete);
                
                if(contact != null){
                    Users user = (Users) req.getSession().getAttribute("user");
                    List<Sms> smsList = smsService.findSmsByUserandContactId(user, contact);
                    
                    for(Sms sms : smsList) {
                        smsService.removeSms(sms.getId());
                    }
                    
                    contactService.removeContact(contact.getId());
                }
                resp.sendRedirect(req.getContextPath());
            }
            
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("contact_id");
        if(param!=null && !param.isEmpty()){
            System.out.print(param);
            Long contactId = Long.valueOf(param);
            Contact contact = contactService.findContactById(contactId);
            
            contact.setFirst_name(req.getParameter("first_name"));
            contact.setLast_name(req.getParameter("last_name"));
            contact.setEmail(req.getParameter("email"));
            contact.setPhone(req.getParameter("phone"));
            
            String user_zip = req.getParameter("zip");
            Long user_zip_long = Long.valueOf(user_zip);
            contact.setZip(user_zip_long);
            
            Date updated = new Date();
            contact.setUpdated(updated);
            
            contactService.updateContact(contact);
            
            resp.sendRedirect(req.getContextPath() + "/contact?id="+contactId);
        }else {
            System.out.print("param == null");
        }
    }
    
}
