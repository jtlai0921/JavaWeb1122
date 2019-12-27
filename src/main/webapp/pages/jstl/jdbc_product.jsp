<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ include file="datasource.jspf" %>
<sql:query dataSource="${mydb}" var="products">
    SELECT 
    product_id, purchase_cost, quantity_on_hand, (purchase_cost*quantity_on_hand) as subtotal, description
    FROM
    product
</sql:query>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file="menu.jspf" %>
        <table class="pure-table pure-table-bordered" width="100%">
            <thead>
                <tr>
                    <th>#</th>
                    <th>product_id</th>
                    <th>purchase_cost</th>
                    <th>quantity_on_hand</th>
                    <th>subtotal</th>
                    <th>description</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${products.rows}" var="p" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${p.product_id}</td>
                        <td>${p.purchase_cost}</td>
                        <td>${p.quantity_on_hand}</td>
                        <td>${p.subtotal}</td>
                        <td>${p.description}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>