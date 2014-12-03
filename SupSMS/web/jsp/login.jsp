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
        <title>Login</title>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
    <div class="row">
        <div class="col-md-offset-3 col-md-6 col-xs-12 col-sm-offset-1 col-sm-10 full-height">
            <div class="panel panel-primary">
             <div class="panel-heading">
                 <h3 class="panel-title">LOG IN</h3>
             </div>
             <div class="panel-body">
                <div class="form_wrapper">
                    <form class="login" action="login" method="post">
                        <div class="input-group input-group-lg">
                            <span class="input-group-addon">
                                <span style="color: #66afe9;" class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 
                            </span>
                            <input type="text" name="phone" class="form-control" placeholder="Phone number">
                        </div>
                        <br />
                        <div class="input-group input-group-lg">
                            <span class="input-group-addon">
                                <span style="color: #66afe9;" class="glyphicon glyphicon-lock" aria-hidden="true"></span> 
                            </span>
                            <input type="password" name="password" class="form-control" placeholder="Password">
                        </div>
                        <br />
                        <div class="bottom">
                            <button type="submit" class="btn btn-primary">Log in</button>
                        </div>
                        <br />
                        <span>
                            <c:url value="/register" var="registerUrl" />
                            <a href="${registerUrl}">You aren't already registered ? Please, register me now !</a>
                        </span>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
    </jsp:body>
</t:genericpage>
    
    