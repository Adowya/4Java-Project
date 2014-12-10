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
        String errorMsg = (String) req.getSession().getAttribute("errorMsg");
        req.getSession().removeAttribute("errorMsg");
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }
    
    public void errorMsg(String msg, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().setAttribute("errorMsg", msg);
        req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String phoneParam = req.getParameter("phone");
        String passwordParam = req.getParameter("password");
        
        if(phoneParam != null && !phoneParam.isEmpty()){
            if(passwordParam != null && !phoneParam.isEmpty()){
                Users users = usersService.findUsersByFilter(phoneParam, passwordParam);
                if(users != null){
                    req.getSession().setAttribute("user", users);
                    if(users.getRole_member() == 2){
                        req.getSession().setAttribute("admin", "adminSession");
                    }
                    resp.sendRedirect(getServletContext().getContextPath());
                }else {
                    errorMsg("Error at login", req, resp);
                }
            }else {
                errorMsg("Error at login", req, resp);
            }
        }else {
            errorMsg("Error at login", req, resp);
        }
        
    }
    
}