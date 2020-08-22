package com.morseit.messaging.endpoint;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.morseit.messaging.model.PrivateMessage;
import com.morseit.messaging.utility.MorseItConstants;

@RestController
public class MorseItChatPushHandler {
	@Autowired
	private KafkaTemplate<String, PrivateMessage> kafkaMessageTemplate;

	@PostMapping(value = "/endpoint/pushMessage", consumes = "application/json", produces = "application/json")
	public void sendMessage(@RequestBody PrivateMessage privateMessage) {
		try {
			privateMessage.setuUID(UUID.randomUUID().toString());
			privateMessage.setSentDate(Calendar.getInstance().getTime().toLocaleString());
			kafkaMessageTemplate.send(MorseItConstants.KAFKA_BROKER.MESSAGE_TOPIC, privateMessage).get();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
