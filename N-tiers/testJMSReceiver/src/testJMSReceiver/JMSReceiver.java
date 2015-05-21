package testJMSReceiver;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/MyQueue"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class JMSReceiver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		TextMessage castedMessage = (TextMessage) message;
		try {
			String text = castedMessage.getText();
			System.out.println(text);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}

	}

}
