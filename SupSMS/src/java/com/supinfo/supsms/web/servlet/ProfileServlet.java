/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entity.Users;
import com.supinfo.supsms.service.UsersService;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Clement
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {
    
    @EJB
    private UsersService usersService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = (Users) req.getSession().getAttribute("user");
        usersService.findUsersById(user.getId());
        req.setAttribute("user", user);
        
        String error = req.getParameter("error");
        if(error != null){
            req.setAttribute("errorMsg", "Both password are different");
        }
        
        req.getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = (Users) req.getSession().getAttribute("user");
        
        users.setFirst_name(req.getParameter("user_first_name"));
        users.setLast_name(req.getParameter("user_last_name"));
        users.setEmail(req.getParameter("user_email"));
        if(req.getParameter("user_password") != null){
            if(req.getParameter("user_confirm_password").equals(req.getParameter("user_password"))){
                // Sha256 Password
                try {
                    users.setSalt();
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                String password = Users.get_SHA_256_SecurePassword(req.getParameter("user_password"),users.getSalt());
                users.setPassword(password);
            }else {
                resp.sendRedirect(req.getContextPath() + "/profile?error="+true);
                return;
            }
        }
        
        String user_zip = req.getParameter("user_zip");
        Long user_zip_long = Long.valueOf(user_zip);
        users.setZip(user_zip_long);
        
        String user_card = req.getParameter("user_card");
        Long user_card_long = Long.valueOf(user_card);
        users.setCard(user_card_long);
        users.setPhone(req.getParameter("user_phone"));
        
        usersService.updateUsers(users);
        
        resp.sendRedirect(req.getContextPath() + "/profile");
    }
    
}
