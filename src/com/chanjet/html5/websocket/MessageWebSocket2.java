package com.chanjet.html5.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by admin on 2016/5/7.
 */

@ServerEndpoint(value = "/message2")
public class MessageWebSocket2 {

    @OnOpen
    public void onOpen() {
        System.out.println("****打开WebSocket连接****");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("****进行消息处理，收到的消息：" + message);
        try {
            //session.getBasicRemote().sendText("ECHO:" + message);
            Set<Session> clients =  session.getOpenSessions();//取得全部的客户端

            Iterator<Session> iterator = clients.iterator();
            while (iterator.hasNext()){
                Session temp = iterator.next();
                temp.getAsyncRemote().sendText("服务器端回应数据："+message+"("+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+")");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        System.out.println("****关闭WebSocket连接****");
    }
}
