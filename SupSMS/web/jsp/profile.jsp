<%-- 
    Document   : profile
    Created on : 3 déc. 2014, 00:27:14
    Author     : Clement
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<t:genericpage>
    <jsp:attribute name="header">
        <title>Profile</title>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form action="profile" method="post">
                        <table class="profile_tab">
                            <h1>User profile</h1>
                            <thead>
                            <th>Information</th>
                            <th>Value</th>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>id</td>
                                    <td>${requestScope.user.id}</td>
                                </tr>
                                <tr>
                                    <td>First Name</td>
                                    <td><input type="text" value="${requestScope.user.first_name}" name="user_first_name" /></td>
                                </tr>
                                <tr>
                                    <td>Last Name</td>
                                    <td><input type="text" value="${requestScope.user.last_name}" name="user_last_name" /></td>
                                </tr>
                                <tr>
                                    <td>Mail</td>
                                    <td><input type="text" value="${requestScope.user.email}" name="user_email" /></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input type="password" value="${requestScope.user.password}" name="user_password" /></td>
                                </tr>
                                <tr>
                                    <td>Phone</td>
                                    <td><input type="text" value="${requestScope.user.phone}" name="user_phone" /></td>
                                </tr>
                                <tr>
                                    <td>Zip</td>
                                    <td><input type="text" value="${requestScope.user.zip}" name="user_zip" /></td>
                                </tr>
                                <tr>
                                    <td>Card</td>
                                    <td><input type="text" value="${requestScope.user.card}" name="user_card" /></td>
                                </tr>
                                <tr>
                                </tr>
                            <td></td>
                            <td><div>
                                    <input type="submit" value="Modifier">
                                </div></td>
                            </tr>
                            </tbody>
                        </table>
                            
                    </form>
                        
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>