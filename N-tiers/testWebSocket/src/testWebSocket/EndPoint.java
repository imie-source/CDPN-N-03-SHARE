/**
 * 
 */
package testWebSocket;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author imie
 *
 */
@ServerEndpoint("/endPoint")
public class EndPoint {
	
	@OnOpen
	public void open(Session session) {
		System.out.println("open");
	}
	@OnClose
	public void close(Session session, CloseReason c) {
		System.out.println("close");
	}
		
	@OnMessage
	public void receiveMessage(String message, Session session) {
		System.out.println(message);
		try {
			session.getBasicRemote().sendText(message);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}


}
