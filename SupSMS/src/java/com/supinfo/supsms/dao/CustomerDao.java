/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao;

import com.supinfo.supsms.entity.Customer;
import java.util.List;

/**
 *
 * @author Clement
 */
public interface CustomerDao {
    
    Customer addCustomer(Customer Customer);
    
    List<Customer> getAllCustomers();

    public Customer findCustomerById(Long CustomerId);

    public void removeCustomer(Customer findCustomerById);
    
    public List<Customer> findCustomerByFilter(String CustomerPhoneLong);
    
}
