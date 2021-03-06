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
        <title>Register</title>
    </jsp:attribute>
    <jsp:body>
        <c:choose>
            <c:when test="${not empty errorMsg}">
                <div class="alert alert-danger col-md-7 col-md-offset-3" style="z-index: 1000;margin-top: 10px;">
                    ${errorMsg}
                </div>
            </c:when>
            <c:otherwise></c:otherwise>
        </c:choose>
        <div class="container">
            <div class="row">
                <div class="col-md-offset-3 col-md-6 col-xs-12 col-sm-offset-1 col-sm-10 full-height">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">REGISTER ME</h3>
                        </div>
                        <div class="panel-body">
                            <div class="form_wrapper">
                                <form class="register" action="register" method="post">
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-envelope" aria-hidden="true"></span> 
                                        </span>
                                        <input type="email" name="email" class="form-control" placeholder="Email">
                                    </div>
                                    <br />
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" name="first_name" class="form-control" placeholder="Firstname">
                                    </div>
                                    <br />
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" name="last_name" class="form-control" placeholder="Lastname">
                                    </div>
                                    <br />
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-home" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" name="zip" class="form-control" placeholder="Zip">
                                    </div>
                                    <br />
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
                                        <input type="password" name="password" name="password" class="form-control" placeholder="Password">
                                    </div>
                                    <br />
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" name="card" class="form-control" placeholder="Credit card">
                                    </div>
                                    <br />
                                    <div class="bottom">
                                        <button type="submit" value="Submit" class="btn btn-primary">Register me</button>
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
            </div>
        </div>
    </jsp:body>
</t:genericpage>
