/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.service;

import com.supinfo.supsms.dao.CustomerDao;
import com.supinfo.supsms.entity.Customer;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Clement
 */
@Stateless
public class CustomerService {
    
    @EJB
    private CustomerDao customerDao;
    
    public Customer addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }
    
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
    
    public void removeCustomer(Long customerId) {
        customerDao.removeCustomer(findCustomerById(customerId));
    }
    
    public Customer findCustomerById(Long customerId) {
        return customerDao.findCustomerById(customerId);
    }
    
    public List<Customer>  findCustomerByFilter(Long CustomerPhoneLong) {
        return customerDao.findCustomerByFilter(CustomerPhoneLong);
    }
    
}
