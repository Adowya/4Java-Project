<%-- 
    Document   : login
    Created on : 3 déc. 2014, 00:55:03
    Author     : Clement
--%>
    
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-12 well">
                    <div class="form_wrapper">
                        <form class="login" action="login" method="post">
                            <h3>Login</h3>
                            <div>
                                <label>Mail:</label>
                                <input type="text"  name="mail"/>
                            </div>
                            <div>
                                <label>Password:</label>
                                <input type="password" name="password" />
                            </div>
                            <div class="bottom">
                                <input type="submit" value="Submit"></input>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>
    
    