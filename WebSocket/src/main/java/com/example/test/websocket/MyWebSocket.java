package com.example.test.websocket;

import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/websocket/{userName}")
@Component
@EqualsAndHashCode
@Log4j2
public class MyWebSocket {
    private static Map<Session, String> currentSessions = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("userName") String username,  Session session) {
        this.session = session;

        currentSessions.put(this.session, username);

        log.info("新连接[{}]加入！当前在线人数为{}", username, currentSessions.size());
        try {
            sendMessage(session,"已连接...");
        } catch (IOException e) {
            log.error("IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        String username = currentSessions.get(this.session);

        currentSessions.remove(this.session);

        log.info("连接[{}]关闭！当前在线人数为{}", username, currentSessions.size());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("来自客户端[{}]的消息:{}", currentSessions.get(session), message);

        sendGroupMessage(message);
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("Session [{}] 发生错误.", currentSessions.get(session), error.getMessage());

        error.printStackTrace();
    }

    private void sendMessage(Session session, String message) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    /**
     * 群发消息
     */
    private static void sendGroupMessage(String message) {
        for (Session eachSession : currentSessions.keySet()) {
            try {
                eachSession.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}