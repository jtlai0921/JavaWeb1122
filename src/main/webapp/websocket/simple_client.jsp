<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WebSocket SimpleClient</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="ws.js"></script>
    </head>
    <body style="padding: 20px">
        <div>
            <form class="pure-form" onsubmit="return false;">
                <fieldset>
                    <legend>Simple Client</legend>
                    <input type="text"   id="message"    value="Hello"   placeholder="請輸入訊息" /> <p />
                    <input type="button" id="openBtn"    value="Open"    class="pure-button pure-button-primary" /> 
                    <input type="button" id="messageBtn" value="Message" class="pure-button pure-button-primary" disabled /> 
                    <input type="button" id="closeBtn"   value="Close"   class="pure-button pure-button-primary" disabled /> 
                </fieldset>
            </form>
        </div>
        <div id="messageDisplay"></div>
    </body>
</html>