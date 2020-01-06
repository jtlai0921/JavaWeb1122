package com.study.web.websocket.client;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;


@ClientEndpoint
public class SimpleClient {
    @OnOpen
    public void onOpen(Session session) {
        
    }
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        
    }
    @OnClose
    public void onClose(Session session) {
        
    }
}
