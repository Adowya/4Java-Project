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
@WebServlet(name = "ManageUserServlet", urlPatterns = {"/manage_user"})
public class ManageUserServlet extends HttpServlet{
    
    @EJB
    private UsersService usersService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> usersList = usersService.getAllUsers();
        req.setAttribute("users", usersList);
        req.getRequestDispatcher("/jsp/admin/manage_user.jsp").forward(req, resp);
    }
    
}
