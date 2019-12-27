<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ include file="datasource.jspf" %>
<sql:query dataSource="${mydb}" var="customers">
    SELECT c.CUSTOMER_ID, c.DISCOUNT_CODE, c."NAME", c.PHONE, c.EMAIL, c.CREDIT_LIMIT 
    FROM APP.CUSTOMER c
    ORDER BY ${sortcolname} ${sortflag}
</sql:query>

<!DOCTYPE html>
<html>
    <head>
        <%@ include file="head.jspf" %>
    </head>
    <body>
        <%@ include file="menu.jspf" %>
        <table class="pure-table pure-table-bordered" width="100%">
            <thead>
                <tr style="cursor: help" title="按我一下可以排序" >
                    <th>#</th>
                    <th onclick="sort('CUSTOMER_ID')">CUSTOMER_ID</th>
                    <th>DISCOUNT_CODE</th>
                    <th>NAME</th>
                    <th>PHONE</th>
                    <th>EMAIL</th>
                    <th>CREDIT_LIMIT</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach items="${customers.rows}" var="c" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${c.CUSTOMER_ID}</td>
                        <td>${c.DISCOUNT_CODE}</td>
                        <td>${c.NAME}</td>
                        <td>${c.PHONE}</td>
                        <td>${c.EMAIL}</td>
                        <td>${c.CREDIT_LIMIT}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
    </body>
</html>