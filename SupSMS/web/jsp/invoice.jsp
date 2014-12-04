<%-- 
    Document   : invoice
    Created on : 3 déc. 2014, 23:29:09
    Author     : Clement
--%>
    
    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<t:genericpage>
    <jsp:attribute name="header">
        <title>Invoices</title>
    </jsp:attribute>
    <jsp:body>
        <div class="container">
            <div class="row">
                <div class="col-md-12 well">
                    <table data-toggle="table" data-cache="false" data-height="299">
                        <thead>
                            <tr>
                                <th data-field="id">Item ID</th>
                                <th data-field="name">Item Name</th>
                                <th data-field="price">Item Price</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr id="tr_id_1" class="tr-class-1">
                                <td id="td_id_1" class="td-class-1">1</td>
                                <td>Item 1</td>
                                <td>$1</td>
                            </tr>
                            <tr id="tr_id_2" class="tr-class-2">
                                <td id="td_id_2" class="td-class-2">2</td>
                                <td>Item 2</td>
                                <td>$2</td>
                            </tr>
                            <tr id="tr_id_3" class="tr-class-3">
                                <td id="td_id_3" class="td-class-3">3</td>
                                <td>Item 3</td>
                                <td>$3</td>
                            </tr>
                            <tr id="tr_id_4" class="tr-class-4">
                                <td id="td_id_4" class="td-class-4">4</td>
                                <td>Item 4</td>
                                <td>$4</td>
                            </tr>
                            <tr id="tr_id_5" class="tr-class-5">
                                <td id="td_id_5" class="td-class-5">5</td>
                                <td>Item 5</td>
                                <td>$5</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </jsp:body>
</t:genericpage>