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
                            <div class="bubble">
                                Blue text bubble
                            </div>
                            <div class="bubble">
                                A bubble containing lots and lots and lots and lots of content on multiple lines
                            </div>
                            <div class="bubble">
                                Bubblewitharidiculouslylongwordwhichwrapseffortlesslyontotwolines
                            </div>
                            <div class="bubble">
                                Blue text bubble
                            </div>
                            <div class="bubble">
                                A bubble containing lots and lots and lots and lots of content on multiple lines
                            </div>
                            <div class="bubble">
                                Bubblewitharidiculouslylongwordwhichwrapseffortlesslyontotwolines
                            </div>
                            <div class="bubble">
                                Blue text bubble
                            </div>
                            <div class="bubble">
                                A bubble containing lots and lots and lots and lots of content on multiple lines
                            </div>
                            <div class="bubble">
                                Bubblewitharidiculouslylongwordwhichwrapseffortlesslyontotwolines
                            </div>
                            <div class="bubble">
                                Blue text bubble
                            </div>
                            <div class="bubble">
                                A bubble containing lots and lots and lots and lots of content on multiple lines
                            </div>
                            <div class="bubble">
                                Bubblewitharidiculouslylongwordwhichwrapseffortlesslyontotwolines
                            </div>
                            <div class="bubble">
                                Blue text bubble
                            </div>
                            <div class="bubble">
                                A bubble containing lots and lots and lots and lots of content on multiple lines
                            </div>
                            <div class="bubble">
                                Bubblewitharidiculouslylongwordwhichwrapseffortlesslyontotwolines
                            </div>
                            <div class="bubble">
                                Blue text bubble
                            </div>
                            <div class="bubble">
                                A bubble containing lots and lots and lots and lots of content on multiple lines
                            </div>
                            <div class="bubble">
                                Bubblewitharidiculouslylongwordwhichwrapseffortlesslyontotwolines
                            </div>
                        </div>
                        <div class="newmsg-form">
                            <form id="formMsg" action="conversation" method="POST">
                                <input type="text" name="message" placeholder="Message">
                                <button type="submit" class="btn btn-link">Send</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 conv full-height">
                    <h1>Contact List</h1>
                    <ul class="widget-list" id="developers">
                        <li>
                            <a class="widget-list-link active">
                                <img src="http://www.gravatar.com/avatar/6?f=y&amp;s=64&amp;d=identicon">
                                Joe Doe #1 <span>489218E3</span>
                            </a>
                            <div title="Show contact card" class="edit-contact"><span class="glyphicon glyphicon-user"></span></div>
                        </li>
                        <li>
                            <a class="widget-list-link">
                                <img src="http://www.gravatar.com/avatar/6?f=y&amp;s=64&amp;d=identicon">
                                Joe Doe #1 <span>489218E3</span>
                            </a>
                            <div title="Show contact card" class="edit-contact"><span class="glyphicon glyphicon-user"></span></div>
                        </li>
                        <li>
                            <a class="widget-list-link">
                                <img src="http://www.gravatar.com/avatar/6?f=y&amp;s=64&amp;d=identicon">
                                Joe Doe #1 <span>489218E3</span>
                            </a>
                            <div title="Show contact card" class="edit-contact"><span class="glyphicon glyphicon-user"></span></div>
                        </li>                       
                    </ul>
                    <table>
                        <thead>
                        <th>Nickname</th>
                        <th>Action</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${requestScope.contactList}" var="c">
                                <tr>
                                    <td><c:out value="${c.name}" /></td>
                                    <td>Edit</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
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