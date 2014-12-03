<%-- 
    Document   : conversation
    Created on : 3 déc. 2014, 00:26:56
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
                <div class="col-lg-6 full-height">
                    <h1>Conversation</h1>
                </div>
                <div class="col-md-6 conv full-height">
                    <h1>Contact List</h1>
                    <table>
                        <thead>
                        <th>Nickname</th>
                        <th>Action</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.contactList}" var="c">
                                <tr>
                                    <td><c:out value="${c.name}" /></td>
                                    <td>Edit</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>