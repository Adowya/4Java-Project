/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.service;

import com.supinfo.supsms.dao.UsersDao;
import com.supinfo.supsms.entity.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Clement
 */
@Stateless
public class UsersService {
    
    @EJB
    private UsersDao usersDao;
    
    public Users addUsers(Users Users){
        return usersDao.addUsers(Users);
    }
    
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }
    
    public Users updateUsers(Users users) {
        return usersDao.updateUsers(users);
    }
    
    public void removeUsers(Long usersId) {
        usersDao.removeUsers(findUsersById(usersId));
    }
    
    public Users findUsersById(Long usersId) {
        return usersDao.findUsersById(usersId);
    }
    
    public Users findUsersByFilter(String phone, String password) {
        return usersDao.findUsersByFilter(phone, password);
    }
    
}
