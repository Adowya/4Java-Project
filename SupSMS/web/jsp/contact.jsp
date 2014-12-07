<%-- 
    Document   : contact
    Created on : 7 déc. 2014, 02:34:25
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
                <div class="col-md-offset-3 col-md-6 col-xs-12 col-sm-offset-1 col-sm-10 full-height">
                    
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Edit Contact</h3>
                        </div>
                        <div class="panel-body">
                            <div class="form_wrapper">
                                <form class="register" action="index" method="post">
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-envelope" aria-hidden="true"></span> 
                                        </span>
                                        <input type="email" value="${requestScope.contact.email}" name="email" class="form-control" placeholder="Email">
                                    </div>
                                    <br />
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.contact.first_name}" name="first_name" class="form-control" placeholder="Firstname">
                                    </div>
                                    <br />
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.contact.last_name}" name="last_name" class="form-control" placeholder="Lastname">
                                    </div>
                                    <br />
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-home" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.contact.zip}" name="zip" class="form-control" placeholder="Zip">
                                    </div>
                                    <br />
                                    <div class="input-group input-group-lg">
                                        <span class="input-group-addon">
                                            <span style="color: #66afe9;" class="glyphicon glyphicon-earphone" aria-hidden="true"></span> 
                                        </span>
                                        <input type="text" value="${requestScope.contact.phone}" name="phone" class="form-control" placeholder="Phone number">
                                    </div>
                                    <br />
                                        
                                    <div class="bottom">
                                        <button type="submit" value="Submit" class="btn btn-primary">Edit contact</button>
                                    </div>
                                    <br />
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>