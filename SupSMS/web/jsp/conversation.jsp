<%-- 
    Document   : conversation
    Created on : 3 déc. 2014, 00:26:56
    Author     : Clement
--%>
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<t:genericpage>
    <jsp:attribute name="header">
        <title>Conversation</title>
    </jsp:attribute>
    <jsp:body>
        <div class="container no-padding-top">
            <div class="row full-height">
                <div class="col-lg-6 full-height">
                    <div class="conversation">
                        <h1>Conversation<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></h1>
                        <div class="progress">
                            <div id="progress-msg" class="progress-bar" role="progressbar">
                                <span class="sr-only"></span>
                            </div>
                        </div>
                        <div class="conversation-msg">
                            <c:forEach items="${sms}" var="sms">
                                ${sms.created}
                                <div class="bubble">
                                    ${sms.text}
                                </div>
                            </c:forEach>
                        </div>
                        <div class="newmsg-form">
                            <!--                            <form:form id="formMsg" action="conversation">
                                                             <input type="text" name="message" placeholder="Message">
                                                            <button type="submit" name="send" class="btn btn-link">Send</button>
                                                        </form:form>-->
                            <form id="formMsg" action="conversation" method="POST">
                                <input type="text" name="message" placeholder="Message">
                                <button type="submit" name="send" class="btn btn-link">Send</button>
                                <input type="hidden" name="param" value="${contactId}">
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 conv full-height">
                    <h1>Contact List</h1>
                    <ul class="widget-list" id="developers">
                        <c:forEach items="${contact}" var="contact">
                            <li>
                                <a class="widget-list-link " href="conversation?id=${contact.id}" >
                                    <img src="http://www.gravatar.com/avatar/6?f=y&amp;s=64&amp;d=identicon">
                                    ${contact.first_name}  ${contact.last_name}<span>${contact.phone}</span>
                                </a>
                                <div title="Show contact card" class="edit-contact">
                                    <span class="glyphicon glyphicon-user"></span>
                                </div>
                            </li>
                                
                        </c:forEach>                      
                    </ul>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(".conversation-msg").animate({ scrollTop: $(document).height() }, 0);
            $("#formMsg").submit(function(e){
                if($("#progress-msg").css('width') != $("#progress-msg").parent().css('width')){
                    e.preventDefault();
                }
                $("#progress-msg").css({ width: '100%' });
                setTimeout(function(){
                    $("#formMsg").submit();
                },1000);
            });
            
        </script>
    </jsp:body>
</t:genericpage>