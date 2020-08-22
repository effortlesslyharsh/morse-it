package com.morseit.messaging.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.morseit.messaging.model.PrivateMessage;
import com.morseit.messaging.utility.MorseItConstants;

/**
 * @author Harsh
 *
 */
@Component
public class MorseItChatConsumerHandler {
	 @Autowired
	    SimpMessagingTemplate template;

	    @KafkaListener(
	            topics = MorseItConstants.KAFKA_BROKER.MESSAGE_TOPIC
	    )
	    public void listen(PrivateMessage privateMessage) {
	        System.out.println("sending via kafka listener..");
	        template.convertAndSend("/topic", privateMessage);
	    }
	    
	    
	    
	    @MessageMapping("/sendMessage")
	    @SendTo("/topic")
	    public PrivateMessage broadcastGroupMessage(@Payload PrivateMessage privateMessage) {
	        return privateMessage;
	    }
}
