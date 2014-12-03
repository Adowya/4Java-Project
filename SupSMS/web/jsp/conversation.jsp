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
        <div class="container">
            <div class="row">
                <div class="col-lg-6 full-height">
                    <h1>Conversation</h1>
                    <div class="container">
                        <div class="bubble">
                            Blue text bubble
                        </div>
                            
                        <div class="bubble bubble--alt">
                            Green text bubble
                        </div>
                            
                        <div class="bubble">
                            A bubble containing lots and lots and lots and lots of content on multiple lines
                        </div>
                            
                        <div class="bubble bubble--alt">
                            Bubble with image
                        </div>
                            
                        <div class="bubble">
                            Bubblewitharidiculouslylongwordwhichwrapseffortlesslyontotwolines
                        </div>
                            
                    </div>
                </div>
                <div class="col-md-6 conv full-height">
                    <h1>Contact List</h1>
                    <ol class="widget-list" id="developers">
                        <li>
                            <a class="widget-list-link">
                                <img src="http://www.gravatar.com/avatar/6?f=y&amp;s=64&amp;d=identicon">
                                Joe Doe #1 <span>489218E3</span>
                            </a>
                        </li>
                        <li>
                            <a class="widget-list-link">
                                <img src="http://www.gravatar.com/avatar/6?f=y&amp;s=64&amp;d=identicon">
                                Jacky Chann #2 <span>9082173</span>
                            </a>
                        </li>
                        <li>
                            <a class="widget-list-link">
                                <img src="http://www.gravatar.com/avatar/6?f=y&amp;s=64&amp;d=identicon">
                                Developer #3 <span>837E7</span>
                            </a>
                        </li>
                    </ol>
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
    </jsp:body>
</t:genericpage>