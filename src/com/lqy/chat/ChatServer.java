package com.lqy.chat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONObject;

/*
 * 服务器类
 */
@ServerEndpoint("/websocket")
public class ChatServer {
	private static final Set<Session> clients = new HashSet<Session>();
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	private Session deleteSession;
	
	@OnOpen
	public void open(Session session) { //添加初始化
		clients.add(session);
		deleteSession = session;
	}
	
	/*
	 * 接受客户端的消息，并把所有消息发送给所有已经连接的会话
	 * @param message 客户端的消息
	 * @param session 客户端的会话
	 */
	@OnMessage
	public void getMessage(String message,Session session) {
		JSONObject jsonObject = JSONObject.fromObject(message);//将消息解析成JSON对象
		jsonObject.put("date",DATE_FORMAT.format(new Date()));//在消息中添加发送时间
		//把消息发送给所有连接的会话
		for(Session openSession : clients) {
			jsonObject.put("isSelf", openSession.equals(session));//添加标记本条消息是否是当前会话自身发的
			//发送JSON格式的消息； getAsyncRemote()是非阻塞式的(异步),和getBasicRemote()是阻塞式(同步)
			openSession.getAsyncRemote().sendText(jsonObject.toString());
		}
	}
	
	@OnClose
	public void close() {
		clients.remove(deleteSession);//关闭会话
	}
	
	@OnError
	public void error(Throwable t) {
		//错误处理
	}
	
}