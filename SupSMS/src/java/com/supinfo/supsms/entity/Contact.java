/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    private Date updated;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_users")
    private Users _users;
    
    /**
     * @return the updated
     */
    public Date getUpdated() {
        return updated;
    }
    
    /**
     * @param updated the updated to set
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * @return the _users
     */
    public Users getUsers() {
        return _users;
    }

    /**
     * @param _users the _users to set
     */
    public void setUsers(Users _users) {
        this._users = _users;
    }
    
    
}
