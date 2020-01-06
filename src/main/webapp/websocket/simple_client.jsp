<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>WebSocket SimpleClient</title>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css">
            .div_right_bottom {
                width:300px;
                float:right;
                position:fixed;
                right:10px;
                bottom:10px;
                z-index:20;
                border:1px solid #69c;
                _position:absolute; /* position fixed for IE6 */
            }
        </style>
        <script src="ws.js"></script>
    </head>
    <body style="padding: 20px">
        <div class="div_right_bottom">
            <form class="pure-form" onsubmit="return false;">
                <fieldset>
                    <legend>Simple Client</legend>
                    <select id="roomNo">
                        <option value="101">101</option>
                        <option value="102">102</option>
                        <option value="103">103</option>
                    </select>
                    <input type="text"   id="message"    value="Hello"   placeholder="請輸入訊息" /> <p />
                    <input type="button" id="openBtn"    value="Open"    class="pure-button pure-button-primary" /> 
                    <input type="button" id="messageBtn" value="Message" class="pure-button pure-button-primary" disabled /> 
                    <input type="button" id="closeBtn"   value="Close"   class="pure-button pure-button-primary" disabled /> 
                </fieldset>
            </form>
            <div id="messageDisplay"></div>
        </div>
        
    </body>
</html>