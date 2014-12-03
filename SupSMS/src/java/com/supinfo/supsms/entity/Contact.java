/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Clement
 */
@Entity
@Table(name = "contact")
@XmlRootElement
public class Contact extends Customer implements Serializable {
    
    private Date update;
        
    public Contact(){
        super();
    }
    
}
