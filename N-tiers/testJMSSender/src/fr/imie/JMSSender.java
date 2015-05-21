package fr.imie;

import java.io.IOException;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JMSSender
 */
@WebServlet("/JMSSender")
public class JMSSender extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "java:/jms/queue/MyQueue")
	Destination destination;

	@Resource(name = "java:/ConnectionFactory")
	ConnectionFactory connectionFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JMSSender() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection connection;
		try {
			connection = connectionFactory.createConnection("jmsSender", "jmsSender");

			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(destination);
			TextMessage message = session.createTextMessage("hello");
			producer.send(message);
			connection.close();
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}

}
