package com.study.web.websocket.server;

import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket/server")
public class SimpleServer {
    static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<>();
    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.printf("%s 連入, 目前人數: %d\n", session, sessions.size());
        
    }
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        
    }
    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        System.out.printf("%s 登出, 目前人數: %d\n", session, sessions.size());
    }
}