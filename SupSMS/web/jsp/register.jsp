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
        <div class="container" style="margin-top: 30px; text-align: center; width: 500px;">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">REGISTER ME</h3>
                </div>
                <div class="panel-body">
                    <div class="form_wrapper">
                        <form class="login" action="login" method="post">
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <span style="color: #66afe9;" class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> 
                                </span>
                                <input type="email" class="form-control" placeholder="Email">
                            </div>
                            <br />
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span> 
                                </span>
                                <input type="text" class="form-control" placeholder="Firstname">
                            </div>
                            <br />
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span> 
                                </span>
                                <input type="text" class="form-control" placeholder="Lastname">
                            </div>
                            <br />
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <span style="color: #66afe9;" class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> 
                                </span>
                                <input type="text" class="form-control" placeholder="Zip">
                            </div>
                            <br />
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <span style="color: #66afe9;" class="glyphicon glyphicon-phone" aria-hidden="true"></span> 
                                </span>
                                <input type="text" class="form-control" placeholder="Phone number">
                            </div>
                            <br />
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <span style="color: #66afe9;" class="glyphicon glyphicon-cutlery" aria-hidden="true"></span> 
                                </span>
                                <input type="password" name="password" class="form-control" placeholder="Password">
                            </div>
                            <br />
                            <div class="input-group input-group-lg">
                                <span class="input-group-addon">
                                    <span style="color: #66afe9;" class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> 
                                </span>
                                <input type="text" class="form-control" placeholder="Credit card">
                            </div>
                            <br />
                            <div class="bottom">
                                <button type="submit" class="btn btn-primary">Register me</button>
                            </div>
                            <br />
                            <span>
                                <c:url value="/login" var="loginUrl" />
                                <a href="${loginUrl}">You are already registered ? Please, log me now !</a>
                            </span>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>