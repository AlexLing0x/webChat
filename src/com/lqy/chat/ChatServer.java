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
 * ��������
 */
@ServerEndpoint("/websocket")
public class ChatServer {
	private static final Set<Session> clients = new HashSet<Session>();
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	private Session deleteSession;
	
	@OnOpen
	public void open(Session session) { //��ӳ�ʼ��
		clients.add(session);
		deleteSession = session;
	}
	
	/*
	 * ���ܿͻ��˵���Ϣ������������Ϣ���͸������Ѿ����ӵĻỰ
	 * @param message �ͻ��˵���Ϣ
	 * @param session �ͻ��˵ĻỰ
	 */
	@OnMessage
	public void getMessage(String message,Session session) {
		JSONObject jsonObject = JSONObject.fromObject(message);//����Ϣ������JSON����
		jsonObject.put("date",DATE_FORMAT.format(new Date()));//����Ϣ����ӷ���ʱ��
		//����Ϣ���͸��������ӵĻỰ
		for(Session openSession : clients) {
			jsonObject.put("isSelf", openSession.equals(session));//��ӱ�Ǳ�����Ϣ�Ƿ��ǵ�ǰ�Ự������
			//����JSON��ʽ����Ϣ�� getAsyncRemote()�Ƿ�����ʽ��(�첽),��getBasicRemote()������ʽ(ͬ��)
			openSession.getAsyncRemote().sendText(jsonObject.toString());
		}
	}
	
	@OnClose
	public void close() {
		clients.remove(deleteSession);//�رջỰ
	}
	
	@OnError
	public void error(Throwable t) {
		//������
	}
	
}