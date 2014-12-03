/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Clement
 */
@Entity
@Table(name = "invoice")
@XmlRootElement
public class Invoice implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotNull
    @Column(nullable=false)
    private Long price;
    
    @ManyToOne
    @JoinColumn(name = "fk_users")
    private Users _users;
    
    @NotNull
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    
    
    public Invoice(){
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
     * @return the price
     */
    public Long getPrice() {
        return price;
    }
    
    /**
     * @param price the price to set
     */
    public void setPrice(Long price) {
        this.price = price;
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
