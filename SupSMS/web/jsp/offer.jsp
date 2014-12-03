<%-- 
    Document   : offer
    Created on : 3 déc. 2014, 00:26:31
    Author     : Clement
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<t:genericpage>
    <jsp:attribute name="header">
        <title>Offer</title>
    </jsp:attribute>
    <jsp:body>
        <div class="container" style="margin-top: 30px; text-align: center; width: 500px;">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">OUR OFFER</h3>
                </div>
                <div class="panel-body">
                    <span style="color: #66afe9; " class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                    <span>SMS UNLIMITED</span>
                    <hr />
                    <span style="color: #66afe9;" class="glyphicon glyphicon-refresh" aria-hidden="true"></span>                   
                    <span>MESSAGE SYNCHRONIZATION</span>
                    <hr />
                    <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span>                   
                    <span>CONTACTS UNLIMITED</span>
                    <hr />
                    <span style="color: #66afe9;" class="glyphicon glyphicon-refresh" aria-hidden="true"></span>                   
                    <span>CONTACTS SYNCHRONIZATION</span>
                    <hr />
                    <span style="color: #66afe9; font-size: 30px; font-weight: bold;">ONLY 10 $ / Month</span>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>