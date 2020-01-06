package com.study.web.websocket.server;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/server")
public class SimpleServer {
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