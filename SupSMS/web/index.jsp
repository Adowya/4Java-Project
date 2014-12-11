    
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
                    <div class="row full-height">
                        <div class="col-lg-6 full-height">
                            <h1>Contact List</h1>
                            <ul class="widget-list" id="developers">
                                
                                <c:forEach items="${contact}" var="contact">
                                    <li>
                                        <a class="widget-list-link " href="conversation?id=${contact.id}" >
                                            <img src="http://www.gravatar.com/avatar/6?f=y&amp;s=64&amp;d=identicon">
                                            ${contact.first_name}  ${contact.last_name}<span>${contact.phone}</span>
                                        </a>
                                        <div title="Show contact card" class="edit-contact">
                                            <button onclick="window.location.href='contact?id=${contact.id}';" type="button" class="btn btn-warning">
                                                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                                            </button>
                                                <!--If!a!contact!is!deleted,!his!conversation!is!deleted.!-->
                                            <button onclick="window.location.href='contact?delete=${contact.id}';" type="button" class="btn btn-danger">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </button>
                                        </div>
                                    </li>
                                        
                                </c:forEach>                      
                            </ul>
                        </div>
                        <div class="col-md-6 full-height">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Add Contact</h3>
                                </div>
                                <div class="panel-body">
                                    <div class="form_wrapper">
                                        <form class="index" action="index" method="post">
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
                                                
                                            <div class="bottom">
                                                <button type="submit" value="Submit" class="btn btn-primary">Create contact</button>
                                            </div>
                                            <br />
                                        </form>
                                    </div>
                                </div>
                            </div>
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
                                <div>${countUsers}</div>
                                <div>Registered users</div>
                            </div>
                        </div>
                        <div class="col-md-6 full-height index-stats">
                            <div class="stat-bubble">
                                <div class="glyphicon glyphicon-envelope" aria-hidden="true"></div>
                                <div>${countSms}</div>
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
    