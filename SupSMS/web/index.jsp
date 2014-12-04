<%-- 
    Document   : index
    Created on : Jan 6, 2012, 7:10:18 PM
    Author     : bargenson
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
<t:genericpage>
    <jsp:attribute name="header">
        <title>SupSMS - Index</title>
    </jsp:attribute>
    <jsp:body>
        
        <c:choose>
            <c:when test="${not empty user}">
                
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 full-height">
                            <h2>WELCOME TO SUPSMS APPLICATION !</h2>
                        </div>
                    </div>
                </div>
                    
            </c:when>
            <c:otherwise>
                
                <div class="container bkg-index">
                    <div class="row">
                        <div class="col-md-12 full-height">
                            <h2>WELCOME TO SUPSMS APPLICATION !</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 full-height">
                            <p class="text-center" style="font-size: 34px; font-weight: bold;">
                                SEND AND RECEIVE YOUR SMS FROM EVERYWHERE ! 
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 full-height index-stats">
                            <div class="stat-bubble">
                                <div class="glyphicon glyphicon-user" aria-hidden="true"></div>
                                <div>47</div>
                                <div>Registered users</div>
                            </div>
                        </div>
                        <div class="col-md-6 full-height index-stats">
                            <div class="stat-bubble">
                                <div class="glyphicon glyphicon-envelope" aria-hidden="true"></div>
                                <div>689</div>
                                <div>SMS sent</div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12 full-height">
                            <p class="index-footer">
                                <span class="quote">"</span>
                                <span style="font-size: 28px">SupSMS is Amazing !!</span>
                                <span class="quote">"</span>
                                <span style="font-size: 14px; font-style: italic;">ITPRO Mag</span>
                            </p>
                        </div>
                    </div>
                </div>
                    
            </c:otherwise>
        </c:choose>
        
    </jsp:body>
</t:genericpage>
    