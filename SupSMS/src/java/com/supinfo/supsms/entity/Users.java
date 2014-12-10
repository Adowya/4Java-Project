/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
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
    private String salt;
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
    
    public static String get_SHA_256_SecurePassword(String passwordToHash, String salt)
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    
    //Add salt
    public static String buildSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }
    
    
    public void setSalt() throws NoSuchAlgorithmException {
        this.salt = buildSalt();
    }
    
    /**
     * @return the salt
     */
    public String getSalt() {
        return salt;
    }
    
    
    
    
    
    
}
