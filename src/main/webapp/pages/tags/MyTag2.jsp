<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/tlds/my" prefix="my" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><my:prime num="${param.num}" /></h1>
        <h1><my:fib num="${param.num}" /></h1>
        <h1>
            <my:lucky n="${param.n}">
                恭喜你~ 紅包: $10,0000
            </my:lucky>
        </h1>
    </body>
</html>