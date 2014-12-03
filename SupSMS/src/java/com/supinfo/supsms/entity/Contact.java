/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Clement
 */
@Entity
public class Contact implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Long phone;
    private String last_name;
    private String first_name;
    private Long zip;
    private String email;
    
    private Set<Customer> customer;
    private Sms sms;
    
    private Date update;
    private Date created;
    
    public Contact(){
        super();
    }
    
}
