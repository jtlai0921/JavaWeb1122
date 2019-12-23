<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">

    </head>
    <body style="padding: 15px">
        <form id="myform" name="myform" class="pure-form" method="post">
            <fieldset>
                <legend>Cart Page</legend>
                <table class="pure-table pure-table-bordered">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Date</th>
                            <th>Amount</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="c" varStatus="no" items="${carts}">
                            <c:set var="total" value="${total + c.value}"/>
                            <tr>
                                <td>${no.index + 1}</td>
                                <td>${c.key}</td>
                                <td>${c.value}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr bgcolor='#DDDDDD'>
                            <td align="right" colspan="2">Total</td>
                            <td><fmt:formatNumber value="${total}" type="number"/></td>
                        </tr>
                    </tfoot>
                </table>
                <p />
                <button type="button" class="pure-button pure-button-primary" onclick="location.href = './order'">繼續買</button>
                <button type="button" class="pure-button pure-button-primary" onclick="location.href = './logout'">Logout</button>
            </fieldset>
        </form>
    </body>
</html>