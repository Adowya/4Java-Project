<%-- 
    Document   : index
    Created on : Jan 6, 2012, 7:10:18 PM
    Author     : bargenson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
    <jsp:attribute name="header">
        <title>SupSMS - Index</title>
    </jsp:attribute>
    <jsp:body>
        <h2>WELCOME TO SUPSMS APPLICATION !</h2>
        <br />
        <p style="text-align: center;">
            SEND AND RECEIVE YOUR SMS FROM EVERYWHERE ! 
        </p>
        <div style="height: 500px; padding: 60px">
            <table>
                <tr>
                    <td style="width: 10%;">
                        <span style="font-size: 100px; color: #66afe9;" class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    </td>
                    <td style="width: 10%;">
                    </td>
                    <td style="width: 80%;">
                        <span style="font-size: 40px;">47 Registered users</span>
                    </td>
                </tr>
                <tr style="height: 50px;"></tr>
                <tr>
                    <td style="width: 10%;">
                        <span style="font-size: 100px; color: #66afe9;" class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                    </td>
                    <td style="width: 10%;">
                    </td>
                    <td style="width: 80%;">
                        <span style="font-size: 40px;">For 679 SMS sent</span>
                    </td>
                </tr>
            </table>
        </div>
        <p style="float: right; color: #eb9316; font-size: 28px">
            <span style="font-size: 40px">"</span>
            <span style="color: #eb9316; font-size: 28px">SupSMS is Amazing !!</span>
            <span style="font-size: 40px">"</span>
            <span style="color: black; font-size: 14px; font-style: italic;">ITPRO Mag</span>
        </p>
    </jsp:body>
</t:genericpage>

