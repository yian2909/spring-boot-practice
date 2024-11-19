package top.xg.springboot.websocket.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lenovo
 */
@Component
@ServerEndpoint("/server/{uid}")
@Slf4j
public class WebSocketServer {
    private static int onlineCount = 0;
    private static final ConcurrentHashMap<String, WebSocketServer> WEB_SOCKET_MAP = new ConcurrentHashMap<>();
    private Session session;
    private String uid = "";

    @OnOpen
    public void onOpen(Session session, @PathParam("uid") String uid) {
        this.session = session;
        this.uid = uid;
        if (WEB_SOCKET_MAP.containsKey(uid)) {
            WEB_SOCKET_MAP.remove(uid);
            WEB_SOCKET_MAP.put(uid, this);
        }else {
            WEB_SOCKET_MAP.put(uid, this);
            addOnlineCount();
        }
        log.info("用户{}连接成功,当前在线人数为：{}", uid, getOnlineCount());
        try{
            sendMessage("连接成功");
        }catch (IOException e){
            log.error("用户{}网络异常!",uid,e);
        }
    }

    @OnClose
    public void onClose() {
        if (WEB_SOCKET_MAP.containsKey(uid)) {
            WEB_SOCKET_MAP.remove(uid);
            subOnlineCount();
        }
        log.info("用户{}退出，当前在线人数为:{}", uid, getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message,Session session) {
        log.info("用户{}发送报文:{}", uid, message);
        if (StringUtils.isNotBlank(message)) {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String,String> map = objectMapper.readValue(message, new TypeReference<>() {});
                map.put("fromUID", this.uid);
                String toUID = map.get("toUID");
                if (StringUtils.isNotBlank(toUID) && WEB_SOCKET_MAP.containsKey(toUID)) {
                    WEB_SOCKET_MAP.get(toUID).sendMessage(objectMapper.writeValueAsString(map));
                }else {
                    log.error("请求目标用户{}不在该服务器上",toUID);
                }
            }catch (Exception e){
                log.error("用户{}发送消息异常!",uid,e);
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("用户{}处理消息错误,原因{}",this.uid,error.getMessage());
        error.printStackTrace();
    }

    private void sendMessage(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    public static void sendInfo(String message, @PathParam("uid")String uid) throws IOException {
        log.info("发送消息到用户{}发送的报文:{}", uid, message);
        if (!StringUtils.isEmpty(uid) && WEB_SOCKET_MAP.containsKey(uid)){
            WEB_SOCKET_MAP.get(uid).sendMessage(message);
        } else {
            log.error("用户{}不在线!",uid);
        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }
}
