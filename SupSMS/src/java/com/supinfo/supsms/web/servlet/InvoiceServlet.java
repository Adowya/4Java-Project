/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entity.Invoice;
import com.supinfo.supsms.entity.Users;
import com.supinfo.supsms.service.InvoiceService;
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
@WebServlet(name = "InvoiceServlet", urlPatterns = {"/invoice"})
public class InvoiceServlet  extends HttpServlet{
    
    @EJB
    private InvoiceService invoiceService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users) req.getSession().getAttribute("user");
        List<Invoice> invoiceList = invoiceService.findInvoiceByUserId(user);

        req.setAttribute("invoice", invoiceList);
        req.getRequestDispatcher("/jsp/invoice.jsp").forward(req, resp);
    }
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
    }
    
}
