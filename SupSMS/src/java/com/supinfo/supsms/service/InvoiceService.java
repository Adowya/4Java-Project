/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.service;

import com.supinfo.supsms.dao.InvoiceDao;
import com.supinfo.supsms.entity.Invoice;
import com.supinfo.supsms.entity.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Clement
 */
@Stateless
public class InvoiceService {
    
    @EJB
    private InvoiceDao invoiceDao;
    
    
    public Invoice addInvoice(Invoice invoice) {
        return invoiceDao.addInvoice(invoice);
    }
    
    public List<Invoice> getAllInvoices() {
        return invoiceDao.getAllInvoice();
    }
    
    public void removeInvoice(Long invoiceId) {
        invoiceDao.removeInvoice(findInvoiceById(invoiceId));
    }
    
    public Invoice findInvoiceById(Long invoiceId) {
        return invoiceDao.findInvoiceById(invoiceId);
    }
    
    public Invoice findInvoiceByUserId(Users users) {
        return invoiceDao.findInvoiceByUserId(users);
    }
    
}
