/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.supinfo.supsms.web.filter;

import com.supinfo.supsms.entity.Users;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Clement
 */
//@WebFilter(urlPatterns = {"/", ""})
@WebFilter(urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Do nothing
    }
    
    
    private boolean excludeFromFilter(String path) {
        if (path.startsWith("/offer")) return true;
        if (path.startsWith("/js")) return true;
        if (path.startsWith("/login")) return true;
        if (path.contentEquals("/")) return true;
        if (path.contentEquals("")) return true;
        if (path.startsWith("/register")) return true;
        else return false;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        String path = ((HttpServletRequest) request).getServletPath();
        if (excludeFromFilter(path)){
            System.out.print(path);
            chain.doFilter(request, response);
        } else
        {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            
            if(httpRequest.getSession().getAttribute("user") == null) {
                httpResponse.sendRedirect(request.getServletContext().getContextPath() + "/login");
            } else {
                if (path.startsWith("/manage")){
                    if(httpRequest.getSession().getAttribute("admin") == null) {
                        httpResponse.sendRedirect(request.getServletContext().getContextPath());
                    }else {
                        chain.doFilter(request, response);
                    }
                }else {
                    chain.doFilter(request, response);
                }
            }
            
        }
        
    }
    
    @Override
    public void destroy() {
        // Do nothing
    }
    
}