package main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RecvMQ {
	
	private static final String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection =  factory.newConnection();
		Channel channel = connection.createChannel();
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println("[x] Waitin for messages. To exit press CTRL+C");
		
		Consumer consumer = new DefaultConsumer(channel) {
			@SuppressWarnings("unused")
			public void handledDelivery(String consumerTag, Envelope envelope,
					AMQP.BasicProperties propeties, byte[] body) throws UnsupportedEncodingException {
				
				String message =  new String(body, "UTF-8");
				System.out.println("[x] Received '" + message + "'");
				
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}
