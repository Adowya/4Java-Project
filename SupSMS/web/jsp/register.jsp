<%-- 
    Document   : register
    Created on : 3 déc. 2014, 00:24:33
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
                        <form class="signup" action="signup" method="post">
                            <h3>Sign Up</h3>
                            <label>First Name:</label> <input type="text" name="first_name">
                            <label>Last Name:</label> <input type="text" name="last_name"> 
                            <label>Mail:</label> <input type="text" name="mail">
                            <label>Password:</label> <input type="password" name="password">
                            <input 
                                type="submit" value="Submit">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>