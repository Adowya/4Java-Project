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
        System.out.println(usersList.get(0));
        
        for(Users user : usersList) {
            System.out.println(user.getLast_name());
            System.out.println(user.getFirst_name());
            System.out.println(user.getEmail());
        }
//        Users Users = (Users) usersList.get(0);
        
        
        
        if(usersList.size() > 0){
            System.out.println(usersList);
            System.out.println("22 YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO YOLOLOLOLOLOLOLOLOLO");
            req.getSession().setAttribute("user", usersList);
            resp.sendRedirect(getServletContext().getContextPath());
        }else {
            doGet(req, resp);
        }
        
        /*
        Don't do that on real life :-)
        */
//        if("admin".equals(username) && "admin".equals(password)) {
//            req.getSession().setAttribute("user", username);
//            resp.sendRedirect(getServletContext().getContextPath());
//        } else {
//            doGet(req, resp);
//        }
    }
    
}