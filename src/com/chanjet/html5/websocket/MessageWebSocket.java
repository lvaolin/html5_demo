package com.chanjet.html5.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by admin on 2016/5/7.
 */

@ServerEndpoint(value = "/message")
public class MessageWebSocket {

    @OnOpen
    public void onOpen() {
        System.out.println("****打开WebSocket连接****");
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("****进行消息处理，收到的消息：" + message);

        try {
            session.getBasicRemote().sendText("ECHO:" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose() {
        System.out.println("****关闭WebSocket连接****");
    }
}
