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
import com.supinfo.supsms.service.CustomerService;
import com.supinfo.supsms.service.SmsService;
import com.supinfo.supsms.service.UsersService;
import java.io.IOException;
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
@WebServlet(name = "ManageUserServlet", urlPatterns = {"/manage_user"})
public class ManageUserServlet extends HttpServlet{
    
    @EJB
    private UsersService usersService;
    
    @EJB
    private ContactService contactService;
    
    @EJB
    private SmsService smsService;
    
    @EJB
    private CustomerService customerService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String delete = req.getParameter("delete");
//        Users user = (Users) req.getSession().getAttribute("user");
        
        if(delete!=null && !delete.isEmpty()){
            if(req.getSession().getAttribute("admin") != null){
                Long usertId = Long.valueOf(delete);
                Users users = usersService.findUsersById(usertId);
                
                if(users != null){
                    // Delete SMS of User ID
                    List<Sms> smsList = smsService.findSmsByUserId(users);
                    for(Sms sms : smsList) {
                        smsService.removeSms(sms.getId());
                    }
                    // Delete Contact of User ID
                    List<Contact> contactList = contactService.findContactByFilter(users);
                    for(Contact contact : contactList){
                        contactService.removeContact(contact.getId());
                    }
                    
                    // Delete User for ID
                    usersService.removeUsers(users.getId());
                    resp.sendRedirect("./manage_user");
                }else {
                    resp.sendRedirect(getServletContext().getContextPath());
                }
            }else {
                resp.sendRedirect(getServletContext().getContextPath());
            }
        }
        
        List<Users> usersList = usersService.getAllUsers();
        req.setAttribute("users", usersList);
        req.getRequestDispatcher("/jsp/admin/manage_user.jsp").forward(req, resp);
    }
    
    
}
