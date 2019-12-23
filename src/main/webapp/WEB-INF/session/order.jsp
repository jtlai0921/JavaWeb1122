<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css">
        <script>
            function order(n) {
                document.getElementById("amount").value = n;
                document.forms["myform"].submit();
            }
        </script>
    </head>
    <body style="padding: 15px">
        <form id="myform" name="myform" class="pure-form" method="post">
            <fieldset>
                <legend>Order Page</legend>
                庫存：<input type="number" placeholder="庫存數量" id="instock" name="instock" value="${instock}" readonly="true"> <font color="red">${message}</font><p/>
                購買：<input type="number" placeholder="購買數量" id="amount" name="amount" value="${amount}"><p/>
                <button type="button" class="pure-button pure-button-primary" onclick="order(1)">買 1 個</button>
                <button type="button" class="pure-button pure-button-primary" onclick="order(5)">買 5 個</button>
                <button type="button" class="pure-button pure-button-primary" onclick="order(10)">買 10 個</button>
                <p />
                <button type="button" class="pure-button pure-button-primary" onclick="location.href = './cart'">查看購物車</button>
                <button type="button" class="pure-button pure-button-primary" onclick="location.href = './logout'">Logout</button>

            </fieldset>
        </form>
    </body>
</html>