package com.study.web.websocket.server;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;


@ServerEndpoint("/websocket/server/{room-no}")
public class SimpleServer {
    private static CopyOnWriteArraySet<Session> sessions = new CopyOnWriteArraySet<Session>();
    
//    static HashMap<String, List<Session>> map = new HashMap<>();
//    static {
//        map.put("101", new CopyOnWriteArrayList());
//        map.put("102", new CopyOnWriteArrayList());
//        map.put("103", new CopyOnWriteArrayList());
//    }
    
    @OnOpen
    public void onOpen(Session session, @PathParam("room-no") String roomNo) {
        System.out.println("接到連線, sessionID: " + session.getId());
        sessions.add(session);
        sendAll("歡迎 sessionID: " + session.getId() + " 加入 roomNo: " + roomNo);
        
    }
    
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        String msg = "sessionID: " + session.getId() + ", msg: " + message;
        System.out.println(msg);
        sendAll(msg);
    }
    
    @OnClose
    public void onClose(Session session) {
        System.out.println("關閉連線, sessionID: " + session.getId());
        sessions.remove(session);
        sendAll("可惡 sessionID: " + session.getId() + " 離開了");
    }
    
    private void sendAll(String msg) {
        for (Session s : sessions) {    //對每個連接的Client傳送訊息
            if (s.isOpen()) {
                s.getAsyncRemote().sendText(msg);
            }
        }
    }
    
}