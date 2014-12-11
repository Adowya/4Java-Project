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
                            <h3 class="panel-title">USER ACCOUNT</h3>
                        </div>
                        <div class="panel-body">
                            <div class="form_wrapper">
                                <form class="profile" action="profile" method="post">
                                    <label>Phone number :</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.user.phone}" name="user_phone" class="form-control">
                                    </div>
                                    <br />
                                    <label>Mail :</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-envelope" aria-hidden="true"></span> 
                                        </span>
                                        <input type="email" value="${requestScope.user.email}" name="user_email" class="form-control">
                                    </div>
                                    <br />
                                    <label>Firstname :</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.user.first_name}" name="user_first_name" class="form-control">
                                    </div>
                                    <br />
                                    <label>Lastname :</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.user.last_name}" name="user_last_name" class="form-control">
                                    </div>
                                    <br />
                                    <label>Zip :</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-home" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.user.zip}" name="user_zip" class="form-control">
                                    </div>
                                    <br />
                                    <label>Password :</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-lock" aria-hidden="true"></span> 
                                        </span>
                                        <input type="password" value="" name="user_password" class="form-control">
                                    </div>
                                    <br />
                                    <label>Confirm Password :</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-lock" aria-hidden="true"></span> 
                                        </span>
                                        <input type="password" value="" name="user_confirm_password" class="form-control">
                                    </div>
                                    <br />
                                    <label>Credit card :</label>
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.user.card}" name="user_card" class="form-control">
                                    </div>
                                    <br />
                                    <div class="bottom">
                                        <button type="submit" value="Submit" class="btn btn-primary">Modify my informations</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>