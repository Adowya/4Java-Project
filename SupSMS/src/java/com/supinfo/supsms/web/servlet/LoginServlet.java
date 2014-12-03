/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.web.servlet;

import com.supinfo.supsms.entity.Users;
import com.supinfo.supsms.service.UsersService;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    
    @EJB
    private UsersService usersService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneParam = (req.getParameter("phone") != null) ? req.getParameter("phone") : "";
        String passwordParam = (req.getParameter("password") != null) ? req.getParameter("password") : "";
        
        Long phone = null;
        if(!phoneParam.trim().isEmpty()) {
            try {
                phone = new Long(phoneParam);
            } catch (NumberFormatException e) {
                
            }
        }
        
        List<Users> usersList = usersService.findUsersByFilter(phone, passwordParam);
        
        for(Users user : usersList) {
            System.out.println(user.getLast_name());
            System.out.println(user.getFirst_name());
            System.out.println(user.getEmail());
            System.out.println(user.getRole_member());
        }
        Users Users = (Users) usersList.get(0);
        
        if(usersList.size() > 0){
            req.getSession().setAttribute("user", usersList);
            if(Users.getRole_member() == 2){
                System.out.println("admin");
                req.getSession().setAttribute("admin", "adminSession");
            }
            resp.sendRedirect(getServletContext().getContextPath());
        }else {
            doGet(req, resp);
        }
        
    }
    
}