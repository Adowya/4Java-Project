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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "sms")
@XmlRootElement
public class Sms implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    
    @ManyToOne
    @JoinColumn(name = "fk_contact")
    private Contact _contact;
    @ManyToOne
    @JoinColumn(name = "fk_users")
    private Users _users;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    public Sms(){
        super();
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return the text
     */
    public String getText() {
        return text;
    }
    
    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }
    
    /**
     * @return the _contact
     */
    public Contact getContact() {
        return _contact;
    }
    
    /**
     * @param _contact the _contact to set
     */
    public void setContact(Contact _contact) {
        this._contact = _contact;
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
    
    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }
    
    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }
    
    
    
}