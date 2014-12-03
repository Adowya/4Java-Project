/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Clement
 */
@Entity
public class User extends Customer {
    
    private Long card;
    private Boolean role;
    
    
    @ManyToOne @JoinColumn
    private Invoice invoice;
    @ManyToOne @JoinColumn
    private Sms sms;
}
