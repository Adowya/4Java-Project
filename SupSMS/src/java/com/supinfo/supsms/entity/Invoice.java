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
    private Date created;
    
    
    public Invoice(){
        super();
    }
    
}
