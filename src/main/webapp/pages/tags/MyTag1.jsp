<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://my.scwcd" prefix="my"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><my:greet user="Vincent" /></h1>
        <h1><my:greet /></h1>
        <h1><my:greet user="${param.name}" /></h1> <!--網址後面可帶入參數 ?name=anita -->
        <h1><my:required /></h1>
        <my:mark search="h">
            dfgrgfdefsdfdf
        </my:mark>
        <p />
        <my:switch conditionValue="1">
            <my:case caseValue="1">
                One
            </my:case>
            <my:case caseValue="2">
                Two
            </my:case>    
            <my:default>
                Other
            </my:default>    
        </my:switch>
        <p/>
        <my:loop count="3">
            <%=new Date() %>
        </my:loop>
    </body>
</html>