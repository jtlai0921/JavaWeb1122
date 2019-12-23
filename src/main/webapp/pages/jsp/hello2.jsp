<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    int add(String x, String y) {
        if (x != null && y != null) {
            return Integer.parseInt(x) + Integer.parseInt(y);
        }
        return 0;
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <%
                String x = request.getParameter("x");
                String y = request.getParameter("y");
                out.print(x + " + " + y + " = " + add(x, y));
            %>
        </h1>
    </body>
</html>
