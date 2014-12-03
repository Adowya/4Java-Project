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
    
    private String password;
    private Long card;
    private Integer role_member;

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the card
     */
    public Long getCard() {
        return card;
    }

    /**
     * @param card the card to set
     */
    public void setCard(Long card) {
        this.card = card;
    }

    /**
     * @return the role_member
     */
    public Integer getRole_member() {
        return role_member;
    }

    /**
     * @param role_member the role_member to set
     */
    public void setRole_member(Integer role_member) {
        this.role_member = role_member;
    }
    
    
    
}
