/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao;

import com.supinfo.supsms.entity.Invoice;
import com.supinfo.supsms.entity.Sms;
import com.supinfo.supsms.entity.Users;
import java.util.List;

/**
 *
 * @author Clement
 */
public interface InvoiceDao {
    
    Invoice addInvoice(Invoice Invoice);
    
    List<Invoice> getAllInvoice();
    
    public Invoice findInvoiceById(Long InvoiceId);
    
    public void removeInvoice(Invoice findInvoiceById);
    
    public Invoice findInvoiceByUserId(Users userId);
    
}
