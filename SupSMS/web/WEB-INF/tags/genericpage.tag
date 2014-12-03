<%-- 
    Document   : genericpage
    Created on : 3 dev. 2014, 00:32:08
    Author     : Clement
--%>

<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:invoke fragment="header"/>
        
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/libs/twitter-bootstrap/css/bootstrap.css" />
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/js/libs/twitter-bootstrap/css/style.css" />
        
        <link src="${pageContext.request.contextPath}/js/libs/jquery.min.js"/>
        <link src="${pageContext.request.contextPath}/js/libs/custom.js"/>
        
        
    </head>
    <body>
        <header class="bs-header text-center">
            <div id="navbar" class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <c:url value="/" var="homeUrl" />
                <a class="navbar-brand" href="${homeUrl}">
                    <h1 class="site-title">SupSMS</h1></a>
                
                <div class="clearfix"></div>
                <div class="collapse navbar-collapse">
                    <ul class="nav nav-stacked" id="menu-bar">
                        <li><a href="${homeUrl}">Index</a></li>
                        
                        <c:url value="/offer" var="offerUrl" />
                        <li><a href="${offerUrl}">Offer page</a></li>
                        
                        
                        <c:choose>
                            <c:when test="${not empty user}">
                                
                                <c:url value="/conversation" var="conversationUrl" />
                                <li><a href="${conversationUrl}">Conversation page</a></li>
                                
                                <c:url value="/profile" var="profileUrl" />
                                <li><a href="${profileUrl}">Profile</a></li>
                                
                                <c:url value="/invoice" var="invoiceUrl" />
                                <li><a href="${invoiceUrl}">Profile</a></li>
                                
                                
                                <c:url value="/logout" var="logoutUrl" />
                                <li><a href="${logoutUrl}">Logout</a></li>
                                
                                
                                <c:when test="${not empty admin}">
                                    <li class="panel dropdown"> <!-- We add the panel class to workaround collapsing menu items in Bootstrap -->
                                        <a data-toggle="collapse" data-parent="#menu-bar" href="#collapseTwo">
                                            Admin Panel         
                                        </a>
                                        <ul id="collapseTwo" class="panel-collapse collapse"> <!-- Notice the ID of this element must match the href attribute in the <a> element above it. Also we have added the panel-collapse class -->
                                            <c:url value="/managee-users" var="manageeUsersUrl" />
                                            <li><a href="${manageeUsersUrl}">Show and manage all users</a></li>
                                            
                                            <c:url value="/managee-users" var="manageeUsersUrl" />
                                            <li><a href="${manageeUsersUrl}">Show all invoices</a></li>
                                        </ul>
                                    </li>
                                </c:when>
                                
                            </c:when>
                            
                            <c:otherwise>
                                <c:url value="/login" var="loginUrl" />
                                <li><a href="${loginUrl}">Log in</a></li>
                                
                                <c:url value="/register" var="registerUrl" />
                                <li><a href="${registerUrl}">Register</a></li>
                                
                            </c:otherwise>
                        </c:choose>             
                    </ul>
                </div>
                
            </div>
        </header>
        
        <div class="clearfix"></div>
        <div class="content full-height">
            <div class="container full-height">
                <div class="row full-height">
                    <div class="col-lg-12 full-height">
                        <div id="body">
                            <jsp:doBody/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </body>
</html>




