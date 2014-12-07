/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entity.Contact;
import com.supinfo.supsms.entity.Users;
import com.supinfo.supsms.service.ContactService;
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
@WebServlet(name = "IndexServlet", urlPatterns = {"/index", ""})
public class IndexServlet extends HttpServlet {
    
    @EJB
    private ContactService contactService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Users user = (Users) req.getSession().getAttribute("user");
        // Find contact by _user.id
        List<Contact> contactList = contactService.findContactByFilter(user);
        // Set contacts on view
        
        req.setAttribute("contact", contactList);
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
        contact.setUpdated(created);
        
        Users user = (Users) req.getSession().getAttribute("user");
        contact.setUsers(user);
        
        System.out.println(contact.getEmail());
        System.out.println(contact.getUpdated());
        
        contactService.addContact(contact);
        resp.sendRedirect(getServletContext().getContextPath());
    }
    
}
