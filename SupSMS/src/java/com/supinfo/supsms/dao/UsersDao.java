/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.dao;

import com.supinfo.supsms.entity.Users;
import java.util.List;

/**
 *
 * @author Clement
 */
public interface UsersDao {
    
    Users addUsers(Users Users);
    
    List<Users> getAllUsers();
    
    public Users findUsersById(Long UsersId);
    
    Users updateUsers(Users Users);
    
    public void removeUsers(Users findUsersById);
    
    public List<Users> findUsersByFilter(Long phone, String password);
    
}
