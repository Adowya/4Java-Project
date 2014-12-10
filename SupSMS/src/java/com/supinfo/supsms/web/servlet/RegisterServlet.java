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
import java.text.DecimalFormat;
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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    
    @EJB
    private UsersService usersService;
    
    @EJB
    private InvoiceService invoiceService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Users users = new Users();
        users.setEmail(req.getParameter("email"));
        users.setFirst_name(req.getParameter("first_name"));
        users.setLast_name(req.getParameter("last_name"));
        users.setPassword(req.getParameter("password"));
        
        users.setPhone(req.getParameter("phone"));
        
        Long card = Long.parseLong(req.getParameter("card"));
        users.setCard(card);
        Long zip = Long.parseLong(req.getParameter("zip"));
        users.setZip(zip);
        
        Date created = new Date();
        users.setCreated(created);
        
        //For Admin
        //users.setRole_member(2;
        //For User
        users.setRole_member(1);
        usersService.addUsers(users);
        
        // First Invoice
        Invoice invoice = new Invoice();
        long price = 10;
        invoice.setPrice(price);
        invoice.setUsers(users);
        invoice.setCreated(created);
        invoiceService.addInvoice(invoice);
        
        resp.sendRedirect(req.getContextPath() + "/login");
        
    }
    
    
}
