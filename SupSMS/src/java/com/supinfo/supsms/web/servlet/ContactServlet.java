/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.service.ContactService;
import java.io.IOException;
import java.util.Date;
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
@WebServlet(name = "ContactServlet", urlPatterns = {"/index"})
public class ContactServlet extends HttpServlet {
    
    @EJB
    private ContactService contactService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Contact contact = new Contact();
        
        contact.setFirst_name(req.getParameter("first_name"));
        contact.setLast_name(req.getParameter("last_name"));
        contact.setEmail(req.getParameter("email"));
        
        Long phone = Long.parseLong(req.getParameter("phone"));
        contact.setPhone(phone);
        Long zip = Long.parseLong(req.getParameter("zip"));
        contact.setZip(zip);
        
        Date created = new Date();
        contact.setCreated(created);
        contact.setUpdate(created);
        
        contactService.addContact(contact);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
    
    
    
}
