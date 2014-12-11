<%-- 
    Document   : manage_user
    Created on : 3 déc. 2014, 23:28:15
    Author     : Clement
--%>
    
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<t:genericpage>
    <jsp:attribute name="header">
        <title>Manage user</title>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover" data-toggle="table" data-cache="false" data-height="299">
                        <thead>
                            <tr>
                                <th data-field="id">ID</th>
                                <th data-field="last_name">Last name</th>
                                <th data-field="first_name">First name</th>
                                <th data-field="action">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${users}" var="users">
                                <tr id="tr_id_1" class="tr-class-1">
                                    <td id="td_id_1" class="td-class-1">${users.id}</td>
                                    <td>${users.last_name}</td>
                                    <td>${users.first_name}</td>
                                    <td>
                                        
                                        <button type="button" onclick="window.location.href='manage_user?delete=${users.id}';" class="btn btn-danger">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </button>
                                    </td>
                                        
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>