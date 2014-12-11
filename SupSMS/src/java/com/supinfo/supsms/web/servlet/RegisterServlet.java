/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entity.Invoice;
import com.supinfo.supsms.entity.Users;
import com.supinfo.supsms.service.CustomerService;
import com.supinfo.supsms.service.InvoiceService;
import com.supinfo.supsms.service.UsersService;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    
    @EJB
    private UsersService usersService;
    
    @EJB
    private InvoiceService invoiceService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String error = req.getParameter("error");
        if(error != null){
            req.setAttribute("errorMsg", "Phone number already exist !");
        }
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Users users = new Users();
        if(usersService.findUsersByPhone(req.getParameter("phone")) == null){
            users.setEmail(req.getParameter("email"));
            users.setFirst_name(req.getParameter("first_name"));
            users.setLast_name(req.getParameter("last_name"));
            
            // Sha256 Password
            try {
                users.setSalt();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            String password = Users.get_SHA_256_SecurePassword(req.getParameter("password"),users.getSalt());
            users.setPassword(password);
            
            users.setPhone(req.getParameter("phone"));
            Long card = Long.parseLong(req.getParameter("card"));
            users.setCard(card);
            Long zip = Long.parseLong(req.getParameter("zip"));
            users.setZip(zip);
            
            Date created = new Date();
            users.setCreated(created);
            
            if(usersService.getAllUsers().size() < 1 ) {
                // Set Admin role if first user
                users.setRole_member(2);
            }else {
                //For User
                users.setRole_member(1);
            }
            usersService.addUsers(users);
            
            // Create Invoice
            Invoice invoice = new Invoice();
            long price = 10;
            invoice.setPrice(price);
            invoice.setUsers(users);
            invoice.setCreated(created);
            invoiceService.addInvoice(invoice);
            
            resp.sendRedirect(req.getContextPath() + "/login");
            
        }else {
            resp.sendRedirect(req.getContextPath() + "/register?error="+true);
        }
        
    }
    
    
}
