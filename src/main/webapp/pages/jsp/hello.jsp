<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
    public Date getToday() {
        return new Date();
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1><%=1+1 %></h1>
        <h1><%out.println(1+1); %></h1>
        <h1><%=getToday() %></h1>
    </body>
</html>

