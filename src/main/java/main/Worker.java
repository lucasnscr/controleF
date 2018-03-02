package main;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Worker {
	
	private static final String TASK_QUEUE_NAME = "task_queue";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		
		ConnectionFactory factory =  new ConnectionFactory();
		factory.setHost("localhost");
		final Connection connection =  factory.newConnection();
		final Channel channel =  connection.createChannel();
		
		channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
		System.out.println("[x] Waiting for messages. To exit press CTRL+C");
		
		channel.basicQos(1);
		
		final Consumer consumer =  new DefaultConsumer(channel) {
			public void handleDelivery(String consumerTag, Envelope envolope,
					AMQP.BasicProperties properties, byte[] body) throws IOException {
				
				String message = new String(body, "UTF-8");
				System.out.println(" [X] Received' " + message + "'");
				try {
					doWork(message);
				} finally {
					System.out.println("[x] Done");
					channel.basicAck(envolope.getDeliveryTag(), false);
				}
				
			}
		};
		channel.basicConsume(TASK_QUEUE_NAME, false, consumer);
	}
	
	private static void doWork(String task) {
		for (char ch : task.toCharArray()) {
			if(ch == '.') {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					Thread.currentThread().isInterrupted();
				}
			}
			
		}
	}

}
