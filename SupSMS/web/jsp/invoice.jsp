<%-- 
    Document   : invoice
    Created on : 3 déc. 2014, 23:29:09
    Author     : Clement
--%>
    
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<t:genericpage>
    <jsp:attribute name="header">
        <title>Invoices</title>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-hover" data-toggle="table" data-cache="false" data-height="299">
                        <thead>
                            <tr>
                                <th data-field="id">ID</th>
                                <th data-field="price">Price</th>
                                <th data-field="date">Date</th>
                                <th data-field="date">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${invoice}" var="station">
                                <tr id="tr_id_1" class="tr-class-1">
                                    <td id="td_id_1" class="td-class-1">${station.id}</td>
                                    <td>${station.price}</td>
                                    <td>${station.created}</td>
                                    <td>
                                        <button type="button" class="btn btn-warning">
                                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                        </button>
                                        <button type="button" class="btn btn-danger">
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