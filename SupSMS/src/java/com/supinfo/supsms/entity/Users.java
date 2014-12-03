/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Clement
 */
@Entity
@Table(name = "users")
@XmlRootElement
public class Users extends Customer {
    
    private Long card;
    private Boolean role_member;
    

}
