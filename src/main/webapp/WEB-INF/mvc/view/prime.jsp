<%@ page import="java.util.Map"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Prime Number</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
    </head>
    <body style="padding: 15px">
        <form class="pure-form" method="post" action="./calc">
            <fieldset>
                <legend>Prime Number</legend>
                <input type="number" placeholder="請輸入數字" name="number" value="${n}"><p />
                <button type="submit" class="pure-button pure-button-primary">檢查</button><p />
                ${result}
                <hr>
            </fieldset>
        </form>
        <table class="pure-table pure-table-bordered">
            <thead>
                <tr>
                    <th>key</th>
                    <th>value</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="x" items="${results}">
                <tr style="cursor: hand" title="按我一下可刪除" onclick="location.href='./del?number=${x.key}'">
                    <td>${x.key}</td>
                    <td>${x.value}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>    
    </body>
</html>

