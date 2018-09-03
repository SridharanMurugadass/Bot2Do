package com.codenotfound.jms;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteTopic {
	
	private static final String JMS_PROVIDER_URL = "tcp://127.0.0.1:61616";
	
	
	@GetMapping("/deleteTopic/{topic}")
	public String deleteTopic(@PathVariable String topic) throws Exception{
		

		 ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(JMS_PROVIDER_URL);
		    ActiveMQConnection connection = (ActiveMQConnection) connectionFactory.createConnection();

		    connection.destroyDestination(new ActiveMQQueue(topic));
		    
		    connection.close();
		
		
		return "success";
	}

	

}
