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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Clement
 */
@Entity
@Table(name = "contact")
@XmlRootElement
public class Contact extends Customer implements Serializable {
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date update;
    
    public Contact(){
        super();
    }
    
    /**
     * @return the update
     */
    public Date getUpdate() {
        return update;
    }
    
    /**
     * @param update the update to set
     */
    public void setUpdate(Date update) {
        this.update = update;
    }
    
    
    
}
