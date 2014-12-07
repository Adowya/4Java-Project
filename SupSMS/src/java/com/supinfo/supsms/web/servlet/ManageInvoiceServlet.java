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
@WebServlet(name = "ManageInvoiceServlet", urlPatterns = {"/manage_invoice"})
public class ManageInvoiceServlet extends HttpServlet{
    
    @EJB
    private InvoiceService invoiceService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Invoice> invoiceList = invoiceService.getAllInvoices();
        req.setAttribute("invoice", invoiceList);
        req.getRequestDispatcher("/jsp/admin/manage_invoice.jsp").forward(req, resp);
    }
    
}
